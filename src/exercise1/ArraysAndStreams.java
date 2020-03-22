package exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
    public static void main(String[] args){
        Integer[] values = {2,9,5,0,3,7,1,4,8,6};

        //集合里面只能储存对象
        List<Integer> valuesList = Arrays.asList(values);
        valuesList.forEach(System.out::println);

        //排序并转换会list
        List<Integer> sortedList = valuesList.stream()
                                            .sorted()
                                            .collect(Collectors.toList());
        sortedList.forEach(System.out::println);

        //取大于四并排序,并且嵌入一条print打印输出
        System.out.printf("%s",valuesList.stream().filter(v -> v > 4).sorted().collect(Collectors.toList()));
    }
}
