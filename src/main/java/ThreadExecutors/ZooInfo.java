package ThreadExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo
{
    public static void main(String[] args)
    {
        // note! that this extra threads should be called in a try finally block
        ExecutorService service = null;
        try
        {
            service = Executors.newSingleThreadExecutor();
            System.out.println(Thread.currentThread().getId() + "::: before tasks sent, this should be the main thread");
            service.execute(() -> {
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "::: task 1");
            });
            service.execute(() -> System.out.println(Thread.currentThread().getId() + "::: task 2"));
            service.execute(() -> System.out.println(Thread.currentThread().getId() + "::: task 3"));
            System.out.println(Thread.currentThread().getId() + "::: after tasks sent, this should be the main thread");
        }
        finally
        {
            if (service != null)
            {
                service.shutdown();
            }
        }
    }
}
