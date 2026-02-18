package Spring1tasca101Exercici2;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("Marca - " + car.getBrand());
        System.out.println("Model - " + car.getModel());
        System.out.println("Potència - " + car.getPower().toString());

        Car secondcar = new Car();
        System.out.println("Modifico la variable static.");
        secondcar.setModel("Cougar");
        System.out.println("Model car 1 - " + car.getModel());
        System.out.println("Model car 2 - " + secondcar.getModel());

        System.out.println("Les variables static afecten a totes les instàncies de la classe.");

        Car.brake();
        car.accelerate();

    }
}
