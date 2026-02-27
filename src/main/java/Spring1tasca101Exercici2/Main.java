package Spring1tasca101Exercici2;

public class Main {
    public static void main(String[] args) {
        Car.brake();
        Car car = new Car(130);
        car.setModel("Cougar");
        System.out.println("Marca car 1 - " + car.getBrand());
        System.out.println("Model car 1- " + car.getModel());
        System.out.println("Potència car 1 - " + car.getPower().toString());

        Car secondcar = new Car(160);
        System.out.println("Modifico la variable static.");
        System.out.println("Model car 1 - " + car.getModel());
        System.out.println("Model car 2 - " + secondcar.getModel());
        car.setModel("Kuga");
        System.out.println("Model car 1 - " + car.getModel());
        System.out.println("Model car 2 - " + secondcar.getModel());
        System.out.println("Potència car 2- " + secondcar.getPower().toString());
        System.out.println("Les variables static afecten a totes les instàncies de la classe.");

        car.accelerate();
    }
}
