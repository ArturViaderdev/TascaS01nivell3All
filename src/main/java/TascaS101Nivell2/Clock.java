package TascaS101Nivell2;

public interface Clock {
    public default void alert()
    {
        System.out.println("Està sonant la alarma.");
    }
}
