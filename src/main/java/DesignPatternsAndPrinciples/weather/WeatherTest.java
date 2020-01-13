package DesignPatternsAndPrinciples.weather;

public class WeatherTest
{
    static Weather w;

    public static void main(String[] args)
    {
        System.out.print(w.RAINY.count + " " + w.Sunny.count + " ");
        System.out.println("Wear suncream: " + w.RAINY.shouldIWearSunCream());
        System.out.println("Wear suncream: " + w.Sunny.shouldIWearSunCream());
    }

    private enum Weather
    {
        RAINY,
        Sunny
                {
                    @Override
                    public boolean shouldIWearSunCream()
                    {
                        return true;
                    }
                };

        int count = 0;

        Weather()
        {
            System.out.print("c ");
            count++;
        }

        public boolean shouldIWearSunCream()
        {
            return false;
        }
    }
}
