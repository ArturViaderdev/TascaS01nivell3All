package Spring1tasca101;

public class StringInstrument extends Instrument{

    public StringInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    void play() {
        System.out.println("Està sonant un instrument de corda");
    }

    @Override
    void setName(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    void setPrice(double price) {
        this.price = price;
    }

    @Override
    double getPrice() {
        return price;
    }
}
