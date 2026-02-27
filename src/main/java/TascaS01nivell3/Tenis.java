package TascaS01nivell3;

import java.util.ArrayList;

public class Tenis extends Noticia {
    private String competition;
    private ArrayList<String> players;

    public Tenis(String editorDni) {
        super(editorDni);
        players = new ArrayList<>();
    }

    public void addPlayer(String player)
    {
        players.add(player);
    }

    public String getCompetition()
    {
        return competition;
    }

    public ArrayList<String> getPlayers()
    {
        return players;
    }

    public void setCompetition(String competition)
    {
        this.competition = competition;
    }

    private boolean playerExist()
    {
        boolean exit = false;
        boolean found = false;
        int cont = 0;
        while(!exit)
        {
            if(cont<players.size())
            {
                if(players.get(cont).contains("Federer")|| players.get(cont).contains("Nadal") || players.get(cont).contains("Djokovic"))
                {
                    found = true;
                    exit = true;
                }
                else
                {
                    cont++;
                }
            }
            else
            {
                exit = true;
            }
        }
        return found;
    }

    @Override
    public void calculatePriceNew() {
        this.setPrice(150);
        boolean are = playerExist();
        if(are)
        {
            this.setPrice(this.getPrice()+100);
        }

    }

    @Override
    public void calculatePointsNew() {
        this.setPoints(4);
        boolean are = playerExist();
        if(are)
        {
            this.setPoints(this.getPoints()+3);
        }
    }
}
