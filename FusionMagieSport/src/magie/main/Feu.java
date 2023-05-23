package magie.main;

public class Feu implements Magie {
    private String type;
    private int puissance;

    public Feu() {
        this.type = "feu";
        this.puissance = 0;
    }

    // getters et setters
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getPuissance() {
        return puissance;
    }
    @Override
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    @Override
    public int degatSort() {
        return 4*this.puissance;
    }
}
