import fusionArene.Arene;
import magie.main.Sorcier;
import sport.main.Sport;
import magie.main.Arcane;

public class main {
    public static void main(String[] args) {
        Arene arene = Arene.getInstance();

        // Créer les sorciers
        Sorcier sorcier1 = new Sorcier("John", new Sport(), "elfe", new Arcane());
        Sorcier sorcier2 = new Sorcier("Doe", new Sport(), "troll", new Arcane());

        // Initialiser l'arène
        arene.initialize(sorcier1, sorcier2);

        // Afficher les points de vie initiaux
        System.out.println("Points de vie initiaux :");
        System.out.println("Sorcier 1 : " + arene.getVie1());
        System.out.println("Sorcier 2 : " + arene.getVie2());

        // Attaquer
        arene.attaquerSorcier1();

        // Afficher les points de vie après l'attaque
        System.out.println("Points de vie après l'attaque :");
        System.out.println("Sorcier 1 : " + arene.getVie1());
        System.out.println("Sorcier 2 : " + arene.getVie2());
    }
}
