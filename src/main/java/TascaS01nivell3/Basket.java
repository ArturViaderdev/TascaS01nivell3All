package TascaS01nivell3;

public class Basket extends Noticia {
    private String club;
    private String competition;

    public Basket(String editordni) {
        super(editordni);
    }

    public String getClub()
    {
        return club;
    }

    public String getCompetition()
    {
        return competition;
    }

    public void setCompetition(String competition)
    {
        this.competition = competition;
    }

    public void setClub(String club)
    {
        this.club = club;
    }

    @Override
    public void calculatePriceNew() {
        this.setPrice(250);
        if(competition.equals("Eurolliga"))
        {
            this.setPrice(this.getPrice()+75);
        }
        if(club.equals("Barça") || club.equals("Madrid"))
        {
            this.setPrice(this.getPrice()+75);
        }
    }

    @Override
    public void calculatePointsNew() {
        this.setPoints(4);
        if(competition.equals("Eurolliga"))
        {
            this.setPoints(this.getPoints()+3);
        }
        else if(competition.equals("ACB"))
        {
            this.setPoints(this.getPoints()+2);
        }
        if(club.equals("Barça") || club.equals("Madrid"))
        {
            this.setPoints(this.getPoints()+1);
        }
    }
}
