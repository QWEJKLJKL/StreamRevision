import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
    public static void main(String[] args){
        Integer[] values = {2,9,5,0,3,7,1,4,8,6};
        //Array转list
        List<Integer> valuesList = Arrays.asList(values);
        valuesList.forEach(System.out::println);

        System.out.println();
        valuesList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        valuesList.stream()
                .filter(v -> v > 4)
                .sorted()
                .forEach(System.out::println);

        valuesList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.printf("Values greater than 4(ascending with streams): %s%n",
                valuesList.stream()
                        .filter(v -> v > 4)
                        .sorted()
                        .collect(Collectors.toList()));
    }
}
