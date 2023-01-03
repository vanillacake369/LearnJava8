public class explainFuncInterface {
    public static void main(String[] args) {
        // 과거엔 익명 내부 클래스를 사용했었다.
      /*  RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello");
            }
        };
        // 만약 하나의 action이면 다음과 같이 줄일 수 있다.
        RunSomething runSomething = () -> System.out.println("hello");

        // 만약 여러 action이면 다음과 같이 작성할 수 있다.
        RunSomething runSomething = () -> {
            System.out.println("hello");
            System.out.println("Lambda");
            System.out.println("hello");
        };


        // 만약 외부 변수나 객체 내부 변수와 함수가 coupling,depend 되어있다면 이는 pure function이 아니다.
        // (O)
        RunSomething runSomething = (number) -> {
            return number + 10;
        };
        // (X) :: 클래스 외부 변수와 coupling
        int baseNum = 10;
        RunSomething runSomething = new RunSomething() {
            @Override
            public int doIt(int number) {
                return number + baseNum;
            }
        }
        // (X) :: 메서드 외부 변수와 coupling
        RunSomething runSomething = new RunSomething() {
            int baseNum = 10;

            @Override
            public int doIt(int number) {
                return number + baseNum;
            }
        }
*/
    }
}
