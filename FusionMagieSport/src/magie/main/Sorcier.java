package magie.main;

import sport.main.Joueur;
import sport.main.Sport;

public class Sorcier extends Joueur {
    private String race;
    private Magie magie;


    public Sorcier(String nom, Sport sport, String race, Magie magie) {
        super(nom, sport);
        this.race = race;
        this.magie = magie;
    }

    public void setMagie(Magie magie){
        this.magie = magie;
    }

    public Magie getMagie() {
        return this.magie;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int sortRaciale() {
        int score = this.getSport().scoreTotal(); //Rajouté après la fusion
        switch(this.race){
            case "elfe":
                return 3*score*magie.degatSort();
            case "troll":
                return 2*score*magie.degatSort();
            case "humain" :
                return score*magie.degatSort();
            default :
                return 0;
        }
    }

    @Override
    public void pratiquerSport() {
        System.out.println(getNom() + " est un " + race + " qui pratique le sport " + getSport().getNomSport()
                + " avec un score total de " + getSport().scoreTotal()
                + " et utilise la magie de type " + magie.getType() + " avec une puissance de " + magie.getPuissance());
    }
}
