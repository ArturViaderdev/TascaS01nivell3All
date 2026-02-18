package Spring1tasca101Exercici2;

public class Car {
    private static final String brand = "Ford";
    private static String model;
    private static final Integer power = 160;

    public Car()
    {
        model = "Kuga";
    }

    public void setModel(String model)
    {
        Car.model = model;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public Integer getPower()
    {
        return power;
    }

    public static void brake()
    {
        System.out.println("El vehicle està frenant.");
    }

    public void accelerate()
    {
        System.out.println("El vehicle està accelerant.");
    }
}
