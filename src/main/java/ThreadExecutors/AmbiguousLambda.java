package ThreadExecutors;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguousLambda
{

    public static void main(String[] args) throws IOException
    {
        useCallabe(() -> {throw new IOException();});
//        useSupplier(() -> {throw new IOException();});
//        use(() -> {throw new IOException();});
    }

    public static void useCallabe(Callable<Integer> expression)
    {

    }

    public static void useSupplier(Supplier<Integer> expression)
    {

    }

    public static void use(Supplier<Integer> expression)
    {

    }

    public static void use(Callable<Integer> expression)
    {

    }
}
