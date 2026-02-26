package TascaS01nivell3;

abstract class Noticia {
    private String title;
    private String text;
    private double price;
    private int points;
    private String editordni;

    public abstract void calculatePriceNew();
    public abstract void calculatePointsNew();

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public int getPoints()
    {
        return points;
    }

    public String getText()
    {
        return text;
    }

    public String getType()
    {
        return this.getClass().toString();
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getTitle()
    {
        return title;
    }

    public String getEditordni()
    {
        return editordni;
    }

    public Noticia(String editorDni)
    {
        this.editordni = editordni;
    }
}
