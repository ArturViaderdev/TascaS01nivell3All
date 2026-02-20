package Spring1tasca101;

public class Main {
    public static void main(String[] args) {
        //I call a static method
        Instrument.MetodeEstatic();
        //I create three instruments
        Instrument windInstrument = new WindInstrument();
        Instrument stringInstrument = new StringInstrument();
        Instrument percussionInstrument = new PercussionInstrument();
        //I call the play void for each instrument
        windInstrument.play();
        stringInstrument.play();
        percussionInstrument.play();
    }
}
