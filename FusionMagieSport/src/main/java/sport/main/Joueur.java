package sport.main;

public class Joueur {
    private String nom;
    private Sport sport;

    public Joueur(String nom, Sport sport) {
        this.nom = nom;
        this.sport = sport;
    }

    // Getters
    public String getNom() {
        return this.nom;
    }

    public Sport getSport() {
        return this.sport;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public void pratiquerSport() {
        System.out.println(nom + " pratique le sport " + sport.getNomSport() + " avec un score total de " + sport.scoreTotal());
    }
}
