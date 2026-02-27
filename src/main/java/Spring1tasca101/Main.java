package Spring1tasca101;

public class Main {
    public static void main(String[] args) {
        Instrument.staticMethod();
        Instrument windInstrument = new WindInstrument("Flauta",20);
        Instrument stringInstrument = new StringInstrument("Piano",300);
        Instrument percussionInstrument = new PercussionInstrument("Tambor",50);

        windInstrument.play();
        stringInstrument.play();
        percussionInstrument.play();
        windInstrument.name = "Flauta";
        windInstrument.price = 20;
        String nom = windInstrument.getName();
        percussionInstrument.setPrice(60);
    }
}
