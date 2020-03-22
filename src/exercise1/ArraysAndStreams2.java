package exercise1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args){
        String[] strings =
                {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
        int[] values = {1,2,3};
       //String转大写
        Arrays.stream(strings)
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        //Strings less than "n"(case insensitive) sorted ascending
        List<String> sortedStrings = Arrays.stream(strings)
                                            .filter(str -> str.compareToIgnoreCase("n") < 0)
                                            .sorted()
                                            .collect(Collectors.toList());
        sortedStrings.forEach(System.out::println);
    }
}
