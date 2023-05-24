package fusionArene;
import magie.main.Sorcier;

public class Arene {
    private static Arene instance;
    private Sorcier sorcier1;
    private int vie1;
    private Sorcier sorcier2;
    private int vie2;

    private Arene() {
    }

    public static Arene getInstance() {
        if (instance == null) {
            instance = new Arene();
        }
        return instance;
    }

    public void initialize(Sorcier sorcier1, Sorcier sorcier2){
        instance.sorcier1 = sorcier1;
        instance.vie1 = 150;
        instance.sorcier2 = sorcier2;
        instance.vie2 = 150;
    }


    public int getVie1(){
        return instance.vie1;
    }
    public void setVie1(int vie){
        instance.vie1 = vie;
    }
    public void setVie2(int vie){
        instance.vie2 = vie;
    }
    public int getVie2(){
        return instance.vie2;
    }
    public void setSorcier1(Sorcier sorcier) {
        instance.sorcier1 = sorcier;
    }
    public Sorcier getSorcier1() {
        return instance.sorcier1;
    }

    public void setSorcier2(Sorcier sorcier) {
        instance.sorcier2 = sorcier;
    }
    public Sorcier getSorcier2() {
        return instance.sorcier2;
    }
    public void attaquerSorcier1(){
        int degat = instance.sorcier2.sortRaciale();
        int vieInitial = instance.vie1;
        int vieFinale= vieInitial-degat;
        instance.setVie1(vieFinale);
    }
    public void attaquerSorcier2(){
        int degat = instance.sorcier1.sortRaciale();
        int vieInitial = instance.vie2;
        int vieFinale= vieInitial-degat;
        instance.setVie2(vieFinale);
    }


    public String victoire(){
        if(instance.vie1 < 0){
            return "Le sorcier " + instance.sorcier2.getNom() +" a remporté le duel.";
        }
        if(instance.vie2 < 0){
            return "Le sorcier " + instance.sorcier1.getNom() +" a remporté le duel.";
        }
        return "La partie est toujours en cours";
    }
}
