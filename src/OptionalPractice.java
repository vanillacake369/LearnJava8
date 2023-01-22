import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalPractice {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses
                .stream()
                .filter(oc -> oc.getTitle()
                        .startsWith("spring"))
                .findFirst();
        boolean present = optional.isPresent();
        System.out.println(present);
        // ifPresent()ㄹ
        // : 여기서 없는 아이템을 꺼내게 되면 런타임 에러를 던지므로 아래와 같이 코딩한다.
        System.out.println(optional.get()
                .getTitle()); // (X)
        optional.ifPresent(oc -> System.out.println(oc.getTitle())); // (O)

        // orElse() : 있으면 꺼내오고, 없으면 주어진 메서드(createNewClass())를 호출해라
        OnlineClass optional1 = optional.orElse(createNewClass());

        // orElseThrow() : 있으면 꺼내오고, 없으면 exception(Supplier)를 실행하라.
        OnlineClass optional2 = optional.orElseThrow(IllegalStateException::new);
        System.out.println(optional2.getTitle());

        // Optional<T> 로 받은 스트림에 대해서는 스트림 수행 결과가 Optional로 돌아온다 :: Null에 대한 처리가 가능하여 좋다
        // #1 filter
        Optional<OnlineClass> optionalOnlineClass = optional.filter(OnlineClass::isClosed);
        // #2 map :: 단 map으로 변환한 타입이 Optional인 경우에 대해 주의해야한다. => flatMap을 사용하여 Optional 껍질을 모두 까줄 수 있다.
        Optional<Integer> optionalInteger = optional.map(OnlineClass::getId);
        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);     // Optional을 두 번 까야됨
        Optional<Progress> progressOptional =optional.flatMap(OnlineClass::getProgress);    // flatMap으로 한 번에 처리
    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10, "New Class", false);
    }
}
