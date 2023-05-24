package sport.main;

public class Sport {
    private String nomSport;
    private int technicite;
    private int enthousiasme;

    public Sport() {
        this.nomSport = "nomSport";
        this.technicite = 1;
        this.enthousiasme = 1;
    }

    public Sport(String nomSport) {
        this.nomSport = nomSport;
        this.technicite = 1;
        this.enthousiasme = 1;
    }

    // Getters
    public String getNomSport() {
        return this.nomSport;
    }

    public int getTechnicite() {
        return this.technicite;
    }

    public int getEnthousiasme() {
        return this.enthousiasme;
    }

    // Setters
    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    public void setTechnicite(int technicite) {
        this.technicite = technicite;
    }

    public void setEnthousiasme(int enthousiasme) {
        this.enthousiasme = enthousiasme;
    }

    //Retourne la partie sup de la moyenne entre l'enthousiasme et la technique
    public int scoreTotal() {
        int technique = this.getTechnicite();
        int enthousiasme = this.getEnthousiasme();
        int moyenne = (int)Math.ceil((technique+enthousiasme)*0.5);
        return moyenne;
    }
}
