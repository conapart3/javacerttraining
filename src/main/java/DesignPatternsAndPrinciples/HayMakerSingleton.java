package DesignPatternsAndPrinciples;

public class HayMakerSingleton
{
    private int amountOfHayRemaining;
    private int hayBailSize;

    private static final HayMakerSingleton instance = new HayMakerSingleton();//loaded at time class is loaded. may be less performant

    public static HayMakerSingleton getInstance()
    {
        return instance;
    }

    private HayMakerSingleton()
    {
        this.hayBailSize = 1;
    }

    public synchronized int getSomeHay()
    {
        if (amountOfHayRemaining > hayBailSize)
        {
            amountOfHayRemaining -= hayBailSize;
            System.out.println(Thread.currentThread().getName() + ": getting hay, remaining: " + amountOfHayRemaining);
            return hayBailSize;
        }
        else
        {
            return 0;
        }
    }

    public synchronized void setHayBailSize(int size)
    {
        this.hayBailSize = size;
    }

    public synchronized int checkStock()
    {
        System.out.println(Thread.currentThread().getName() + ": checking stock: " + amountOfHayRemaining);
        return amountOfHayRemaining;
    }

    public synchronized void addHay(int numberOfHayBails, int sizeOfHayBails)
    {
        int stockAdded = numberOfHayBails * sizeOfHayBails;
        this.amountOfHayRemaining += stockAdded;
        System.out.println(Thread.currentThread().getName() + ": adding stock: " + stockAdded + ": remaining: " + amountOfHayRemaining);
    }
}
