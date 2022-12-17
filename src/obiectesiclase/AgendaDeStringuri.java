package obiectesiclase;

import java.util.Scanner;

import static java.lang.System.exit;

public class AgendaDeStringuri {

    static String[] agenda = new String[4] ;

    public static void main(String[] args) {

        String optiunee, nume;
        int optiune, numar  ;

        Scanner scanner = new Scanner(System.in) ;

        do {
            System.out.println("Meniu: ");
            System.out.println();
            System.out.println("1. Afisare agenda.");
            System.out.println("2. Adaugare in agenda.");
            System.out.println("3. Inlocuieste in agenda.");
            System.out.println("4. Sterge din agenda.");
            System.out.println("5. Cautare in agenda");

            System.out.println("Introduceti optiune: ");
            Scanner getOption = new Scanner( System.in) ;
            optiunee = getOption.nextLine();

            optiune = Integer.parseInt( optiunee ) ;
            switch(optiune) {
                case 1:
                    displayAgenda();
                    break;
                case 2:
                    System.out.println("Introduceti numele de adaugat: ");
                    nume = scanner.nextLine();

                    int v = addInAgenda(nume);
                    if(v==0)
                    {
                        System.out.println("agenda plina, sorry!");
                    }
                    break;
                case 3:
                    System.out.println("Introduceti numele existent: ");
                    String existent = scanner.nextLine();
                    System.out.println("Introduceti numele nou: ");
                    nume = scanner.nextLine();
                    System.out.println(replaceInAgenda(existent, nume));
                    break;
                case 4:
                    System.out.println("Introduceti numele de sters: ");
                    nume = scanner.nextLine();
                    System.out.println(deleteFromAgenda(nume));
                    break ;
                case 5:
                    System.out.println("Introduceti numele de cautat: ");
                    nume= scanner.nextLine();
                    System.out.println(searchInAgenda(nume));
                    break ;
                case 6:
                    exit(1);
            }

        }while (optiune < 7 && optiune>0) ;

    }

    /* Display Agenda using for loop */
    public static void displayAgenda ( ) {
        System.out.println("Afisarea agendei: ");
        for (String i : agenda) {
            if(i!=null)
                System.out.println(i);
        }
    }
    public static int addInAgenda(String numarul ) {
        int foundIt = 0 ;
        for ( int countIn = 0 ; countIn < agenda.length ; countIn ++ ) {
            if ( agenda[countIn] == null ) { //poztie goala
                agenda[countIn] = numarul ;
                return foundIt = 1 ;

            }
        }
        return foundIt ;
    }
    public static int replaceInAgenda ( String actualNumber, String numarulNou) {
        int foundIt = 0 ;
        for ( int countIn = 0 ; countIn < agenda.length ; countIn ++ ) {
            if ( agenda[countIn]!=null && agenda[countIn].equals(actualNumber )) { // comparatie stringuri
                agenda[countIn] = numarulNou ;
                return foundIt = 1 ;
            }
        }
        return foundIt ;
    }
    public static int deleteFromAgenda ( String numarul ) {
        int foundIt = 0 ;
        for ( int countIn = 0 ; countIn < agenda.length ; countIn ++ ) {
            if ( agenda[countIn]!=null && agenda[countIn].equals(numarul) ) {
                foundIt = 1 ;
                agenda[countIn] = null;
            }
        }
        return foundIt ;
    }
    public static int searchInAgenda (String numarul ) {
        int foundIt = 0 ;
        for (String i : agenda) {
            if (i!=null && i.equals(numarul)) {
                foundIt = 1;
            }
        }
        return foundIt ;
    }


}