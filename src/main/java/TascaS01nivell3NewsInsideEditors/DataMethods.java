package TascaS01nivell3NewsInsideEditors;

import java.util.ArrayList;

public class DataMethods {
    private ArrayList<Editor> editors;
    public DataMethods()
    {
        editors = new ArrayList<>();
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
            //String dni = editors.get(editorToDelete-1).getDni();
            deleteEditor(editorToDelete-1);
            System.out.println("Redactor eliminat");
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

    public boolean rangeNewCorrect(int choose,int editorSearch)
    {
        if(choose>0 && choose<=editors.get(editorSearch).getNewsSize()-1)
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

    public void addNew(Noticia noticia,String dni)
    {
        editors.get(searchDni(dni)).addNew(noticia);
    }

    public int deleteNew(String name, String title)
    {
        int pos = searchName(name);
        if(pos==-1)
        {
            return 2;
        }
        else
        {
            int cont=0;
            boolean exit = false;
            boolean found = false;
            while(!exit)
            {
                if(cont<editors.get(pos).getNewsSize()){
                    if(editors.get(pos).getNew(cont).getTitle().equals(title))
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
                editors.get(pos).removeNew(cont);
                return 0;
            }
            else
            {
                return 1;
            }
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
        int posEditor = searchDni(dni);
        int size = editors.get(posEditor).getNewsSize();
        int cont =0;
        while(cont<size) {
            showNew(cont,posEditor);
            cont++;
        }
    }

    public void showNews(int editorSearch)
    {
        int cont = 0;
        while(cont<editors.get(editorSearch).getNewsSize())
        {
            System.out.println(Integer.toString(cont+1));
            showNew(cont,editorSearch);
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

    private void showNew(int position,int posEditor)
    {
        System.out.println("Títol:" + editors.get(posEditor).getNew(position).getTitle());
        System.out.println("Text:" + editors.get(posEditor).getNew(position).getText());

        if(editors.get(posEditor).getNew(position) instanceof Football) {

            Football noticia = (Football) editors.get(posEditor).getNew(position);
            System.out.println("Tipus de noticia: Fútbol.");
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
            System.out.println("Jugador: " + noticia.getPlayer());
        }
        else if(editors.get(posEditor).getNew(position) instanceof Basket)
        {
            System.out.println("Tipus de noticia: Basket.");
            Basket noticia = (Basket) editors.get(posEditor).getNew(position);
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
        }
        else if(editors.get(posEditor).getNew(position) instanceof Tenis)
        {
            System.out.println("Tipus de noticia: Tenis");
            Tenis noticia = (Tenis) editors.get(posEditor).getNew(position);
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Llista de tenistes:");
            showPlayers(noticia.getPlayers());
        }
        else if (editors.get(posEditor).getNew(position) instanceof F1)
        {
            System.out.println("Tipus de noticia: F1");
            F1 noticia = (F1) editors.get(posEditor).getNew(position);
            System.out.println("Escuderia: " + noticia.getTeam());
        }
        else if(editors.get(posEditor).getNew(position) instanceof Motorcycling)
        {
            System.out.println("Tipus de noticia: Motos");
            Motorcycling noticia = (Motorcycling) editors.get(posEditor).getNew(position);
            System.out.println("Equip: " + noticia.getTeam());
        }
    }

    public void calculatePointsNew(int position,int editorSearch)
    {
        editors.get(editorSearch).getNew(position).calculatePointsNew();
    }

    public void calculatePriceNew(int choose, int editorSearch)
    {
        editors.get(editorSearch).getNew(choose).calculatePriceNew();
    }

    public int getPointsNew(int choose, int editorSearch)
    {
        return editors.get(editorSearch).getNew(choose).getPoints();
    }

    public double getNewPrice(int choose, int editorSearch)
    {
        return editors.get(editorSearch).getNew(choose).getPrice();
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
