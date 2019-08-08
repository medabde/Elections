public class Liste {
    private String nom;
    private int nbVoix;
    private double pourcentage;
    private int nbSieges=0;
    private int reparationScore;

    public int getReparationScore() {
        return reparationScore;
    }

    public void setReparationScore(int reparationScore) {
        this.reparationScore = reparationScore;
    }

    public int getNbSieges() {
        return nbSieges;
    }

    public void setNbSieges(int nbSieges) {
        this.nbSieges = nbSieges;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbVoix() {
        return nbVoix;
    }

    public void setNbVoix(int nbVoix) {
        this.nbVoix = nbVoix;
    }
}
