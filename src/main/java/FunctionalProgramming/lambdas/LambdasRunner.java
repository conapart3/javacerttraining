package FunctionalProgramming.lambdas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasRunner
{
    public static void main(String[] args)
    {
        new GorillaFamily().everyonePlay(true);

        Supplier<LocalDate> localDateSupplier = () -> LocalDate.now();
        Supplier<LocalDate> localDateSupplier2 = LocalDate::now;
        Function<String, LocalDate> localDateFunction = (s) -> LocalDate.now(ZoneId.of(s));

        System.out.println(localDateSupplier.get());
        System.out.println(localDateSupplier2.get());
        System.out.println(localDateFunction.apply("Z"));

        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        ArrayList<String> objects = listSupplier.get();
        System.out.println(objects);

        Stringify<Supplier<ArrayList<String>>> stringifiedSupplier = (supplier) -> supplier.get().toString();

        System.out.println(listSupplier);// this returns FunctionalProgramming.lambdas.LambdasRunner$$Lambda$11/1854731462@52cc8049
        // can you wrap the listSpplier in the Stringify finctional interface so it will actually print the contents?
        System.out.println(stringifiedSupplier);

        addToMap();

        List<String> eggAndSpoonList = Arrays.asList("greenspoon", "brownegg", "whiteegg");

        // turn this Predicate into returning an Optional
        Predicate<List<String>> brown = list -> list.stream().filter(s -> s.contains("brown")).findAny().isPresent();
//        OptionalPredicate<List<String>> brown = list -> list.stream().filter(s -> s.contains("brown")).findAny();
        Predicate<List<String>> egg = list -> list.stream().filter(s -> s.contains("egg")).findAny().isPresent();
        Predicate<List<String>> brownEgg = egg.and(brown);
        Predicate<List<String>> notBrownEggs = egg.and(brown.negate());

        System.out.println(brown.test(eggAndSpoonList));
        System.out.println(egg.test(eggAndSpoonList));
        System.out.println(brownEgg.test(eggAndSpoonList));
        System.out.println(notBrownEggs.test(eggAndSpoonList));

        // which lambdas will autobox and
//        Supplier<Long> longSupplier = () -> 34;
        Supplier<Integer> intSupplier = () -> (int)3.4;
        System.out.println(intSupplier.get());

        testAndUseOptionalWithFunctionalProgramming();
    }

    private static void testAndUseOptionalWithFunctionalProgramming()
    {
        Optional<String> stringOptional = Optional.of("exists!");
        Optional<String> nullOptiona = Optional.empty();
//        Optional<String> nullOptiona = Optional.ofNullable();


    }

    interface OptionalPredicate<T>{
        Optional<T> test(T t);
    }

    // make a consumer that adds to a map
    public static void addToMap()
    {
        Map<String, Integer> map = new HashMap<>();

        BiConsumer<String, Integer> mapAdderEveryTime = (s, i) -> map.put(s, i);

        mapAdderEveryTime.accept("key1", 4);
        mapAdderEveryTime.accept("key2", 4);

        BiConsumer<String, Integer> mapAdderIfPresent = (s, i) -> {
            map.computeIfPresent(s, (key, value) -> (value % 4 == 0) ? 0 : value +1);
        };

        mapAdderIfPresent.accept("key1", 1);

        System.out.println(map);
    }
}




@FunctionalInterface
interface Stringify<T>
{
    String toString(T t);
}

class GorillaFamily
{
    final String walk = "walk";

    void everyonePlay(final boolean baby)
    {
        final String approach = "amble";
//        approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void play(Gorilla g)
    {
        System.out.println(g.move());
    }
}

interface Gorilla
{
    String move();
}