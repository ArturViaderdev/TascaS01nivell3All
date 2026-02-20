package TascaS01nivell3NewsInsideEditors;

import java.util.ArrayList;

public class Editor {
    private String name;
    private final String dni;
    private static double salary = 1500;
    private ArrayList<Noticia> news;

    public Editor(String dni, String name) {
        this.dni = dni;
        this.name = name;
        news = new ArrayList<>();
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

    public void addNew(Noticia noticia)
    {
        news.add(noticia);
    }

    public int getNewsSize()
    {
        return news.size();
    }

    public Noticia getNew(int pos)
    {
        return news.get(pos);
    }

    public void removeNew(int cont)
    {
        news.remove(cont);
    }
}
