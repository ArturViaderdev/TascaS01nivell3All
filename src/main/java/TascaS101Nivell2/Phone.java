package TascaS101Nivell2;

abstract class Phone {
    private String brand;
    private String model;

    public void call(int number)
    {
        System.out.println("S'està trucant al número " + Integer.toString(number));
    }

    public Phone(String brand, String model)
    {
        this.brand = brand;
        this.model = model;
    }
}
