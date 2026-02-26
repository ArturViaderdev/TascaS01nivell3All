package TascaS101Nivell2;

public class Smartphone extends Phone implements Clock, Camera{
    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void takePhoto() {
        System.out.println("S'està prenent una foto");
    }

    @Override
    public void alert() {
        System.out.println("Està sonant la alarma.");
    }
}
