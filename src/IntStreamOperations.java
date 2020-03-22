import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args){
        int[] values = {3,10,6,1,4,8,2,5,9,7};

        //display original values
        System.out.print("Original values:");
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
        System.out.println("Average:" + average);

        //get sum of square of each int

        int sumOfProduct = IntStream.of(values)
                                    .reduce(0,(x, y) -> x + y*y);

        //even value displayed in sorted order
        IntStream.of(values)
                .filter(v -> v%2 ==0)
                .sorted()
                .forEach(System.out::println);

        int[] testValues = IntStream.of(values)
                .filter(v -> v%2 ==0)
                .sorted()
                .toArray();

        /**
         * IntStream不能使用collect()方法
          */
        //odd values multiplied by 10 and displayed in sorted order
      IntStream.of(values)
                .filter(v -> v%2 != 0)
                .map(v -> v*10)
                .sorted()
                .forEach(System.out::println);
    }
}
