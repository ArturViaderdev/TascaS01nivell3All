package TascaS01nivell3;

import java.util.ArrayList;

public class DataMethods {
    private ArrayList<Editor> editors;
    private ArrayList<Noticia> news;
    public DataMethods()
    {
        editors = new ArrayList<>();
        news = new ArrayList<>();

    }

    public void insertEditor(String dni, String name)
    {
        if(notExistEditor(dni) && notExistName(name))
        {
            editors.add(new Editor(dni,name));
            System.out.println("Editor afegit");
        }
        else {
            System.out.println("Ja existeix un redactor amb aquest dni o nom. Operació cancel.lada.");
        }
    }

    private boolean notExistName(String name)
    {
        for(Editor editor:editors)
        {
            if(editor.getName().equals(name))
            {
                return false;
            }
        }
        return true;
    }

    private boolean notExistEditor(String dni)
    {
        for(Editor editor:editors)
        {
            if(editor.getDni().equals(dni))
            {
                return false;
            }
        }
        return true;
    }

    public void showEditors()
    {
        int contEditor=0;
        while(contEditor<editors.size())
        {
            System.out.println(Integer.toString(contEditor +1) + " - Nom:" + editors.get(contEditor).getName() + " DNI - " + editors.get(contEditor).getDni() + " Sou - " + editors.get(contEditor).getSalary());
            contEditor++;
        }
    }

    public void deleteEditorProcess(int editorToDelete)
    {
        if(editors.size()>editorToDelete-1)
        {
            String dni = editors.get(editorToDelete-1).getDni();
            deleteEditor(editorToDelete-1);
            System.out.println("Redactor eliminat");
            System.out.println("Eliminant noticies del redactor.");
            deleteNewsDni(dni);
        }
        else{
            System.out.println("Opció incorrecta.");
        }
    }

    private void deleteEditor(int editorToDelete)
    {
        editors.remove(editorToDelete);
        System.out.println("Redactor el.liminat");
    }

    public void deleteNewsDni(String dni)
    {
        int cont=0;
        while(cont<news.size())
        {
            if(news.get(cont).getEditordni().equals(dni))
            {
                news.remove(cont);
            }
            else
            {
                cont++;
            }
        }
    }

    public boolean rangeEditorCorrect(int editorNew)
    {
        if(editorNew>0 && (editorNew-1)<editors.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean rangeNewCorrect(int choose)
    {
        if(choose>0 && choose<=news.size()-1)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public String getEditorDNI(int editorNew)
    {
        return editors.get(editorNew).getDni();
    }

    public String getEditorName(int editorNew)
    {
        return editors.get(editorNew).getName();
    }

    public void addNew(Noticia noticia)
    {
        news.add(noticia);
    }

    public int deleteNew(String name, String title)
    {
        int cont = 0;
        boolean exit = false;
        boolean found = false;
        while(!exit)
        {
            if(cont<news.size())
            {
                if(news.get(cont).getTitle().equals(title))
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
        if(found)
        {
            if(editors.get(searchDni(news.get(cont).getEditordni())).getName().equals(name))
            {
                news.remove(cont);
                return 0;
            }
            else
            {
                return 2;
            }
        }
        else
        {
            return 1;
        }
    }

    private int searchDni(String dni)
    {
        int cont = 0;
        boolean exit = false;
        boolean found = false;
        while(!exit)
        {
            if(cont<editors.size())
            {
                if(editors.get(cont).getDni().equals(dni))
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
        if(found)
        {
            return cont;
        }
        else
        {
            return -1;
        }
    }

    public void showNewsDNI(String dni)
    {
        int cont = 0;
        while(cont<news.size())
        {
            if(news.get(cont).getEditordni().equals(dni))
            {
                showNew(cont);
            }
            cont++;
        }
    }

    public void showNews()
    {
        int cont = 0;
        while(cont<news.size())
        {
            System.out.println(Integer.toString(cont+1));
            showNew(cont);
            cont++;
        }
    }

    private void showPlayers(ArrayList<String> players)
    {
        int cont = 0;
        while(cont<players.size())
        {
            System.out.println(players.get(cont));
            cont++;
        }
    }

    private void showNew(int position)
    {
        System.out.println("Títol:" + news.get(position).getTitle());
        System.out.println("Text:" + news.get(position).getText());

        if(news.get(position) instanceof Football) {

            Football noticia = (Football) news.get(position);
            System.out.println("Tipus de noticia: Fútbol.");
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
            System.out.println("Jugador: " + noticia.getPlayer());
        }
        else if(news.get(position) instanceof Basket)
        {
            System.out.println("Tipus de noticia: Basket.");
            Basket noticia = (Basket) news.get(position);
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
        }
        else if(news.get(position) instanceof Tenis)
        {
            System.out.println("Tipus de noticia: Tenis");
            Tenis noticia = (Tenis) news.get(position);
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Llista de tenistes:");
            showPlayers(noticia.getPlayers());
        }
        else if(news.get(position) instanceof F1)
        {
            System.out.println("Tipus de noticia: F1");
            F1 noticia = (F1) news.get(position);
            System.out.println("Escuderia: " + noticia.getTeam());
        }
        else if(news.get(position) instanceof Motorcycling)
        {
            System.out.println("Tipus de noticia: Motos");
            Motorcycling noticia = (Motorcycling) news.get(position);
            System.out.println("Equip: " + noticia.getTeam());
        }
    }

    public void calculatePointsNew(int position)
    {
        news.get(position).calculatePointsNew();
    }

    public void calculatePriceNew(int choose)
    {
        news.get(choose).calculatePriceNew();
    }

    public int getPointsNew(int choose)
    {
        return news.get(choose).getPoints();
    }

    public double getNewPrice(int choose)
    {
        return news.get(choose).getPrice();
    }

    public boolean deleteEditorDni(String dni)
    {
        int cont = 0;
        boolean exit = false;
        boolean found = false;

        while(!exit)
        {
            if(cont<editors.size())
            {
                if(editors.get(cont).getDni().equals(dni))
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
        if(found)
        {
            editors.remove(cont);
        }
        return found;
    }

    public int searchName(String name)
    {
        int cont = 0;
        boolean exit = false;
        boolean found = false;
        while(!exit)
        {
            if(cont<editors.size())
            {
                if(editors.get(cont).getName().equals(name))
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
        if(found)
        {
            return cont;
        }
        else
        {
            return -1;
        }
    }
}
