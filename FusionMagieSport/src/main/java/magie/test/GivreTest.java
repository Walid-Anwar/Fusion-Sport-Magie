package magie.test;
import magie.main.Givre;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GivreTest {
    @Test
    void testDefaultConstructor() {
        Givre givre = new Givre();
        assertEquals("givre", givre.getType());
        assertEquals(1, givre.getPuissance());
    }

    @Test
    void testSettersAndGetters() {
        Givre givre = new Givre();
        givre.setType("feu");  // même si ce n'est pas logique pour la classe Givre, cela sert à tester le setter
        givre.setPuissance(5);
        assertEquals("feu", givre.getType()); // le getter doit renvoyer la même valeur qui a été fixée
        assertEquals(5, givre.getPuissance()); // idem ici
    }

    @Test
    void testDegatSort() {
        Givre givre = new Givre();
        givre.setPuissance(5);
        assertEquals(10, givre.degatSort());  // pour une puissance de 5, le dommage doit être 2 * 5 = 10
    }
}
