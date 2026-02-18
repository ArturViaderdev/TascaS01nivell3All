package Spring1tasca101;

public class Main {
    public static void main(String[] args) {
        //I create three instruments
        WindInstrument windInstrument = new WindInstrument();
        StringInstrument stringInstrument = new StringInstrument();
        PercussionInstrument percussionInstrument = new PercussionInstrument();
        //I call the play void for each instrument
        windInstrument.play();
        stringInstrument.play();
        percussionInstrument.play();
    }
}
