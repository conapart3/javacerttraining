package ThreadExecutors;

import java.util.concurrent.*;

public class CheckResults
{
    private static int counter = 0;

    public static void main(String[] args)
    {
        ExecutorService service = null;
        try
        {
            service = Executors.newFixedThreadPool(5);

            Future<?> result = service.submit(() -> {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + "::: finished sleeping");
            });

            result.get(10000, TimeUnit.MILLISECONDS);
            System.out.println(counter + " > Reached!");
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
            System.out.println("Not reached in time!");
        }
        finally
        {
            if (service != null)
            {
                service.shutdown();
            }
        }
    }

    static synchronized void incrementCounter()
    {
        counter++;
    }
}
