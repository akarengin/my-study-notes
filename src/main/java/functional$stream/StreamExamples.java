package functional$stream;

import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExamples {

    static class ExceptionCaseStudy {
        private static List<String> create() throws IOException {
            throw new IOException();
        }

        public static void main(String[] args) throws IOException {
            ExceptionCaseStudy.create().stream().count();

            Supplier<List<String>> s = () -> {
                try {
                    return ExceptionCaseStudy.create();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    throw new RuntimeException(e);
                }
            };

            Supplier<List<String>> s2 = ExceptionCaseStudy::createSafe;

        }

        private static List<String> createSafe() {
            try {
                return ExceptionCaseStudy.create();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n).filter(s -> s.length() == 3).ifPresent(System.out::println);
    }

    private static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0)
            throw new RuntimeException();
        return stats.getMax() - stats.getMin();
    }

    public static Integer rest(BiFunction<Integer, Double, Integer> takeABreak) {
        return takeABreak.apply(3, 10.2);
    }

    public static void main(String[] args) {

        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        Stream<Double> randoms = Stream.generate(Math::random);
        // randoms.forEach(System.out::println); // infinite loop due to infinite stream
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        // oddNumbers.forEach(System.out::println); // infinite loop due to infinite
        // stream

        Stream<String> st = Stream.of("monkey", "ape", "bonobo");
        // System.out.println(st.count());
        Optional<String> min = st.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());

        Stream<String> s = Stream.of("pen", "eraser");
        Stream<String> infinite = Stream.generate(() -> "pencil sharpener");
        s.findAny().ifPresent(System.out::println);
        infinite.findAny().ifPresent(System.out::println);

        List<String> list1 = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite1 = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list1.stream().anyMatch(pred));
        System.out.println(list1.stream().allMatch(pred));
        System.out.println(list1.stream().noneMatch(pred));
        System.out.println(infinite1.anyMatch(pred));

        Stream<String> st1 = Stream.of("Monkey", "Gorilla", "Bonobo");
        st1.forEach(System.out::print);

