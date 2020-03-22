package exercise2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
    public static void main(String[] args){
        Integer[] values = {2,9,5,0,3,7,1,4,8,6};
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
                .filter(v -> v > 4)
                .sorted()
                .collect(Collectors.toList());

    }
}
