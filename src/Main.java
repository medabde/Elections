import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // setting up variables ...
        List<Liste> listes= new ArrayList<>();
        Liste liste;
        int nbSieges;
        int nbSiegesLeft;
        int nbListes;

        //start entering data

        Scanner sc = new Scanner(System.in);

        System.out.println("entrer le nombre de sièges à pourvoir : ");
        nbSieges=sc.nextInt();

        while (nbSieges<=0){
            System.out.println("ERREUR : le nombre de sièges ne doit pas etre negative ou egale a 0\n");
            System.out.println("entrer encore le nombre de sièges à pourvoir : ");
            nbSieges=sc.nextInt();
        }

        System.out.println("entrer le nombre de listes en compétition : ");
        nbListes=sc.nextInt();
        while (nbListes<=0){
            System.out.println("ERREUR : le nombre de listes en compétition ne doit pas etre negative ou egale a 0\n");
            System.out.println("entrer encore le nombre de listes en compétition : ");
            nbListes=sc.nextInt();
        }

        for (int i = 1; i <= nbListes ; i++) {
            liste = new Liste();
            System.out.println("LISTE NUMERO "+i+"\n");
            System.out.println("nom de la liste : ");
            liste.setNom(sc.nextLine());
            liste.setNom(sc.nextLine());
            System.out.println("nombre de voix de la liste : ");
            liste.setNbVoix(sc.nextInt());
            while (liste.getNbVoix()<=0){
                System.out.println("ERREUR : le nombre de voix ne doit pas etre negative ou egale a 0\n");
                System.out.println("entrer encore le nombre de voix de la liste : ");
                liste.setNbVoix(sc.nextInt());
            }


            listes.add(liste);
        }

        //end entering data

        setPourcentages(listes);  // give to each list a percentage
        deleteUnder5(listes); // delete lists that has less than 5% voix
        nbSiegesLeft=quotientElectoral(listes,nbSieges); // calculate the quotient electoral and give each list its corresponding nb sieges (it returns nb sieges restant)

        distributeSiegesLeft(listes,nbSiegesLeft);

        Utils.displayListe(listes);



    }

    public static void setPourcentages(List<Liste> listes){
        int voixTotale=Utils.getNbTotaleVoix(listes);
        for (int i = 0; i <listes.size() ; i++) {
            listes.get(i).setPourcentage(Utils.getPourcentage(listes.get(i).getNbVoix(),voixTotale));
        }
    }

    public static void deleteUnder5(List<Liste> listes){
        for (int i = 0; i <listes.size() ; i++) {
            if (listes.get(i).getPourcentage()<5.0){
                Utils.deleteItemByName(listes.get(i).getNom(),listes);
                //listes.remove(listes.get(i));
                i=0;
            }
        }
    }

    public static int quotientElectoral(List<Liste> listes,int nbSieges){
        int res=nbSieges;
        int voixTotale=Utils.getNbTotaleVoix(listes);
        int quotientElectoral=voixTotale/nbSieges;
        for (int i = 0; i <listes.size() ; i++) {
            if (listes.get(i).getNbVoix()>=quotientElectoral){
                listes.get(i).setNbSieges(listes.get(i).getNbVoix()/quotientElectoral);
                res = res-listes.get(i).getNbSieges();
            }
        }
        return res;
    }

    public static void setReparationScore(List<Liste> listes){
        for (int i = 0; i < listes.size() ; i++) {
            listes.get(i).setReparationScore(listes.get(i).getNbVoix()/(listes.get(i).getNbSieges()+1));
        }
    }

    public static void distributeSiegesLeft(List<Liste> listes,int nbSiegesLeft){
        int max;
        int maxid;
        for (int i = 0; i < nbSiegesLeft; i++) {
            max=Integer.MIN_VALUE;
            maxid=0;
            setReparationScore(listes);
            for (int k = 0; k < listes.size() ; k++) {
                if (listes.get(k).getReparationScore()>max){
                    max=listes.get(k).getReparationScore();
                    maxid=k;
                }
            }
            listes.get(maxid).setNbSieges(listes.get(maxid).getNbSieges()+1);
        }

    }
}
