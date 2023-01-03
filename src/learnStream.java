import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class learnStream {
    public static void main(String[] args) {
        List<String> listOfName = new ArrayList<>();
        listOfName.add("jihoon");
        listOfName.add("teahoon");
        listOfName.add("hwangseungkyu");

        /*
        # 스트림은 데이터를 저장하는 저장소가 아니다!
        아래와 같이 upperCase로 변환 처리를 하더라도, 저장하지 않기 때문에
        찍어봐도 소문자로 저장되어 있는 것을 확인할 수 있다.
        */
        Stream<String> stringStream = listOfName.stream()
                .map(String::toUpperCase);
        listOfName.forEach(System.out::println);
    }
}
