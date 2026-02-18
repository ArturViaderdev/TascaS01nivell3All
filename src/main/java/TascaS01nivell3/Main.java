package TascaS01nivell3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static ArrayList<Editor> editors;
    private static ArrayList<New> news;
    private static String menu()
    {
        System.out.println("Sel.lecciona una opció:");
        System.out.println("1 - Introduir redactor");
        System.out.println("2 - Eliminar redactor");
        System.out.println("3 - Introduir notícia a un redactor");
        System.out.println("4 - Eliminar noticia");
        System.out.println("5 - Mostrar totes les noticies d'un redactor");
        System.out.println("6 - Calcular puntuació d’una notícia");
        System.out.println("7 - Calcular preu d’una notícia");
        System.out.println("0 - Sortir");

        return scanner.nextLine();
    }

    private static boolean notexisteditor(String dni)
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
        return !encontrado;
    }

    private static New insertTitleTextNew(New noticia)
    {
        System.out.println("Introdueix el títol de la noticia.");
        String title = scanner.nextLine();
        System.out.println("Introdueix el text de la noticia.");
        String text = scanner.nextLine();
        noticia.setTitle(title);
        noticia.setText(text);
        return noticia;
    }

    private static F1 fillNewF1(F1 noticia)
    {
        System.out.println("Introdueix la escuderia:");
        String team = scanner.nextLine();
        noticia.setTeam(team);

        return noticia;
    }

    private static Motorcycling fillNewMotorcycling(Motorcycling noticia)
    {
        System.out.println("Introdueix l'equip:");
        String team = scanner.nextLine();
        noticia.setTeam(team);

        return noticia;
    }

    private static Football fillNewFootball(Football noticia)
    {
        System.out.println("Introdueix la competició:");
        String competition = scanner.nextLine();
        noticia.setCompetition(competition);


        System.out.println("Introdueix el club:");
        String club = scanner.nextLine();
        noticia.setClub(club);

        System.out.println("Introdueix el jugador:");
        String player = scanner.nextLine();
        noticia.setPlayer(player);

        return noticia;
    }

    private static Basket fillNewBasket(Basket noticia)
    {
        System.out.println("Introdueix la competició:");
        String competition = scanner.nextLine();
        noticia.setCompetition(competition);

        System.out.println("Introdueix el club:");
        String club = scanner.nextLine();
        noticia.setClub(club);

        return noticia;
    }

    private static Tenis fillNewTenis(Tenis noticia)
    {
        System.out.println("Introdueix la competició:");
        String competition = scanner.nextLine();
        noticia.setCompetition(competition);
        System.out.println("Anem a introduir els diversos tenistes.");
        String tenista;
        do {
            System.out.println("Introdueix un tenista. O posa 0 per parar.");
            tenista = scanner.nextLine();
            if(!(tenista.equals("0")))
            {
                noticia.addPlayer(tenista);
                System.out.println("Tenista afegit");
            }
        }while(!tenista.equals("0"));
        return noticia;
    }

    private static boolean deleteeditordni(String dni)
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

    private static int searchDni(String dni)
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

    private static int searchName(String name)
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

    private static int deleteNew(String name, String title)
    {
        int cont = 0;
        boolean sal = false;
        boolean encontrado = false;
        while(!sal)
        {
            if(cont<news.size())
            {
                if(news.get(cont).getTitle().equals(title))
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

    private static void deletenewsDni(String dni)
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

    private static void showNew(int position)
    {
        System.out.println("Títol:" + news.get(position).getTitle());
        System.out.println("Text:" + news.get(position).getText());

        String tipus = news.get(position).getType();
        if(tipus.equals("class Fooball"))
        {
            Football noticia = (Football) news.get(position);
            System.out.println("Tipus de noticia: Fútbol.");
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
            System.out.println("Jugador: " + noticia.getPlayer());
        }
        else if(tipus.equals("class Basket"))
        {
            System.out.println("Tipus de noticia: Basket.");
            Basket noticia = (Basket) news.get(position);
            System.out.println("Competició: " + noticia.getCompetition());
            System.out.println("Club:" + noticia.getClub());
        }
        else if(tipus.equals("class Tenis"))
        {
            System.out.println("Tipus de noticis: Tenis");
            Tenis noticia = (Tenis) news.get(position);
            System.out.println("Competició: " + noticia.getCompetition());
            showPlayers(noticia.getPlayers());
        }
        else if(tipus.equals("class F1"))
        {
            System.out.println("Tipus de noticia: F1");
            F1 noticia = (F1) news.get(position);
            System.out.println("Escuderia: " + noticia.getTeam());
        }
        else if(tipus.equals("class Motorcycling"))
        {
            System.out.println("Tipus de noticia: Motos");
            Motorcycling noticia = (Motorcycling) news.get(position);
            System.out.println("Equip: " + noticia.getTeam());
        }
    }

    private static void showPlayers(ArrayList<String> players)
    {
        int cont = 0;
        while(cont<players.size())
        {
            System.out.println(players.get(cont));
            cont++;
        }
    }

    private static void shownewsDNI(String dni)
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

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        editors = new ArrayList<>();
        news = new ArrayList<>();

        System.out.println("Programa de noticies");
        System.out.println("--------------------");
        System.out.println("");

        String opcio;

        do
        {
            opcio = menu();
            if(opcio.equals("1"))
            {
                System.out.println("Introduir redactor");
                System.out.println("------------------");
                System.out.println("Introdueix el nom del redactor:");
                String name = scanner.nextLine();
                System.out.println("Introdueix el dni del redactor:");
                String dni = scanner.nextLine();
                if(notexisteditor(dni))
                {
                    editors.add(new Editor(dni,name));
                    System.out.println("Editor afegit");
                }
                else {
                    System.out.println("Ja existeix un redactor amb aquest dni. Operació cancel.lada.");
                }
            }
            else if(opcio.equals("2"))
            {
                System.out.println("Eliminar redactor");
                System.out.println("-----------------");
                System.out.println("Vols eliminar introduint el DNI o mostrant llista?");
                System.out.println("1-Introduint dni.");
                System.out.println("2-Mostrant llista.");
                String tipus = scanner.nextLine();
                if(tipus.equals("2"))
                {
                    System.out.println("Quin redactor vols eliminar?");
                    System.out.println("0 - Cancel.lar");
                    showeditors();
                    int editortodelete = 0;
                    try
                    {
                        editortodelete = Integer.parseInt(scanner.nextLine());
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Opció incorrecta");
                    }
                    if(editortodelete==0)
                    {
                        System.out.println("Operació cancel.lada");
                    }
                    else
                    {
                        if(editors.size()>editortodelete-1)
                        {
                            String dni = editors.get(editortodelete-1).getDni();
                            deleteeditor(editortodelete-1);
                            System.out.println("Redactor eliminat");
                            System.out.println("Eliminant noticies del redactor.");
                            deletenewsDni(dni);
                        }
                        else{
                            System.out.println("Opció incorrecta.");
                        }
                    }
                }
                else if(tipus.equals("1"))
                {
                    System.out.println("Introdueix el dni del redactor que vols eliminar.");
                    String dnidelete = scanner.nextLine();
                    if(deleteeditordni(dnidelete))
                    {
                        System.out.println("Redactor eliminat");
                        System.out.println("Eliminant noticies del redactor");
                        deletenewsDni(dnidelete);
                    }
                    else
                    {
                        System.out.println("El redactor amb aquest dni no existeix");
                    }
                }
               else {
                    System.out.println("Opció incorrecte");
                }
            }
            else if(opcio.equals("3"))
            {
                System.out.println("Introduir noticia a un redactor");
                System.out.println("-------------------------------");
                System.out.println("Sel.lecciona a quin redactor afegiras la noticia.");
                showeditors();
                int editornew;
                try
                {
                    editornew = Integer.parseInt(scanner.nextLine());
                    if(editornew>0 && (editornew-1)<editors.size())
                    {
                        New noticia;
                        String dni = editors.get(editornew-1).getDni();
                        System.out.println("Selecciona el tipus de noticia.");
                        System.out.println("1-Futbol");
                        System.out.println("2-Basquet");
                        System.out.println("3-Tenis");
                        System.out.println("4-F1");
                        System.out.println("5-Motociclisme");

                        String newtype = scanner.nextLine();

                        if(newtype.equals("1"))
                        {
                            System.out.println("Creant noticia de futbol per al redactor " + editors.get(editornew-1)) ;
                            noticia = new Football(dni);
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewFootball((Football) noticia);
                            news.add(noticia);
                        }
                        else if(newtype.equals("2"))
                        {
                            System.out.println("Creant noticia de baquet per al redactor " + editors.get(editornew-1)) ;
                            noticia = new Basket(dni);
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewBasket((Basket) noticia);
                            news.add(noticia);
                        }
                        else if(newtype.equals("3"))
                        {
                            System.out.println("Creant noticia de tenis per al redactor " + editors.get(editornew-1)) ;
                            noticia = new Tenis(dni);
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewTenis((Tenis) noticia);
                            news.add(noticia);
                        }
                        else if(newtype.equals("4"))
                        {
                            System.out.println("Creant noticia de F1 per al redactor " + editors.get(editornew-1)) ;
                            noticia = new F1(dni);
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewF1((F1) noticia);
                            news.add(noticia);
                        }
                        else if(newtype.equals("5"))
                        {
                            System.out.println("Creant noticia de motociclisme per al redactor " + editors.get(editornew-1)) ;
                            noticia = new Motorcycling(dni);
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewMotorcycling((Motorcycling) noticia);
                            news.add(noticia);
                        }
                        System.out.println("Noticia afegida.");
                    }
                    else
                    {
                        System.out.println("Opció incorrecta");
                    }
                }
                catch(Exception ex)
                {
                    System.out.println("Opció incorrecta");
                }

            }
            else if(opcio.equals("4"))
            {
                System.out.println("Eliminar noticia");
                System.out.println("----------------");
                System.out.println("Introdueix el nom del redactor.");
                String nom = scanner.nextLine();
                System.out.println("Introdueix el títol de la noticia");
                String title = scanner.nextLine();
                int resultat = deleteNew(nom,title);
                if(resultat == 0)
                {
                    System.out.println("Noticia eliminada");
                }
                else if(resultat == 1)
                {
                    System.out.println("No existeix una noticia amb aquest títol.");
                }
                else if(resultat == 2)
                {
                    System.out.println("Existeix una noticia amb aquest títol pero no es de aquest redactor. Operació cancelada.");
                }

            }
            else if(opcio.equals("5"))
            {
                System.out.println("Mostrar totes les noticies de un redactor");
                System.out.println("-----------------------------------------");
                System.out.println("Vols seleccionar el redactor de una llista o posar el dni?");
                System.out.println("1 - Seleccionar de llista.");
                System.out.println("2 - Posar dni.");
                String selectmode = scanner.nextLine();
                int editorsearch = 0;
                if(selectmode.equals("1"))
                {
                    showeditors();
                    try
                    {
                        editorsearch = Integer.parseInt(scanner.nextLine());
                        editorsearch--;
                        String dni = editors.get(editorsearch).getDni();
                        shownewsDNI(dni);
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Opció incorrecta");
                    }
                }
                else if(selectmode.equals("2"))
                {
                    System.out.println("Introdueix el nom del redactor.");
                    String name = scanner.nextLine();
                    editorsearch = searchName(name);
                    shownewsDNI(editors.get(editorsearch).getDni());
                }
                else {
                    System.out.println("Opció incorrecte");
                }
            }
            else if(opcio.equals("6"))
            {
                System.out.println("Calcular la puntuació d'una noticia");
                System.out.println("-----------------------------------");
                System.out.println("Selecciona la noticia");
                showNews();
                try
                {
                    int choose = Integer.parseInt(scanner.nextLine());

                    if(choose>0 && choose<=news.size()-1);
                    {
                        choose--;
                        news.get(choose).CalculatePointsNew();
                        System.out.println("Puntuació: " + news.get(choose).getPoints());
                    }
                }
               catch(Exception ex)
               {
                   System.out.println("Error de entrada.");
               }
            }
            else if(opcio.equals("7"))
            {
                System.out.println("Calcular el preu d'una noticia");
                System.out.println("------------------------------");
                System.out.println("Selecciona la noticia");
                showNews();
                try
                {
                    int choose = Integer.parseInt(scanner.nextLine());

                    if(choose>0 && choose<=news.size()-1);
                    {
                        choose--;
                        news.get(choose).CalculatePriceNew();
                        System.out.println("Preu: " + news.get(choose).getPrice());
                    }
                }
                catch(Exception ex)
                {
                    System.out.println("Error de entrada.");
                }
            }

        }while(!(opcio.equals("0")));
        System.out.println("Adeu, gràcies per utilitzar el programa.");
        System.exit(0);
    }

    private static void showNews()
    {
        int cont = 0;
        while(cont<news.size())
        {
            System.out.println(Integer.toString(cont+1));
            showNew(cont);
            cont++;
        }
    }

    private static void showeditors()
    {
        int conteditor=0;
        while(conteditor<editors.size())
        {
            System.out.println(Integer.toString(conteditor +1) + " - Nom:" + editors.get(conteditor).getName() + " DNI - " + editors.get(conteditor).getDni() + " Sou - " + editors.get(conteditor).getSalary());
            conteditor++;

        }
    }

    private static void deleteeditor(int editortodelete)
    {
        editors.remove(editortodelete);
        System.out.println("Redactor el.liminat");
    }
}
