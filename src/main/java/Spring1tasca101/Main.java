package Spring1tasca101;

public class Main {
    public static void main(String[] args) {
        Instrument.metodeEstatic();
        Instrument windInstrument = new WindInstrument();
        Instrument stringInstrument = new StringInstrument();
        Instrument percussionInstrument = new PercussionInstrument();

        windInstrument.play();
        stringInstrument.play();
        percussionInstrument.play();
        windInstrument.name = "Flauta";
        windInstrument.price = 20;

    }
}
