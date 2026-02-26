package Spring1tasca101;

public class PercussionInstrument extends Instrument{
    public PercussionInstrument(String name, double price) {
        super(name, price);
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

    @Override
    void play() {
        System.out.println("Està sonant un instrument de percussió");
    }
}
