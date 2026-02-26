package TascaS01nivell3;

public class Motorcycling extends Noticia {
    private String team;

    public String getTeam()
    {
        return team;
    }

    public Motorcycling(String editordni) {
        super(editordni);
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    @Override
    public void calculatePriceNew() {
        this.setPrice(100);
        if(team.equals("Honda") || team.equals("Yamaha"))
        {
            this.setPrice(this.getPrice()+50);
        }

    }

    @Override
    public void calculatePointsNew() {
        this.setPoints(3);
        if(team.equals("Honda") || team.equals("Yamaha"))
        {
            this.setPoints(this.getPoints()+3);
        }
    }
}
