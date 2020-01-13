package DesignPatternsAndPrinciples;

@FunctionalInterface
public interface MyFuncInt
{
    String getMyName();

    default void abc()
    {
        return;
    }
}
