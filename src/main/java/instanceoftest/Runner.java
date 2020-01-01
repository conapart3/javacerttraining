package instanceoftest;

public class Runner
{
    public static void main(String[] args)
    {
        Vehicle v = new Car();
        Moveable m = new Car();
        Car c = new Car();
        //Bus m2 = new Bus();
        Vehicle m2 = new Bus();

        boolean yes = m instanceof Car;
        //boolean yes2 = m2 instanceof Car; // -compiler error - no possible way Bus can be instanceof Car


        //but if we have m2 as a Moveable or Vehicle, it compiles because it determines the type at runtime
        boolean yes2 = m2 instanceof Car;


        System.out.println(yes);
    }
}
