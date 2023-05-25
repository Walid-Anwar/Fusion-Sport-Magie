package magie.main;

public class Arcane implements Magie {
    private String type;
    private int puissance;

    public Arcane() {
        this.type = "arcane";
        this.puissance = 1;
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
        return 3*this.puissance;
    }
}