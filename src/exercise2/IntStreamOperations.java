package exercise2;

import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args){
        int[] values = {3,10,6,1,4,8,2,5,9,7};

        //display original values
        System.out.print("original values:");
        IntStream.of(values)
                .forEach(value -> System.out.printf("%d ",value));

        System.out.println();

        //count
        System.out.printf("%nCount: %d%n", IntStream.of(values).count());

        //min
        System.out.printf("%nMin: %d%n",IntStream.of(values).min().getAsInt());

        //sum
        System.out.printf("%nSum: %d%n", IntStream.of(values).sum());

        //average
        System.out.printf("%n Average: %f%n", IntStream.of(values).average().getAsDouble());


        //get average by reduce method
        int average = IntStream.of(values)
                                .reduce(0,(x,y) -> x + y);
        System.out.println();

        int sumOfProduct = IntStream.of(values)
                                    .reduce(0,(x,y) -> x + y);

        System.out.println("QJJ " + sumOfProduct);
    }
}
