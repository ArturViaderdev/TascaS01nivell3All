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
        int cont = 0;
        boolean sal = false;
        boolean encontrado = false;

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
        int cont = 0;
        boolean sal = false;
        boolean encontrado = false;

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
        int conteditor=0;
        while(conteditor<editors.size())
        {
            System.out.println(Integer.toString(conteditor +1) + " - Nom:" + editors.get(conteditor).getName() + " DNI - " + editors.get(conteditor).getDni() + " Sou - " + editors.get(conteditor).getSalary());
            conteditor++;
        }
    }

    public void deleteEditorProcess(int editortodelete)
    {
        if(editors.size()>editortodelete-1)
        {
            String dni = editors.get(editortodelete-1).getDni();
            deleteEditor(editortodelete-1);
            System.out.println("Redactor eliminat");
        }
        else{
            System.out.println("Opció incorrecta.");
        }
    }

    private void deleteEditor(int editortodelete)
    {
        editors.remove(editortodelete);
        System.out.println("Redactor el.liminat");
    }

    public boolean rangeEditorCorrect(int editornew)
    {
        if(editornew>0 && (editornew-1)<editors.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean rangeNewCorrect(int choose,int editorsearch)
    {
        if(choose>0 && choose<=editors.get(editorsearch).getNewsSize()-1)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public String getEditorDNI(int editornew)
    {
        return editors.get(editornew).getDni();
    }

    public String getEditorName(int editornew)
    {
        return editors.get(editornew).getName();
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
            boolean sal = false;
            boolean encontrado = false;
            while(!sal)
            {
                if(cont<editors.get(pos).getNewsSize()){
                    if(editors.get(pos).getNew(cont).getTitle().equals(title))
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
            if(encontrado)
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
        boolean sal = false;
        boolean encontrado = false;
        while(!sal)
        {
            if(cont<editors.size())
            {
                if(editors.get(cont).getDni().equals(dni))
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
        if(encontrado)
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
        int poseditor = searchDni(dni);
        int size = editors.get(poseditor).getNewsSize();
        int cont =0;
        while(cont<size) {
            showNew(cont,poseditor);
            cont++;
        }
    }

    public void showNews(int editorsearch)
    {
        int cont = 0;
        while(cont<editors.get(editorsearch).getNewsSize())
        {
            System.out.println(Integer.toString(cont+1));
            showNew(cont,editorsearch);
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

    private void showNew(int position,int poseditor)
    {
        System.out.println("Títol:" + editors.get(poseditor).getNew(position).getTitle());
        System.out.println("Text:" + editors.get(poseditor).getNew(position).getText());

        if(editors.get(poseditor).getNew(position) instanceof Football) {

            Football noticia = (Football) editors.get(poseditor).getNew(position);
            System.out.println("Tipus de noticia: Fútbol.");
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
            System.out.println("Jugador: " + noticia.getPlayer());
        }
        else if(editors.get(poseditor).getNew(position) instanceof Basket)
        {
            System.out.println("Tipus de noticia: Basket.");
            Basket noticia = (Basket) editors.get(poseditor).getNew(position);
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
        }
        else if(editors.get(poseditor).getNew(position) instanceof Tenis)
        {
            System.out.println("Tipus de noticis: Tenis");
            Tenis noticia = (Tenis) editors.get(poseditor).getNew(position);
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Llista de tenistes:");
            showPlayers(noticia.getPlayers());
        }
        else if (editors.get(poseditor).getNew(position) instanceof F1)
        {
            System.out.println("Tipus de noticia: F1");
            F1 noticia = (F1) editors.get(poseditor).getNew(position);
            System.out.println("Escuderia: " + noticia.getTeam());
        }
        else if(editors.get(poseditor).getNew(position) instanceof Motorcycling)
        {
            System.out.println("Tipus de noticia: Motos");
            Motorcycling noticia = (Motorcycling) editors.get(poseditor).getNew(position);
            System.out.println("Equip: " + noticia.getTeam());
        }
    }

    public void calculatePointsNew(int position,int editorsearch)
    {
        editors.get(editorsearch).getNew(position).calculatePointsNew();
    }

    public void calculatePriceNew(int choose, int editorsearch)
    {
        editors.get(editorsearch).getNew(choose).calculatePriceNew();
    }

    public int getPointsNew(int choose, int editorsearch)
    {
        return editors.get(editorsearch).getNew(choose).getPoints();
    }

    public double getNewPrice(int choose, int editorsearch)
    {
        return editors.get(editorsearch).getNew(choose).getPrice();
    }

    public boolean deleteEditorDni(String dni)
    {
        int cont = 0;
        boolean sal = false;
        boolean encontrado = false;

        while(!sal)
        {
            if(cont<editors.size())
            {
                if(editors.get(cont).getDni().equals(dni))
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
        if(encontrado)
        {
            editors.remove(cont);
        }
        return encontrado;
    }

    public int searchName(String name)
    {
        int cont = 0;
        boolean sal = false;
        boolean encontrado = false;
        while(!sal)
        {
            if(cont<editors.size())
            {
                if(editors.get(cont).getName().equals(name))
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
        if(encontrado)
        {
            return cont;
        }
        else
        {
            return -1;
        }
    }
}
