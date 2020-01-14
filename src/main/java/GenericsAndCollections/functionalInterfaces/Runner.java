package GenericsAndCollections.functionalInterfaces;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Runner
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//        int sum = list.stream().reduce()

//        BiFunction<String, String, String> func = (v1, v2) -> {return v1.toUpperCase() + v2.toLowerCase();};
        BiFunction<String, String, String> func = (v1, v2) -> v1.toUpperCase() + v2.toLowerCase();

        System.out.println(func.apply("abC", "DeF"));

        Map<String, String> myMap = new HashMap<>();
        myMap.put("firstKey", "firstEntry");
        myMap.put("secondKey", "secondEntry");
        myMap.put("keyForNullValue", null);
        myMap.put("keyForNullValue2", null);
        myMap.put("isThisKeyGone?", "it should be after the final merge() with null");
        myMap.put("anotherNullValue", null);

        myMap.merge("firstKey", "mergedEntry", func);
        System.out.println(myMap);
        myMap.merge("keyForNullValue", "mergedEntry", func);
        System.out.println(myMap);

        BiFunction<String, String, String> nullTestingFunc = (v1, v2) -> (v1 == null || v2 == null) ? "nullPresent" : "noNulls";
        myMap.merge("keyForNullValue2", "didn't use nullTestingFunc!", nullTestingFunc);
        System.out.println(myMap);

        BiFunction<String, String, String> funcReturnsNull = (v1, v2) -> null;
        myMap.merge("isThisKeyGone?", "this string shouldn't be added", funcReturnsNull);
        System.out.println(myMap);

        myMap.merge("anotherNullValue", "value is null - will it remove the key?", funcReturnsNull);
        System.out.println(myMap);


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Aaa", 5);
        map2.put("Bbb", 6);
        map2.put("Ccc", 2);
        map2.put("Ddd", null);
        map2.put("Eee", null);
        map2.put(null, null);

//        BiFunction<String, Integer, Integer> incrementFunc = (k, v) -> v++; // this didn't work, because you arent returning v just incrementing it and it isn't setting it into the map?
        BiFunction<String, Integer, Integer> incrementFunc = (k, v) -> v + 1;
        System.out.println(map2.computeIfPresent("Aaa", incrementFunc));
        System.out.println(map2.computeIfPresent("Bbb", incrementFunc));
        System.out.println(map2.computeIfPresent("Ddd", incrementFunc));
        System.out.println(map2);

        // computeIfAbsent obviously isn't a BiFunction since we don't process if it exists in hte map
        Function<String, Integer> incrementFuncIfAbsent = k -> 5;
        System.out.println(map2.computeIfAbsent("FFF", incrementFuncIfAbsent));
        System.out.println(map2);

        Beaver b1 = new Beaver(5);
        Beaver b2 = new Beaver(10);
        Beaver b3 = new Beaver(1);
        TreeSet<Beaver> tree = new TreeSet<>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }
}

class Beaver implements Comparable<Beaver>{

    int weight;

    public Beaver(int weight)
    {
        this.weight = weight;
    }

    @Override
    public int compareTo(Beaver o)
    {
//        return this.weight - o.weight;// ascending order
        return o.weight - this.weight;// descending order
    }

    @Override
    public String toString()
    {
        return "Beaver{" +
                "weight=" + weight +
                '}';
    }
}

@FunctionalInterface
interface MyConsumer<Ttype>
{
    void consume(Ttype obj);
}

@FunctionalInterface
interface MySupplier<T>
{
    T supply();
}

// operators are functions that receive and return the same value type.
@FunctionalInterface
interface MyUnaryOperator<T>
{
    T processParamAndReturnSameType(T obj);
}

@FunctionalInterface
interface MyPredicate<T>
{
    boolean test(T t);
}

@FunctionalInterface
interface MyFunction<T, R>
{
    R apply(T t);
}

@FunctionalInterface
interface MyBiFunction<R, T, V>
{
    R apply(T t, V v);
}

