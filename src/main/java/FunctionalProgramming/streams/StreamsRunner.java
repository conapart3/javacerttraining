package FunctionalProgramming.streams;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsRunner
{
    public static void main(String[] args)
    {
        Stream<String> empty = Stream.empty();
        Stream<Integer> single = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // these are varargs letting you pass in multiple and turns it into an array

        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> fromList = list.stream();
        Stream<Integer> parallelStream = list.parallelStream();

        Stream.generate(Math::random);
        Stream.iterate(5, n -> n+2);// starting at 5, increments n by 2 for an infinite stream.

        List<String> strlist = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "z", "b", "2", "", "dawdwa");
        Stream<String> stringStream1 = strlist.stream();
        Stream<String> stringStream2 = strlist.stream();

        Comparator<String> stringComparisonByBytes = (o1, o2) -> {
            try
            {
                System.out.println("o1: " + o1.getBytes("ISO-8859-1").length + ", o2: " + o2.getBytes("ISO-8859-1").length);
                return o1.getBytes("ISO-8859-1").length - o2.getBytes("ISO-8859-1").length;
            }
            catch (UnsupportedEncodingException e)
            {
                System.out.println("Failed to get ISO-8859-1 bytes. Using default.");
                return o1.getBytes().length - o2.getBytes().length;
            }
        };
        Optional<String> minOptional = stringStream1.min(stringComparisonByBytes);
        Optional<String> maxOptional = stringStream2.max(stringComparisonByBytes);
        Consumer<String> tConsumer = (s) -> System.out.println(s.length() != 0 ? s : "the string was empty!");
        minOptional.ifPresent(tConsumer);
        maxOptional.ifPresent(tConsumer); // note that we use the same Comparator in the same order, but we use max() which gets the other end from min()

        strlist.forEach(s -> System.out.print(s));
        System.out.println();
        strlist.stream().forEach(s -> System.out.print(s));

        System.out.println();



    }
}
