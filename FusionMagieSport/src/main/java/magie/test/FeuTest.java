package magie.test;
import magie.main.Feu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeuTest {
    @Test
    void testDefaultConstructor() {
        Feu feu = new Feu();
        assertEquals("feu", feu.getType());
        assertEquals(0, feu.getPuissance());
    }

    @Test
    void testSettersAndGetters() {
        Feu feu = new Feu();
        feu.setType("arcane");  // même si ce n'est pas logique pour la classe Feu, cela sert à tester le setter
        feu.setPuissance(5);
        assertEquals("arcane", feu.getType()); // le getter doit renvoyer la même valeur qui a été fixée
        assertEquals(5, feu.getPuissance()); // idem ici
    }

    @Test
    void testDegatSort() {
        Feu feu = new Feu();
        feu.setPuissance(5);
        assertEquals(20, feu.degatSort());  // pour une puissance de 5, le dommage doit être 4 * 5 = 20
    }
}
