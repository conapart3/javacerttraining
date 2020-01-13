package DesignPatternsAndPrinciples;

import java.util.function.Predicate;

public class Runner
{

    public static void main(String[] args)
    {
        C c = new C();
        aMethod(c);
        bMethod(c);
        dMethod(c);

//        D.skip(2);

        // the a -> a.canHop() expression means java should call a method with an Animal param that returns a boolean
        // that is the result of a.canHop().
        // java relies on context when figuring out what lambda expression means. we are passing this lambda as the second param
        // of the print() method and it expects CheckTrait as the 2nd param. Since we are passing a lambda instead, Java
        // treats CheckTrait as a functional interface and tries to map it to the single abstract method boolean test(Animal a).
        // since this interface's method takes an animal, it means the lambda param has to be an Animal. And since that
        // interface's method returns a boolean, we know that the lambda returns a boolean
//        print(new Animal("fish", false, true), a -> a.canHop());
//        print(new Animal("kangaroo", true, false), a -> a.canHop());

        // these are the actual implementations of the functional interfaces!

        // #1
//        print(() -> new Duck());

        // #2
//        print(new Duck(), d -> {return d.quack();});

//        #3
//        print(new Duck(), (Duck d) -> d.quack());

//        #4
//        print(new Animal("", true, true),
//                new Duck(),
//                (Animal a, Duck d) -> d.quack());

//        #5 - replaced with Predicate<T>
//        testAndPrint(new Animal("fox", false, false), a -> a.canHop());


        // hay bails
        final HayMakerSingleton instance = HayMakerSingleton.getInstance();
        instance.addHay(3, 1);
        instance.getSomeHay();

        class HayDispenserThread implements Runnable
        {

            @Override
            public void run()
            {
                final HayMakerSingleton instance = HayMakerSingleton.getInstance();
                instance.addHay(3, 1);
                instance.getSomeHay();
            }
        }

        new Thread(new HayDispenserThread()).start();
        new Thread(new HayDispenserThread()).start();
        new Thread(new HayDispenserThread()).start();
        new Thread(new HayDispenserThread()).start();
        new Thread(new HayDispenserThread()).start();
        new Thread(new HayDispenserThread()).start();
    }

//    # 1
//    private static void print(Noisable quacker)
//    {
//        quacker.quack();
//    }

    //    #2
    private static void testAndPrint(Animal d, Predicate<Animal> p)
    {
        if (p.test(d))
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }

    private static void aMethod(A a)
    {
        a.getSpeed("");
    }

    private static void bMethod(B b)
    {
        b.getSpeed("");
    }

    private static void dMethod(D d)
    {
        d.mySize();
    }
}
