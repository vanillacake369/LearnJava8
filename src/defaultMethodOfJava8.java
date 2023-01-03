import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class defaultMethodOfJava8 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesum");
        name.add("whiteship");
        name.add("toby");
        name.add("vanilla");
        name.add("foo");

        // list에 대한 spliterator 선언
        Spliterator<String> spliterator = name.spliterator();
        /* Spliterator<T> trySplit()
         * a Spliterator covering some portion of the elements, or null if this spliterator cannot be split
         * */
        Spliterator<String> spliterator1 = spliterator.trySplit();
        /* boolean tryAdvance(Consumer<? super T> action)
         * If a remaining element exists, performs the given action on it, returning true; else returns false.
         * */
        while (spliterator.tryAdvance(System.out::println)) ;
        System.out.println("----");
        while (spliterator1.tryAdvance(System.out::println)) ;
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());

    }
}
