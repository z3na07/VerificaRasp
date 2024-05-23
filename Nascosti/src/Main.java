import static tools.utility.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //dichiarazione varaibili
        String [] menuRub={"MENU","[1] - Aggiungi contatto", "[2] - Visualizza contatti", "[3] - Contatti nascosti", "[4] - Modifica Visibilità contatto","[5] - Esci"};
        Contatto [] rubrica=new Contatto[5];
        Scanner input = new Scanner(System.in);
        int cont=0;
        boolean esci=true;
        boolean trovata=false;

        //ciclo while per ripetizione del programma finchè non si esce
        do{


            switch( menu(menuRub, input)){

                case 1:

                    if(cont<5){
                        rubrica[cont]=Inserisci(input, cont);
                    }else
                        System.out.println("La rubrica è piena");
                    cont++;
                    break;

                case 2:
                    if(cont>0){
                        VisualizzaCon(rubrica, trovata, cont);
                    }
                    else
                        System.out.println("Non c'è nessun contatto da visualizzare");
                    break;

                case 3:
                    if(cont>0) {
                        trovata = Nacosti(input);

                        if(trovata){
                            System.out.println("ORA SARANNO VISIBILI I CONTATTI NASCOSTI");
                        }

                    }else
                        System.out.println("Nessun contatto nella rubrica");
                    break;

                case 4:
                    if(cont>0){
                        ModificaVisibilita(rubrica, input, trovata, cont);
                    }else System.out.println("Non ci sono contatti nella rubrica");
                    break;

                case 5:
                    esci=false;
                    break;

                default:
                    System.out.println("Scelta non valida");
                    break;

            }



        }while(esci);



    }


    //metodo di visualizzazione dei contatti
    private static void VisualizzaCon(Contatto [] rubrica, boolean trovata, int cont){



        for(int i=0;i<cont;i++){

            if(trovata==false) {
                if (rubrica[i].nascosto==false) {
                    System.out.print(rubrica[i].nome + " ");
                    System.out.println(rubrica[i].cognome + " ");


                }
            }else{
                System.out.print(rubrica[i].nome + " ");
                System.out.println(rubrica[i].cognome);
            }
            }


        }




    //metodo con password di controllo per visualizzazione contatti nascosti
    private static boolean Nacosti(Scanner input){


        //dichiarazione variabili
        String pws;
        boolean trovata=false;

        System.out.println("Inserire la password di sicurezza");
        pws = input.next();


        if(pws.equalsIgnoreCase("milfona34")){

            trovata=true;



        }else{
            System.out.println("Password errata");
        }

        return trovata;
    }

    //metodo di inserimento di un contatto nella rubrica
    private static Contatto Inserisci(Scanner input, int cont){

        //dichiarazione dell'oggetto creato
        Contatto persona=new Contatto();

        //presa in input degli attributi del contatto
        System.out.println("Inserisci il nome");
        persona.nome=input.next();
        System.out.println("Inserisci il cognome");
        persona.cognome=input.next();
        System.out.println("Inserisci il numero di telefono");
        persona.numero=input.next();

        System.out.println("Contatto creato!!");
        Wait(1);

        return persona;

    }


    private static Contatto [] ModificaVisibilita(Contatto [] rubrica, Scanner input, boolean trovata, int cont){

        //dichiarazione varaibili
        String nomeNasc=null;
        String sceltaR=null;

       do {

           //stampa di tutti i contatti + il loro stato di visibilità
           VisualizzaCon(rubrica, trovata, cont);


           //richiesta del nome del contatto che si vuole nascondere
           System.out.println("Inserisci il nome del contatto che vuoi nascondere, se si selezionerà un contatto gia nascosto verrà reso di nuovo visibile a tutti");
           nomeNasc = input.next();

           for (int j = 0; j < cont; j++) {

               if (rubrica[j].nome.equalsIgnoreCase(nomeNasc)) {
                   rubrica[j].nascosto = !rubrica[j].nascosto;
               }

           }

           System.out.println("Vuoi modificare la visibilità ad un altro contatto? Inserire o si o no");
           sceltaR = input.next();
           while (!sceltaR.equalsIgnoreCase("si") && !sceltaR.equalsIgnoreCase("no")) {
               System.out.println("Scelta non valida, reinserire");
               sceltaR = input.next();
           }
       }while(sceltaR.equalsIgnoreCase("si"));




        return rubrica;
    }
}