package DesignPatternsAndPrinciples;

public interface D extends A
{
    int mySize();

    public static void skip(int speed) {
        System.out.println("d.skip");
    }
}
