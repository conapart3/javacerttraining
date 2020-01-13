package DesignPatternsAndPrinciples;

public class ImmutableObject
{
    private final int var1;
    private final String var2;
    private final boolean var3;

    public ImmutableObject(int var1, String var2, boolean var3)
    {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public int getVar1()
    {
        return var1;
    }

    public String getVar2()
    {
        return var2;
    }

    public boolean isVar3()
    {
        return var3;
    }
}
