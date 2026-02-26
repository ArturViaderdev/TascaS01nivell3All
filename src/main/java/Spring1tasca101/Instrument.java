package Spring1tasca101;

abstract class Instrument {
    protected String name;
    protected double price;

    abstract void setName(String name);

    abstract String getName();

    abstract void setPrice(double price);

    abstract double getPrice();

    abstract void play();

    private static final String whatis = "instrument";
    static {
        System.out.println("Bloc estàtic, s'executa al principi.");
    }

    public static void metodeEstatic()
    {
        System.out.println("S'executa un mètode estàtic.");
    }

    public Instrument(String name, double price)
    {
    }

    {
        System.out.println("Bloc de inicialització s'executa al fer new del objecte.");
    }
}
