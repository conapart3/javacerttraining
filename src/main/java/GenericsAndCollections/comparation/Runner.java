package GenericsAndCollections.comparation;

import java.util.*;

public class Runner
{
    public static void main(String[] args)
    {

        Chicken c1 = new Chicken("chick1", 6, 20);
        Chicken c2 = new Chicken("chick2", 5, 15);
        Chicken c3 = new Chicken("chick3", 4, 25);

        List<Chicken> chickenList = new ArrayList<>();
        chickenList.add(c1);
        chickenList.add(c2);
        chickenList.add(c3);

        System.out.println(chickenList);

//        Collections.sort(chickenList);
//        System.out.println(chickenList);

        Collections.sort(chickenList, new Comparator<Chicken>()
        {
            @Override
            public int compare(Chicken o1, Chicken o2)
            {
                // o1 - o2 means ascending order
                // o2 - o1 means descending order
                System.out.println("" + o1.getName() + ": " + o1.getWeight() + ", " + o2.getName() + ": " + o2.getWeight());
                return o1.getWeight() - o2.getWeight();
            }
        });

        Collections.sort(chickenList, (o1, o2) ->
        {
            // o1 - o2 means ascending order
            // o2 - o1 means descending order
            System.out.println("" + o1.getName() + ": " + o1.getWeight() + ", " + o2.getName() + ": " + o2.getWeight());
            return o1.getWeight() - o2.getWeight();
        });

        System.out.println(chickenList);

        List<String> ascStrList = Arrays.asList("aaa", "bbb");
        Comparator<String> comparator = Comparator.reverseOrder();
        System.out.println("aaa found at position: " +Collections.binarySearch(ascStrList, "aaa"));
        System.out.println("aaa found at position: " +Collections.binarySearch(ascStrList, "aaa", comparator));//0?why
        System.out.println("bbb found at position: " +Collections.binarySearch(ascStrList, "bbb", comparator));//-1?why

//        Set<Rabbit> rabbitSet = new TreeSet<>();
//        rabbitSet.add(new Rabbit());//classCastException cannot cast Rabbit to Comparable!

        System.out.println("======================");

        // comparator by hand
        Set<Rabbit> rabbitSet = new TreeSet<>(((Rabbit o1, Rabbit o2) -> {return o1.weight - o2.weight;}));
        addRabbitsAndPrint(rabbitSet);

        // using comparingInt and providing a keyExtractor to get the comparing key of the object. unable to tell it asc or desc.
        rabbitSet = new TreeSet<>((Comparator.comparingInt((Rabbit o) -> o.weight)));
        addRabbitsAndPrint(rabbitSet);

        // using comparingLong and providing a keyExtractor to get the comparing key of the object. unable to tell it asc or desc.
        rabbitSet = new TreeSet<>((Comparator.comparingLong((Rabbit o) -> o.tailLength)));
        addRabbitsAndPrint(rabbitSet);

        // using comparing and providing a keyExtractor to get the comparing key of the object. unable to tell it asc or desc.
        rabbitSet = new TreeSet<>((Comparator.comparing((Rabbit o) -> o.name)));
        addRabbitsAndPrint(rabbitSet);
    }

    private static void addRabbitsAndPrint(Set<Rabbit> rabbitSet)
    {
        rabbitSet.add(new Rabbit("a", 12, 7));
        rabbitSet.add(new Rabbit("b-heaviest", 15, 2));
        rabbitSet.add(new Rabbit("121-alphabeticallyFirst", 5, 5));
        rabbitSet.add(new Rabbit("zstar1-longestTail", 1, 10));
        System.out.println(rabbitSet);
    }


}

class Rabbit {
    String name;
    int weight;
    long tailLength;

    public Rabbit(String name, int weight, long tailLength)
    {
        this.name = name;
        this.weight = weight;
        this.tailLength = tailLength;
    }

    @Override
    public String toString()
    {
        return "Rabbit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", tailLength=" + tailLength +
                '}';
    }
}

class Chicken implements Comparable<Chicken>
{
    private String name;
    private int age;
    private int weight;

    public Chicken(String name, int age, int weight)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public int compareTo(Chicken o)
    {
        return this.age - o.getAge();
    }

    @Override
    public String toString()
    {
        return "Chicken{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}