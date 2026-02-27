package TascaS01nivell3NewsInsideEditors;

import java.util.Scanner;

public class UiConsole {
    private final Scanner scanner;
    private final DataMethods dataMethods;
    public UiConsole()
    {
        scanner = new Scanner(System.in);
        dataMethods = new DataMethods();
    }
    public void start()
    {
        System.out.println("Programa de noticies");
        System.out.println("--------------------");

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
                dataMethods.insertEditor(dni,name);
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
                    dataMethods.showEditors();
                    int editorToDelete = 0;
                    try
                    {
                        editorToDelete = Integer.parseInt(scanner.nextLine());
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Opció incorrecta");
                    }
                    if(editorToDelete==0)
                    {
                        System.out.println("Operació cancel.lada");
                    }
                    else
                    {
                        dataMethods.deleteEditorProcess(editorToDelete);
                    }
                }
                else if(tipus.equals("1"))
                {
                    System.out.println("Introdueix el dni del redactor que vols eliminar.");
                    String dniDelete = scanner.nextLine();
                    if(dataMethods.deleteEditorDni(dniDelete))
                    {
                        System.out.println("Redactor eliminat");
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
                System.out.println("Sel.lecciona a quin redactor afegiràs la noticia.");
                dataMethods.showEditors();
                int editorNew;
                try
                {
                    editorNew = Integer.parseInt(scanner.nextLine());
                    if(dataMethods.rangeEditorCorrect(editorNew))
                    {
                        Noticia noticia;
                        String dni = dataMethods.getEditorDNI(editorNew-1);
                        System.out.println("Selecciona el tipus de noticia.");
                        System.out.println("1-Futbol");
                        System.out.println("2-Basquet");
                        System.out.println("3-Tenis");
                        System.out.println("4-F1");
                        System.out.println("5-Motociclisme");

                        String newType = scanner.nextLine();

                        if(newType.equals("1"))
                        {
                            System.out.println("Creant noticia de futbol per al redactor " + dataMethods.getEditorName(editorNew-1)) ;
                            noticia = new Football();
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewFootball((Football) noticia);
                            dataMethods.addNew(noticia,dni);
                        }
                        else if(newType.equals("2"))
                        {
                            System.out.println("Creant noticia de basquet per al redactor " + dataMethods.getEditorName(editorNew-1)) ;
                            noticia = new Basket();
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewBasket((Basket) noticia);
                            dataMethods.addNew(noticia,dni);
                        }
                        else if(newType.equals("3"))
                        {
                            System.out.println("Creant noticia de tenis per al redactor " + dataMethods.getEditorName(editorNew-1)) ;
                            noticia = new Tenis();
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewTenis((Tenis) noticia);
                            dataMethods.addNew(noticia,dni);
                        }
                        else if(newType.equals("4"))
                        {
                            System.out.println("Creant noticia de F1 per al redactor " + dataMethods.getEditorName(editorNew-1)) ;
                            noticia = new F1();
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewF1((F1) noticia);
                            dataMethods.addNew(noticia,dni);
                        }
                        else if(newType.equals("5"))
                        {
                            System.out.println("Creant noticia de motociclisme per al redactor " + dataMethods.getEditorName(editorNew-1)) ;
                            noticia = new Motorcycling();
                            noticia = insertTitleTextNew(noticia);
                            noticia = fillNewMotorcycling((Motorcycling) noticia);
                            dataMethods.addNew(noticia,dni);
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
                int resultat = dataMethods.deleteNew(nom,title);
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
                    System.out.println("No existeix el redactor.");
                }

            }
            else if(opcio.equals("5"))
            {
                System.out.println("Mostrar totes les noticies de un redactor");
                System.out.println("-----------------------------------------");
                System.out.println("Vols seleccionar el redactor de una llista o posar el nom?");
                System.out.println("1 - Seleccionar de llista.");
                System.out.println("2 - Posar nom.");
                String selectMode = scanner.nextLine();
                int editorSearch = 0;
                if(selectMode.equals("1"))
                {
                    dataMethods.showEditors();
                    try
                    {
                        editorSearch = Integer.parseInt(scanner.nextLine());
                        editorSearch--;
                        String dni = dataMethods.getEditorDNI(editorSearch);
                        dataMethods.showNewsDNI(dni);
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Opció incorrecta");
                    }
                }
                else if(selectMode.equals("2"))
                {
                    System.out.println("Introdueix el nom del redactor.");
                    String name = scanner.nextLine();
                    editorSearch = dataMethods.searchName(name);
                    if (editorSearch == -1)
                    {
                        System.out.println("No es troba el redactor");
                    }
                    else
                    {
                        dataMethods.showNewsDNI(dataMethods.getEditorDNI(editorSearch));
                    }
                }
                else {
                    System.out.println("Opció incorrecte");
                }
            }
            else if(opcio.equals("6"))
            {
                System.out.println("Calcular la puntuació d'una noticia");
                System.out.println("-----------------------------------");
                System.out.println("Introdueix el nom del redactor.");
                String name = scanner.nextLine();
                int editorSearch = dataMethods.searchName(name);
                if (editorSearch == -1)
                {
                    System.out.println("No es troba el redactor");
                }
                else {
                    System.out.println("Selecciona la noticia");
                    dataMethods.showNews(editorSearch);
                    try {
                        int choose = Integer.parseInt(scanner.nextLine());

                        if (dataMethods.rangeNewCorrect(choose,editorSearch))
                        {
                            choose--;
                            dataMethods.calculatePointsNew(choose,editorSearch);
                            System.out.println("Puntuació: " + dataMethods.getPointsNew(choose,editorSearch));
                        }
                    } catch (Exception ex) {
                        System.out.println("Error de entrada.");
                    }
                }
            }
            else if(opcio.equals("7"))
            {
                System.out.println("Calcular el preu d'una noticia");
                System.out.println("------------------------------");
                System.out.println("Introdueix el nom del redactor.");
                String name = scanner.nextLine();
                int editorSearch = dataMethods.searchName(name);
                if (editorSearch == -1)
                {
                    System.out.println("No es troba el redactor");
                }
                else {
                    System.out.println("Selecciona la noticia");
                    dataMethods.showNews(editorSearch);
                    try {
                        int choose = Integer.parseInt(scanner.nextLine());

                        if (dataMethods.rangeNewCorrect(choose,editorSearch))
                        {
                            choose--;
                            dataMethods.calculatePriceNew(choose,editorSearch);
                            System.out.println("Preu: " + dataMethods.getNewPrice(choose,editorSearch));
                        }
                    } catch (Exception ex) {
                        System.out.println("Error de entrada.");
                    }
                }
            }

        }while(!(opcio.equals("0")));
        System.out.println("Adeu, gràcies per utilitzar el programa.");
        System.exit(0);
    }

    private String menu()
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

    private Noticia insertTitleTextNew(Noticia noticia)
    {
        System.out.println("Introdueix el títol de la noticia.");
        String title = scanner.nextLine();
        System.out.println("Introdueix el text de la noticia.");
        String text = scanner.nextLine();
        noticia.setTitle(title);
        noticia.setText(text);
        return noticia;
    }

    private F1 fillNewF1(F1 noticia)
    {
        System.out.println("Introdueix la escuderia:");
        String team = scanner.nextLine();
        noticia.setTeam(team);

        return noticia;
    }

    private Motorcycling fillNewMotorcycling(Motorcycling noticia)
    {
        System.out.println("Introdueix l'equip:");
        String team = scanner.nextLine();
        noticia.setTeam(team);

        return noticia;
    }

    private Football fillNewFootball(Football noticia)
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

    private Basket fillNewBasket(Basket noticia)
    {
        System.out.println("Introdueix la competició:");
        String competition = scanner.nextLine();
        noticia.setCompetition(competition);

        System.out.println("Introdueix el club:");
        String club = scanner.nextLine();
        noticia.setClub(club);

        return noticia;
    }

    private Tenis fillNewTenis(Tenis noticia)
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
}
