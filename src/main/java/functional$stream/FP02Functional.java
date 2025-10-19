package functional$stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP02Functional {

    public static void main(String[] args) {
        List<Course> courses = List.of(new CourseBuilder().setName("Spring").setCategory("Framework").setReviewScore(98).setNoOfStudents(20000).build(),
                new CourseBuilder().setName("Spring Boot").setCategory("Framework").setReviewScore(95).setNoOfStudents(18000).build(),
                new CourseBuilder().setName("Microservices").setCategory("Microservices").setReviewScore(96).setNoOfStudents(25000).build(),
                new CourseBuilder().setName("API").setCategory("Microservices").setReviewScore(98).setNoOfStudents(22000).build(),
                new CourseBuilder().setName("FullStack").setCategory("FullStack").setReviewScore(91).setNoOfStudents(14000).build(),
                new CourseBuilder().setName("AWS").setCategory("Cloud").setReviewScore(92).setNoOfStudents(21000).build(),
                new CourseBuilder().setName("Azure").setCategory("Cloud").setReviewScore(99).setNoOfStudents(21000).build(),
                new CourseBuilder().setName("Docker").setCategory("Cloud").setReviewScore(92).setNoOfStudents(21000).build(),
                new CourseBuilder().setName("Kubernetes").setCategory("Cloud").setReviewScore(91).setNoOfStudents(20000).build());


        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);

        Comparator<Course> comparingByCategory = Comparator.comparing(Course::getCategory);

        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore)
                .reversed();

        Predicate<Course> reviewScoreLessThan90 = x -> x.getReviewScore() < 90;

        Predicate<Course> reviewScoreGreaterThan95 = x -> x.getReviewScore() > 95;

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
/*                .skip(3)
                .limit(5)*/
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                //.takeWhile(course -> course.getReviewScore() >= 95)
                .dropWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .max(comparingByNoOfStudentsAndNoOfReviews));

        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90)
                //.min(comparingByNoOfStudentsAndNoOfReviews)  // Optional.Empty
                .findFirst()                                  // Optional.Empty
                .orElse(new Course("Kubernetes", "Cloud", 91, 2000)));

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95)
                //.findFirst()
                .findAny()
                .orElse(new Course("Kubernetes", "Cloud", 91, 2000)));

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95)
                .mapToInt(Course::getNoOfStudents)
                //.average());                        // OptionalDouble[22000.0]
                //.sum());                            // 88000
                //.count());                          // 4
                .max());                              // OptionalInt[25000]

        System.out.println(courses.stream()
                //.collect(Collectors.groupingBy(Course::getCategory)));
                /* => {Cloud=[AWS:21000:92, Azure:21000:99, Docker:21000:92, Kubernetes:20000:91], FullStack=[FullStack:14000:91],
                 Microservices=[Microservices:25000:96, API:22000:98], Framework=[Spring:20000:98, Spring Boot:18000:95]} */
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        // => {Cloud=4, FullStack=1, Microservices=2, Framework=2}

        System.out.println("Here I'm");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        // => {Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:98], Framework=Optional[Spring:20000:98]}

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));
        // => {Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[Microservices, API], Framework=[Spring, Spring Boot]}

        Stream<Integer> stream = Stream.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println(stream.count());

        int[] numberArray = {12, 9, 13, 4, 6, 2, 4, 12, 15};
        IntStream stream1 = Arrays.stream(numberArray);

        IntStream copyOfstream1 = IntStream.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println(Arrays.stream(numberArray).max());

        System.out.println(IntStream.range(1, 10).sum());

        System.out.println(IntStream.iterate(1, e -> e+2).limit(10).peek(System.out::println).sum());

        System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).boxed().collect(Collectors.toList()));

        System.out.println(LongStream.rangeClosed(3, 5).peek(System.out::println).reduce(3, (x, y) -> x * y)); // 180

        System.out.println(LongStream.rangeClosed(1, 5).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply)); // 120

        List<String> courseList = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
        System.out.println(courseList.stream().collect(Collectors.joining(",")));

        String[] s =  "Spring".split("");
        Stream.of(s).forEach(System.out::println);

        List<String> words = Arrays.asList("hello", "world");
        List<String> uniqueLetters = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                //.flatMap(c -> Stream.of(c.split("")))
                //.map(c -> c.split("")).flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueLetters);

        System.out.println(courseList.stream().map(c -> c.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
        System.out.println("COURSE_LIST: " + courseList.stream().flatMap(c -> Stream.of(c.split(""))).distinct().toList());

        List<String> courses1 = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
        List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        System.out.println(courses1.stream().flatMap(c1 -> courses2.stream().map(c2 -> List.of(c1, c2))).collect(Collectors.toList()));

        courses1.stream().flatMap(getStringStreamFunction(courses2)).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList());

        System.out.println("HERE HERE HERE:" + courses1.stream().flatMap(c1 -> courses2.stream().filter(c2 -> c2.length() == c1.length())
                .map(c2 -> List.of(c1, c2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));

        List<String> modifiableCourses = new ArrayList<>(courseList);
        modifiableCourses.replaceAll(str -> str.toUpperCase());
        System.out.println(modifiableCourses);

        modifiableCourses.removeIf(x -> x.length() < 6);
        System.out.println(modifiableCourses);

    }

    private static Function<String, Stream<? extends List<String>>> getStringStreamFunction(List<String> courses2) {
        return c -> courses2.stream().map(getStringListFunction(c));
    }

    private static Function<String, List<String>> getStringListFunction(String c) {
        return c2 -> List.of(c, c2);
    }

}
