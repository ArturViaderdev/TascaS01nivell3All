package TascaS01nivell3NewsInsideEditors;

import java.util.ArrayList;

public class Tenis extends Noticia {
    private String competition;
    private ArrayList<String> players;

    public Tenis() {
        super();
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

    private boolean playerexist()
    {
        boolean sal = false;
        boolean encontrado = false;
        int cont = 0;
        while(!sal)
        {
            if(cont<players.size())
            {
                if(players.get(cont).contains("Federer")|| players.get(cont).contains("Nadal") || players.get(cont).contains("Djokovic"))
                {
                    encontrado = true;
                    sal = true;
                }
                else
                {
                    cont++;
                }
            }
            else
            {
                sal = true;
            }
        }
        return encontrado;
    }

    @Override
    public void CalculatePriceNew() {
        this.setPrice(150);
        boolean are = playerexist();
        if(are)
        {
            this.setPrice(this.getPrice()+100);
        }

    }

    @Override
    public void CalculatePointsNew() {
        this.setPoints(4);
        boolean are = playerexist();
        if(are)
        {
            this.setPoints(this.getPoints()+3);
        }
    }
}
