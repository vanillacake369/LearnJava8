import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPractice {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring 으로 시작하는 수업");
        // TODO
        /*List<String> classesStartswithSpring = springClasses.stream()
                .map(s -> s.getTitle())
                .filter(s -> s.startsWith("spring"))
                .collect(Collectors.toList());
        classesStartswithSpring.forEach(System.out::println);*/
        // 오 존나 재밌어
        // 근데 반환하지 않고 처음 소스(classesStartswithSpring)를 그대로 쓰기 위해 그대로 삽입 x?
        // yes. 왜냐면 terminal op들은 대부분 특정 타입의 객체들을 모아서 반환하기 때문임!

//        System.out.println("close 되지 않은 수업");
        // TODO
        /*// 내가 구현한 코드
        springClasses.stream()
                .filter(eachClass -> !eachClass.isClosed())
                .collect(Collectors.toList())
                .stream()
                .forEach((eachClass) -> {
                    System.out.println(eachClass.getTitle());
                });
        // 백기선님 코드
        // Predicate라는 Functional Interface에서
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));*/

//        System.out.println("수업 이름만 모아서 스트림 만들기");
        // TODO
        /*springClasses.stream()
                .map(oc -> oc.getTitle())
                .forEach(System.out::println);*/

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // TODO
        // keesunEvents <- springClasses, javaClasses
        keesunEvents.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));


        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        // TODO
        // 1. 무한 순차 스트림 만들기 :: IntStream.iterate(seed,iterate condition)
        // 2. intermediate stream operation으로서 skip,limit 함수 호출
        // 3. terminal opertion으로서 forEach 호출
        IntStream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        // TODO
        System.out.println(javaClasses.stream()
                .anyMatch(jc -> jc.getTitle()
                        .contains("Test")));

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        // TODO
        // filter : filter condition 에 해당하는 object 모으기
        // map : map condition 에 맞는 해당 데이터 모으기 (즉, 반환값이 map condition 데이터 타입임)
        List<OnlineClass> ocContainingSpring = springClasses.stream()
                .filter(sc -> sc
                        .getTitle()
                        .contains("spring"))
                .collect(Collectors.toList());

        ocContainingSpring.stream()
                .map(spring -> spring.getTitle())
                .forEach(System.out::println);


    }
}
