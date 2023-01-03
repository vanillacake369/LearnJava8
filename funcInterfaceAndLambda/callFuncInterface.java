import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class callFuncInterface {
    public static void main(String[] args) {
        // func that return input+100;
        Function<Integer, Integer> func1 = (input) -> input + 100;
        // func that return input*100;
        Function<Integer, Integer> func2 = (input) -> input * 3;

        // compose :: func2의 정책을 먼저 적용(higher order func)
        // input(3)에 3을 곱한뒤 100을 더함 :: 109
        int addAfterMultiply = func1.compose(func2)
                .apply(3);
        System.out.println(addAfterMultiply);

        // andThen :: 호출자의 정책을 먼저 적용
        // input(3)에 100을 더한 뒤 3을 곱합 :: 309
        int multiplyAfterAdd = func1.andThen(func2)
                .apply(3);
        System.out.println(multiplyAfterAdd);


    }

    private void run() {
//        final int baseNumber = 10;
// 원래는 내부/익명 클래스에 대해서 final변수를 지정해주었어야 함(final은 변경불가 변수)
        int baseNumber = 10;
        //effective final : 어디서도 변경하지 않는 경우 -> final 없이도 참조가 가능함

        // local class
        class LocalClasss {
            void printBaseNumber() {
                int baseNumber = 12;
                System.out.println(baseNumber); // 10(x) 12(o) :: '쉐도잉' 이라 함
            }
        }

        // anonymous classs
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
                // run()의 baseNumber 참조(x) param의 baseNumber(o)
            }
        };

        // lambda
        // 쉐도잉이 불가!! 람다의 스코프는 run() 내부!
        IntConsumer printInt = (i) -> {
            /*int baseNumber = 0; (x)*/
            System.out.println(i + baseNumber);
        };

        // lambda를 사용해서 기존 메소드를 레퍼런스 할 수 잇다!
        /*만약 아래와 같이 다른 클래스의 메소드가 있다 하자.
        class Greeting > void hi()
        람다는 이 메소드를 긁어올 수 있다.
        UnaryOperator<String> hi = Greeting::hi;

        ***다만 참조방법이 스태틱이냐, 어떤 종류의 객체냐, 생성자에 의한 참조냐에 따라 다름***

        스태틱 메소드 참조 (클래스 자체의 공동 메서드를 사용할 때!)
        -> 타입::스태틱 메소드
        특정 객체의 인스턴스 메소드 참조 (특정 객체의 메서드 사용할 때!)
        -> 객체 레퍼런스::인스턴스 메소드
        임의 객체의 인스턴스 메소드 참조 (반복을 하며 여러 객체마다 참조될 때,
                                        각각의 임의 객체의 메서드 사용할 때!!)
        -> 타입::인스턴스 메소드
        생성자 참조
        -> 타입::new
        */
    }
}
