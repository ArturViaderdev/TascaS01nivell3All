package TascaS01nivell3;

public class F1 extends Noticia {
    private String team;

    public F1(String editordni) {
        super(editordni);
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    @Override
    public void calculatePriceNew() {
        this.setPrice(100);
        if(team.equals("Ferrari") || team.equals("Mercedes"))
        {
            this.setPrice(this.getPrice()+50);
        }
    }

    @Override
    public void calculatePointsNew() {
        this.setPoints(4);
        if(team.equals("Ferrari") || team.equals("Mercedes"))
        {
            this.setPoints(this.getPoints()+4);
        }
    }
}
