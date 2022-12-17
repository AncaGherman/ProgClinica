package obiectesiclase;

import java.util.Scanner;

import static java.lang.System.exit;

public class AgendaDePersons {

    static Person[] agenda = new Person[4] ;

    public static void main(String[] args) {

        String optiunee, name, phone;
        int optiune;

        Scanner scanner = new Scanner(System.in) ;

        do {
            System.out.println("Meniu: ");
            System.out.println("1. Afisare agenda.");
            System.out.println("2. Adaugare in agenda.");
            System.out.println("3. Inlocuieste in agenda.");
            System.out.println("4. Sterge din agenda.");
            System.out.println("5. Cautare in agenda");
            System.out.println("6. Iesire din agenda");

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
                    name = scanner.nextLine();
                    System.out.println("Introduceti telefonul de adaugat: ");
                    phone = scanner.nextLine();
                    System.out.println("Introduceti telefonul de serviciu: ");
                    String pj = scanner.nextLine();

                    Person p=new Person(name,phone);
                    p.setPhonejob(pj);

                    boolean v = addInAgenda(p);
                    if(!v)
                    {
                        System.out.println("agenda plina, sorry!");
                    }
                    break;
                case 3:     //Putem modifica numele, sau doar telefoanele
                    System.out.println("Introduceti numele existent: ");
                    String actualName = scanner.nextLine();
                    System.out.println("Introduceti numele nou sau ENTER daca nu se modifica numele: ");
                    name = scanner.nextLine();
                    if (name=="") {
                        name=actualName;
                    }
                    System.out.println(replaceInAgenda(actualName, name));
                    break;
                case 4:
                    System.out.println("Introduceti numele de sters: ");
                    name = scanner.nextLine();
                    System.out.println(deleteFromAgenda(name));
                    break ;
                case 5:
                    System.out.println("Introduceti numele de cautat: ");
                    name= scanner.nextLine();
                    System.out.println(searchInAgenda(name));
                    break ;
                case 6:
                    exit(1);
            }

        }while (optiune < 7 && optiune>0) ;

    }

    /* Display Agenda using for loop */
    public static void displayAgenda ( ) {
        System.out.println("Afisarea agendei: ");
        for (Person i : agenda) {
            if(i!=null) {
                System.out.println(i.getName()+" phone:"+i.getPhone()+" phone-job:"+i.getPhonejob());
            }
        }
    }
    public static boolean addInAgenda(Person pers ) {
        boolean foundIt = false ;
        for ( int countIn = 0 ; countIn < agenda.length ; countIn ++ ) {
            if ( agenda[countIn] == null ) { //pozitie goala
                agenda[countIn] = pers;
                foundIt = true ;
                break;
            }
        }
        return foundIt ;
    }
    public static boolean replaceInAgenda ( String actual, String nou) {
        String ph;
        boolean foundIt = false ;
        for (Person i : agenda) {
            if (i.getName().equals(actual)) {
                i.setName(nou);
                System.out.println(i.getName()+" phone:"+i.getPhone()+" phone-job:"+i.getPhonejob());
                System.out.println("Telefonul nou (sau ENTER daca nu se modifica): ");
                ph = new Scanner(System.in).nextLine();
                if (ph!="") {
                    i.setPhone(ph);
                }
                System.out.println("Telefonul de serv nou (sau ENTER daca nu se modifica): ");
                ph = new Scanner(System.in).nextLine();
                if (ph!="") {
                    i.setPhonejob(ph);
                }
                foundIt=true;
                break;
            }
        }
        return foundIt ;
    }
    public static boolean deleteFromAgenda ( String nume ) {
          boolean foundIt = false ;
          for ( int countIn = 0 ; countIn < agenda.length ; countIn ++ ) {
              if (agenda[countIn] != null && agenda[countIn].getName().equals(nume)) {
                  foundIt = true;
                  agenda[countIn] = null;
              }
          }
          return foundIt ;
    }
    public static boolean searchInAgenda (String name ) {
          boolean foundIt = false ;
          for (Person i : agenda) {
            if (i!=null && i.getName().equals(name)) {
                foundIt = true;
            }
        }
        return foundIt ;
    }


}
