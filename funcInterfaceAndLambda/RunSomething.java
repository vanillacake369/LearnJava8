@FunctionalInterface
// 어노테이션 동작 방법은 더 자바 코드를 조작하는 방법 참고
public interface RunSomething {
    // abstract 생략해도 모두 다 abstract
    int doIt(int number);

    // 정적 메서드
    static void printName() {
        System.out.println();
    }

    // default 메서드
    default void printAge() {
        System.out.println("40");
    }
}
