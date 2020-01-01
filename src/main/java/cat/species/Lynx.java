package cat.species;

import cat.BigCat;

public class Lynx extends BigCat
{

    public static void main(String[] args)
    {
        BigCat cat = new BigCat();
        //System.out.println(bigCat.protectedInt); //does not compile
        //System.out.println(bigCat.packagePrivateInt); //does not compile
        System.out.println(cat.publicInt);

        Lynx lynx = new Lynx();
        System.out.println(lynx.protectedInt);
        System.out.println(lynx.protectedInt);
    }

    public void publicMethod()
    {
    }

    protected void protectedMethod()
    {
    }
    //package private cant be overridden because this class isn't in the same package.

    // we can define weaker access modifier (protected -> public)
    // We can define a more restrictive return type
    public Integer someMethodReturningInteger(String myStr)
    {
        return null;
    }
}
