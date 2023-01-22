import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LearnOptional {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Optional<Progress> progress = spring_boot.getProgress();
        // progress에 대한 null 체크는 어떻게 할까?
        if (progress != null) {
            System.out.println(progress);
        }
        // 문제점
        /*
         * 1. null을 리턴하는 것 자체가 문제임
         * 2. nullPointerException을 던질 때에 대한 처리가 두 가지 선택밖에 없음
         *   2.a 에러 Exception
         *   2.b null을 그냥 리턴하고 이에 대한 처리로직을 따로 짜줌
         * */
        // 해결법 :: Optional로 리턴을 감싸서 리턴
        /*
         * return progress
         * => return Optional.ofNullable(progress);
         * */
        // 입력에 대한 Null 필터링을 하면 안 되는가?
        /*
         * null 자체를 넣어줄 수 있으므로 이 자체로 nullPointerException을 던질 가능성이 있음
         * setProgress(Optional<Progress> progress){...}
         * => setProgress(null); 호출 가능
         * */

    }
}
