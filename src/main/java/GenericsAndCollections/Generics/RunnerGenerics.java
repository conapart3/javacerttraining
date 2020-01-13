package GenericsAndCollections.Generics;

import java.util.ArrayList;
import java.util.List;

public class RunnerGenerics
{
    public static void main(String[] args)
    {
        List list = new ArrayList();
        list.add(2);
        list.add(3);
        list.add("cas");


        System.out.println(list);
        List<?> strList1 = new ArrayList<>();
        List<?> strList2 = new ArrayList<String>();
        ArrayList<?> strList3 = new ArrayList<>();
        ArrayList<?> strList4 = new ArrayList<String>();
        ArrayList<? extends String> strList5 = new ArrayList<>();
        //ArrayList<?> strList6 = new ArrayList<?>();//-does not compile

//        strList5.add("");

        SizeLimitedCrate<Elephant, Integer> elephantCrate = new SizeLimitedCrate<>(new Elephant(), 15_000);
        elephantCrate.ship();
        elephantCrate.printObject("i'm a string");
        elephantCrate.<String>printObject("i'm a string");
        elephantCrate.<Elephant>printObject(new Elephant());

        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
        String str = "abc";

        List<String> strList = new ArrayList<>();
//        List<Object> objList = strList; // not allowed
    }

    public static void printList(List<? extends Object/*just using Object here gives compiler error on line 34*/> list)
    {
        for (Object x : list)
        {
            System.out.println(x);
        }
    }

    public static class Elephant
    {
        public Elephant()
        {
        }

        @Override
        public String toString()
        {
            return "I'm an elephant";
        }
    }

}
