package ThreadExecutors;

import java.util.concurrent.*;

public class ZooInfoWithSubmit
{
    public static void main(String[] args)
    {
        // note! that this extra threads should be called in a try finally block
        ExecutorService service = null;
        try
        {
            service = Executors.newSingleThreadExecutor();
            System.out.println(Thread.currentThread().getId() + "::: before tasks sent, this should be the main thread");
            Future<Integer> submissionResponse = service.submit(() -> {
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "::: task 1");
                return Integer.valueOf(2);
            });
            try
            {
                System.out.println(Thread.currentThread().getId() + "::: getting the response: " + submissionResponse.get(102, TimeUnit.MILLISECONDS));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
            }
            catch (TimeoutException e)
            {
                e.printStackTrace();
            }
            service.submit(() -> System.out.println(Thread.currentThread().getId() + "::: task 2"));
            service.submit(() -> System.out.println(Thread.currentThread().getId() + "::: task 3"));
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
