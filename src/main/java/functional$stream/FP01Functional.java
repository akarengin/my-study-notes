package functional$stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP01Functional {

    private final String brand;
    private final int frameSize;

    public FP01Functional(String brand) {
        this.brand = brand;
        this.frameSize = 0;
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                //.filter(x -> x%2 ==0)
                .collect(Collectors.toList());
    }

    private  static boolean isEven(int number) {
        return number%2==0;
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {

        numbers.stream()
                //.filter(FP01Functional::isEven)
                .filter(predicate)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<? super Integer> isEvenPredicate = s -> s % 2 == 0;

        filterAndPrint(numbers, isEvenPredicate);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
        courses.stream()
            .map(String::toUpperCase)        /* instance method call */
            .forEach(System.out::println);   /* static method call */

        Supplier<String > supplier = () -> new String(); //String::new;  /* constructor call */

/*        courses.stream()
                //.filter(c -> c.contains("Spring"))
                //.filter(s -> s.length() >= 4)
                .map(s -> s + " " +s.length())
                .forEach(System.out::println);*/

        System.out.println(courses.stream().allMatch(c -> c.length() > 3));

        System.out.println(courses.stream().noneMatch(c -> c.length() < 3));

        System.out.println(courses.stream().anyMatch(c -> c.length() < 3));

        courses.stream()
                .sorted(Comparator.comparing(s -> s.length()))
                .forEach(System.out::println);

/*        List<Integer> lenghts = courses.stream()
                .map(x -> x.length())
                .collect(Collectors.toList());
        System.out.println(lenghts);*/

        Function<? super Integer, ? extends Integer> squareFunction = x -> x * x;

        Consumer<Integer> sysoutConsumer = System.out::println;

        BinaryOperator<Integer> sum = Integer::sum;

        Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt(1000);

        System.out.println(randomIntegerSupplier.get());

        BinaryOperator<Integer> sum2 = new BinaryOperator<Integer> () {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        numbers.stream()
                //.filter(isEvenPredicate)
                //.map(squareFunction)
/*                .mapToInt(x -> x)
                  .sum();*/
                //.reduce(0, (a,b) -> a+b);
                .reduce(0, sum2);
                //.forEach(sysoutConsumer);

        //System.out.println(sum);

        Function<Integer, Integer> mappingFunction = x -> x * x;

        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
        bikeBrands.stream()
                .map(FP01Functional::new);

        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, mappingFunction);

        List<Integer> squaredNumberList = mapAndCreateNewList(numbers, x -> x*x);
        System.out.println("SquaredNumberList: " + squaredNumberList);

        BiPredicate<Integer, String> biPredicateI = new BiPredicate<Integer, String>() {
            @Override
            public boolean test(Integer num, String str) {
                return num < 10 && str.length() > 5;
            }
        };

        BiPredicate<Integer, String> biPredicateII = (num, str) -> {
            return num < 10 && str.length() > 5;
        };

        BiPredicate<Integer, String> biPredicateIII = (num , str) -> num < 10 && str.length() > 5;

        System.out.println(biPredicateIII.test(5, "myTestValue"));

    }

}
