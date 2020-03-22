package exercise2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args){
        String[] strings = {"Red","orange","Yellow","green","Blue","indigo","Violet"};

        //String in uppercase
        List<String> uppercase = Arrays.stream(strings)
                                        .map(s -> s.toUpperCase())
                                        .collect(Collectors.toList());

        System.out.println(uppercase);

        //strings less than "n"(case insensitive) sorted ascending
        List<String> sortString1 = Arrays.stream(strings)
                                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                                        .sorted(String.CASE_INSENSITIVE_ORDER)
                                        .collect(Collectors.toList());

        System.out.println(sortString1);

        //strings less than "n" (case insensitive) sorted descending

        List<String> sortString2 = Arrays.stream(strings)
                                        .filter(s -> s.compareTo("s") < 0)
                                        .sorted((s1,s2) -> s2.compareTo(s1))
                                        .collect(Collectors.toList());

        System.out.println(sortString2);
    }
}
