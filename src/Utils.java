import java.util.List;

public class Utils {

    public double getPourcentage(double ValeurPartielle,double ValeurTotale){
        double res= (ValeurPartielle/ValeurTotale)*100;
        return res;
    }

    public int getNbTotaleVoix(List<Liste> listes){
        int nbVoix=0;
        for (int i = 0; i < listes.size() ; i++) {
            nbVoix += listes.get(i).getNbVoix();
        }
        return nbVoix;
    }

    public void deleteItemByName(String nom,List<Liste> listes){
        for (int i = 0; i <listes.size() ; i++) {
            if (nom.equals(listes.get(i).getNom())){
                listes.remove(i);
                break;
            }
        }
    }

    public void displayListe(List<Liste> listes){
        for (int i = 0; i < listes.size() ; i++) {
            if (listes.get(i).getNbSieges()>0) {
                if (listes.get(i).getNbSieges()==1){
                    System.out.println("Liste " + listes.get(i).getNom() + " : " + listes.get(i).getNbSieges() + "  siège");
                }else {
                    System.out.println("Liste " + listes.get(i).getNom() + " : " + listes.get(i).getNbSieges() + "  sièges");
                }
            }
        }
    }

}
