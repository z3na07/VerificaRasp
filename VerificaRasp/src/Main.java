import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //dichiarazione vairabili
        int tmp=0;
        int [] v= new int[10];
        Scanner input = new Scanner(System.in);

        //Metodom per l'inserimento dell'array
        Inserimento(v, input);

        //metodo di ordinamento del'array
        Ordinamento(v, tmp);

    }

    private static int[] Inserimento(int [] v, Scanner input){


        //presa in input dei valori nell'array
        for(int i=0;i<10;i++){

            System.out.println("Inserisci il "+(i+1)+" numero");
            v[i]=input.nextInt();
        }

        return v;
    }

    private static void Ordinamento(int [] v, int tmp){

        Stampa(v);

        /*ordinamento con i cicli for*/

        for(int i=0;i<v.length;i++){

            if(v[i]%2==0){
                for(int j=0;j<v.length;j++){
                    if(v[j]%2==0){
                        if(v[i]>v[j]){
                            tmp=v[i];
                            v[i]=v[j];
                            v[j]=tmp;

                        }
                    }
                }
            }
        }

        StampaOr(v);


    }



    private static void Stampa(int [] v){

        System.out.println("--ARRAY NON ORDINATO--");

        for(int i=0;i<v.length;i++){

            System.out.println(v[i]);
        }


    }

    private static void StampaOr(int [] v){

        System.out.println("--ARRAY ORDINATO--");

        for(int i=0;i<v.length;i++){

            System.out.println(v[i]);
        }


    }


}