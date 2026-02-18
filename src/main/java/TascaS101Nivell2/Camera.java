package TascaS101Nivell2;

public interface Camera {
    public default void takephoto()
    {
        System.out.println("S'està prenent una foto");
    }
}
