package functional$stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {

//	@FunctionalInterface public class Supplier<T> {
//		public T get();
//	}

//	@FunctionalInterface
//	public class Consumer<T> {
//		void accept(T t);
//	}
//
//	@FunctionalInterface
//	public class BiConsumer<T, U> {
//		void accept(T t, U u);
//	}

//	@FunctionalInterface
//	public class Predicate<T> {
//		boolean test(T t);
//	}
//
//	@FunctionalInterface
//	public class BiPredicate<T, U> {
//		boolean test(T t, U u);
//	}

//	@FunctionalInterface public class Function<T, R> {
//		R apply(T t);
//	}
//
//	@FunctionalInterface public class BiFunction<T, U, R> {
//		R apply(T t, U u);
//	}

//	@FunctionalInterface
//	public class UnaryOperator<T> extends Function<T, T> {
//	}
//
//	@FunctionalInterface
//	public class BinaryOperator<T> extends BiFunction<T, T, T> {
//	}

    public static void main(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
        ArrayList<String> a1 = s3.get();
        System.out.println(a1);

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie");
        c2.accept("Annie");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

        b1.accept("Chicken", 7);
        b2.accept("Chick", 3);

        System.out.println(map);

        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        BiPredicate<String, String> e1 = String::startsWith;
        BiPredicate<String, String> e2 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(e1.test("chicken", "chick"));
        System.out.println(e2.test("chicken", "chick"));

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");

        Predicate<String> brownEggs1 = egg.and(brown); // Better way!
        Predicate<String> otherEggs1 = egg.and(brown.negate());

        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println(f1.apply("cluck"));
        System.out.println(f2.apply("cluck"));

        BiFunction<String, String, String> g1 = String::concat;
        BiFunction<String, String, String> g2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(g1.apply("baby ", "chick"));
        System.out.println(g2.apply("baby ", "chick"));

        UnaryOperator<String> u1 =  String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));

        BinaryOperator<String> y1 =  String::concat;
        BinaryOperator<String> y2 = (string, toAdd) -> string.concat(toAdd);
        System.out.println(y1.apply("baby ", "chick"));
        System.out.println(y2.apply("baby ", "chick"));

    }
}

