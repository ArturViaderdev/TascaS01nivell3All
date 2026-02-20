package Spring1tasca101;

abstract class Instrument {
    private String name;
    private double price;

    abstract void play();

    private static final String whatis = "instrument";
    static {
        System.out.println("Bloc estàtic, s'executa al principi.");
    }

    public static void MetodeEstatic()
    {
        System.out.println("S'executa un mètode estàtic.");
    }

    public Instrument()
    {
    }

    {
        System.out.println("Bloc de inicialització s'executa al fer new del objecte.");
    }
}
