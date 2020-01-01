package GenericsAndConnections;

import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

public class Runner
{

    public static void main(String[] args)
    {
        List<?> l = new ArrayList<String>();
//        l.add(); // does not compile
        ((List<String>) l).add(""); // does compile

        ArrayList<? extends Number> list = new ArrayList<Integer>();
//        list.add(new Integer(1));

        printme(list);

        SomeInterface someInterface = new SomeInterface()
        {
            @Override
            public void someMethod()
            {
                System.out.println("someMethod");
            }
        };

        List<String> strings = new ArrayList<String>();
        strings.add("abc");
        List<Object> objects = new ArrayList<Object>(strings);
        System.out.println(objects);

        List<? super String> a = new ArrayList<>();
        a.add("adwa");
//        a.add(new Object()); // does not compile

        List<? super IOException> excList = new ArrayList<>();
//        excList.add(new Exception()); // does not compile
//        excList.add(new Object()); // does not compile
        excList.add(new IOException());
        excList.add(new BindException()); // subclass of IOException can be passed here

        List<? extends IOException> excList2 = new ArrayList<>();
//        excList2.add(new IOException()); // does not compile, we can't say for definite
//        excList2.add(new Object()); // doesnt compile
        excList2.add(new BindException());

    }

    public static void addSomething(List<? extends Number> list)
    {
        for (Number n : list)
        {
            n.longValue();
        }
    }

    public static void addSound(List<? super String> list)
    {
        list.add("sound");
    }

    public static void flyList(List<Flyer> list)
    {
        for (Flyer f : list)
        {
            System.out.println(f);
        }
    }

    public static void flyGeneric(List<? extends Flyer> list)
    {
        for (Flyer f : list)
        {
            System.out.println(f);
        }
    }

    public static void printMe(List<?> someList)
    {
        for (Object o : someList)
        {
            System.out.println(o);
        }
    }

    public static void printme(List<? extends Number> numberList)
    {
        long count = 0;
        for (Number n : numberList)
        {
            count += n.longValue();
        }
        System.out.println(count);
    }


}

interface SomeInterface
{
    void someMethod();
}