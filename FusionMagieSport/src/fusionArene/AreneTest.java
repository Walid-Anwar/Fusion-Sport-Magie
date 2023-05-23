package fusionArene;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import magie.main.*;
import sport.main.*;

import static org.junit.jupiter.api.Assertions.*;

public class AreneTest {
    private Arene arene;
    private Sorcier sorcier1, sorcier2;

    @BeforeEach
    public void setUp() {
        Sport sport = new Sport("football");
        Givre givre = new Givre();
        givre.setPuissance(10);

        sorcier1 = new Sorcier("John", sport, "elfe", givre);
        sorcier2 = new Sorcier("Doe", sport, "troll", givre);

        arene = Arene.getInstance();
        arene.initialize(sorcier1, sorcier2);
    }

    @Test
    public void testGetInstance() {
        Arene instance = Arene.getInstance();
        assertNotNull(instance);
        assertEquals(arene, instance);
    }

    @Test
    public void testInitialize() {
        assertEquals(sorcier1, arene.getSorcier1());
        assertEquals(150, arene.getVie1());
        assertEquals(sorcier2, arene.getSorcier2());
        assertEquals(150, arene.getVie2());
    }

    @Test
    public void testSetSorcier1() {
        Feu feu = new Feu();
        feu.setPuissance(20);
        Sorcier newSorcier = new Sorcier("Mike", new Sport("tennis"), "humain", feu);
        arene.setSorcier1(newSorcier);
        assertEquals(newSorcier, arene.getSorcier1());
    }

    @Test
    public void testSetVie1() {
        arene.setVie1(120);
        assertEquals(120, arene.getVie1());
    }

    @Test
    public void testVictoire() {
        // Cas où la partie est toujours en cours
        String result = arene.victoire();
        assertEquals("La partie est toujours en cours", result);

        // Cas où le sorcier 1 perd
        arene.setVie1(-10);
        result = arene.victoire();
        assertEquals("Le sorcier Doe a remporté le duel.", result);

        // Cas où le sorcier 2 perd
        arene.initialize(sorcier1, sorcier2); // réinitialiser la vie des sorciers
        arene.setVie2(-10);
        result = arene.victoire();
        assertEquals("Le sorcier John a remporté le duel.", result);
    }
    @Test
    public void testAttaquerSorcier1() {
        // Avant l'attaque, la vie du sorcier 1 devrait être de 150.
        assertEquals(150, arene.getVie1());

        // Effectuer l'attaque.
        arene.attaquerSorcier1();

        // Après l'attaque, la vie du sorcier 1 devrait être diminuée.
        // Note : Ce nombre dépend du calcul effectué dans sorcier2.sortRaciale().
        int vieAttendue = 150 - sorcier2.sortRaciale();
        assertEquals(vieAttendue, arene.getVie1());
    }

    @Test
    public void testAttaquerSorcier2() {
        // Avant l'attaque, la vie du sorcier 2 devrait être de 150.
        assertEquals(150, arene.getVie2());

        // Effectuer l'attaque.
        arene.attaquerSorcier2();

        // Après l'attaque, la vie du sorcier 2 devrait être diminuée.
        // Note : Ce nombre dépend du calcul effectué dans sorcier1.sortRaciale().
        int vieAttendue = 150 - sorcier1.sortRaciale();
        assertEquals(vieAttendue, arene.getVie2());
    }

}
