package TascaS01nivell3;

public class Editor {
    private String name;
    private String dni;
    private static double salary = 1500;

    public Editor(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String getDni()
    {
        return dni;
    }

    public double getSalary()
    {
        return salary;
    }
}
