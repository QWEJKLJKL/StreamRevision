package exercise1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args){
        int[] values = {2,9,5,0,3,7,1,4,8,6};

        IntStream.of(values)
                .forEach(System.out::println);

        //count
        System.out.println("Count: " + IntStream.of(values).count());

        //min
        System.out.println("Min: " + IntStream.of(values).min().getAsInt());

        //max
        System.out.println("Max:" + IntStream.of(values).max().getAsInt());

        //sum
        System.out.println("sum: " + IntStream.of(values).sum());

        //average
        System.out.println("Average: " + IntStream.of(values).average().getAsDouble());

        //Sum by reduced method
        System.out.println("Sum(Reduced Method): " + IntStream.of(values).reduce(0, (x , y) -> x + y));

        //Sum of square by reduced method
        System.out.println("Sum of square by reduced method:" + IntStream.of(values).reduce(0,(x,y) -> x + y*y));

        //Even values, times 10, sorted order
        IntStream.of(values).filter(value -> (value%2)==0)
                            .map(value -> value*10)
                            .sorted()
                            .forEach(System.out::println);
    }

}

