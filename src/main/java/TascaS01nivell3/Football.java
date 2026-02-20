package TascaS01nivell3;

public class Football extends Noticia {
    private String competition;
    private String club;
    private String player;

    public String getCompetition()
    {
        return competition;
    }

    public String getClub()
    {
        return club;
    }

    public String getPlayer()
    {
        return player;
    }

    public Football(String editordni) {
        super(editordni);
    }

    public void setCompetition(String competition)
    {
        this.competition = competition;
    }

    public void setClub(String club)
    {
        this.club = club;
    }

    public void setPlayer(String player)
    {
        this.player = player;
    }

    @Override
    public void CalculatePriceNew() {
       this.setPrice(300);
       if(competition.equals("Liga de Campions"))
       {
           this.setPrice(this.getPrice()+100);
       }
       if(club.equals("Barça") || club.equals("Madrid"))
       {
           this.setPrice(this.getPrice()+100);
       }
       if(player.equals("Ferran Torres") || player.equals("Benzema"))
       {
           this.setPrice(this.getPrice()+50);
       }
    }

    @Override
    public void CalculatePointsNew() {
        this.setPoints(5);
        if(competition.equals("Liga de Campions"))
        {
            this.setPoints(this.getPoints()+3);
        }
        else if(competition.contains("Liga"))
        {
            this.setPoints(this.getPoints()+2);
        }
        if(club.equals("Barça") || club.equals("Madrid"))
        {
            this.setPoints(this.getPoints()+1);
        }
        if(player.equals("Ferran Torres") || player.equals("Benzema"))
        {
            this.setPoints(this.getPoints()+1);
        }
    }


}