//		Stream d = Stream.of(1, 3, 5);	// DOES NOT COMPILE!
//		for(Integer i : d) {    		// Can only iterate over an array or an instance of java.lang.Iterable
//										// Streams don't implement Iterable interface
//
//		}

        Stream<String> w = Stream.of("w", "o", "l", "f");
        String word = w.reduce("", (z, c) -> z + c);
        // OR String word = stream.reduce("", String::concat);
        System.out.println("\nWord:" + word);

        Stream<Integer> stream = Stream.of(3, 5, 6);
        System.out.println(stream.reduce((a, b) -> a * b)); // In many cases, the identity isn't really necessary,
        // so Java lets us omit it.
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty1 = Stream.empty();
        Stream<Integer> oneElement = Stream.of(4);
        Stream<Integer> threeElement = Stream.of(6, 8, 10);
        empty1.reduce(op).ifPresent(System.out::print); // no output
        oneElement.reduce(op).ifPresent(System.out::println);
        threeElement.reduce(op).ifPresent(System.out::println);

        Stream<Integer> stream1 = Stream.of(3, 5, 6);
        System.out.println(stream1.reduce(1, op, op));

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        StringBuilder word1 = stream2.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word1);

        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream3.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set);

        Stream<String> stream4 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set1 = stream4.collect(Collectors.toCollection(TreeSet::new));

        Stream<String> stream5 = Stream.of("w", "o", "l", "f");
        Set<String> set2 = stream5.collect(Collectors.toSet()); // unsorted
        System.out.println("Set2: " + set2);

        Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
        s1.filter(x -> x.startsWith("m")).forEach(System.out::println);

        Stream<Integer> s6 = Stream.iterate(1, n -> n + 1);
        s6.skip(5).limit(2).forEach(System.out::println);

        Stream<String> s7 = Stream.of("monkey", "gorilla", "bonobo");
        s7.map(String::length).forEach(System.out::print);

        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(l -> l.stream()).forEach(System.out::println);

        Stream<String> s8 = Stream.of("brown-", "bear-");
        s8.sorted().forEach(System.out::println);

        Stream<String> s9 = Stream.of("brown bear-", "grizzly-");
        s9.sorted(Comparator.reverseOrder()).forEach(System.out::println);
        // s9.sorted(Comparator::reverseOrder); // DOES NOT COMPILE!

        Stream<String> s10 = Stream.of("black bear", "brown bear", "grizzly");
        long count = s10.filter(x -> x.startsWith("g")).peek(System.out::println).count();
        System.out.println(count);

        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        letters.add('a');
        Stream<List<?>> s11 = Stream.of(numbers, letters);
        s11.map(List::size).forEach(System.out::println);
        System.out.println("Here!");

        StringBuilder builder = new StringBuilder();
        Stream<List<?>> good = Stream.of(numbers, letters);
        good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::println);
        System.out.println("builder :" + builder);

        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.peek(l -> l.remove(0)).map(List::size)
                .forEach(System.out::println); /*
         * This example is bad because peek() is modifying the data structure
         * that is used in the stream
         */
        List<String> list2 = Arrays.asList("Anna", "Toby", "Leroy", "Alex");
        list2.stream().filter(n -> n.length() == 4).sorted().limit(2).forEach(System.out::println);

        Stream<Integer> s12 = Stream.of(1, 2, 3);
        System.out.println(s12.mapToInt(x -> x).sum());

        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        avg.ifPresent(System.out::println);
        System.out.println(avg.getAsDouble());
        System.out.println(avg.orElseGet(() -> Double.NaN));

        IntStream count1 = IntStream.iterate(1, n -> n + 1).limit(5);
        count1.forEach(System.out::println);

        IntStream ranged = IntStream.range(1, 6);
        ranged.forEach(System.out::print);

        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream1 = objStream.mapToInt(x -> x.length());

        List<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(9);
        IntStream ints = myList.stream().flatMapToInt(y -> IntStream.of(y));
        ints.forEach(System.out::println);

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result);

        Stream<String> ohMy1 = Stream.of("lions", "tigers");
        Double result1 = ohMy1.collect(Collectors.averagingInt(String::length));
        System.out.println(result1);

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears", "eagle");
        TreeSet<String> result2 = ohMy2.filter(x -> x.startsWith("t")).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result2);

        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears", "eagle", "turtle");
        Map<String, Integer> map = ohMy3.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("map: " + map);

        Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears", "eagle", "turtle");
        Map<Integer, String> map1 = ohMy4
                .collect(Collectors.toMap(String::length, k -> k, (x1, x2) -> x1 + "-" + x2, TreeMap::new));
        System.out.println("map1: " + map1);
        System.out.println(map1.getClass());

        Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map2 = ohMy5.collect(Collectors.groupingBy(String::length));
        System.out.println("Map2: " + map2);

        Stream<String> ohMy6 = Stream.of("lions", "tigers", "tigers", "bears");
        TreeMap<Integer, Set<String>> map3 = ohMy6
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println("Map3: " + map3);

        Stream<String> ohMy7 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map4 = ohMy7.collect(groupingBy(String::length, Collectors.counting()));
        System.out.println("map4: " + map4);

//        Stream<String> ohMy8 = Stream.of("lions", "tigers", "bears");
//        Map<Integer, Optional<Character>> map5 = ohMy8
//                .collect(groupingBy(String::length, mapping(x -> x.charAt(0), minBy(Comparator.naturalOrder()))));
//        System.out.println("map5: " + map5);

        /*--- examples ---*/

        List<String> copy = new ArrayList<>(list);
        copy.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());

        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList();
        Stream.of(l1, l2, l3).flatMap(x -> x.stream()).map(x -> x + 1).forEach(System.out::print);

        rest((x, e) -> x.intValue() + e.intValue());

        Stream<String> qa = Stream.of("speak", "meow", "bark", "growl");
        BinaryOperator<String> merge = (a, b) -> a+b;
        Map<Integer, String> map0 = qa.collect(toMap(String::length, k -> k, merge));
        System.out.println("Map0:" + map0);
        System.out.println("*" + map0.size() + " " + map0.get(4));

        Stream<Boolean> bools = Stream.iterate(true, b -> !b);
        Map<Boolean, List<Boolean>> mapq = bools.limit(4).peek(System.out::print).collect(partitioningBy(b -> b));
        System.out.println("mapq:" + mapq);

        IntStream in = IntStream.empty();
        IntStream moreInts = IntStream.of(66, 77, 88);
        Stream.of(in, moreInts).flatMapToInt(x -> x).forEach(System.out::print);

        Stream<String> sv = Stream.of("over the river", "through the woods", "to grandmother's house we go");
        sv.filter(n -> n.startsWith("t"))
                .sorted(Comparator.reverseOrder())   // Comparator::reverseOrder --- DOES NOT COMPILE!
                .findFirst()
                .ifPresent(System.out::println);

        LongStream ty = LongStream.of(9);
        ty.mapToInt(p -> (int)p).forEach(System.out::print);
    }
}
