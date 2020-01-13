package GenericsAndCollections.Generics;

public class SizeLimitedCrate<T,U>
{
    private T contents;
    private U sizeLimit;

//    public static T sta; // not allowed

    public SizeLimitedCrate(T contents, U sizeLimit)
    {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
//        new T(); // - not allowed
//        T[] newt = T[5];
    }

    public void ship()
    {
        System.out.println("Shipping: " + contents + ", sizeLimit: " + sizeLimit);
    }

    public <U> void printObject(U u)
    {
        System.out.println(u);
    }

}
