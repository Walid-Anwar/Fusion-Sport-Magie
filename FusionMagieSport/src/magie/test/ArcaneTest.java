package magie.test;

import magie.main.Arcane;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArcaneTest {
    @Test
    void testDefaultConstructor() {
        Arcane arcane = new Arcane();
        assertEquals("arcane", arcane.getType());
        assertEquals(0, arcane.getPuissance());
    }

    @Test
    void testSettersAndGetters() {
        Arcane arcane = new Arcane();
        arcane.setType("feu");  // même si ce n'est pas logique pour la classe Arcane, cela sert à tester le setter
        arcane.setPuissance(5);
        assertEquals("feu", arcane.getType()); // le getter doit renvoyer la même valeur qui a été fixée
        assertEquals(5, arcane.getPuissance()); // idem ici
    }

    @Test
    void testDegatSort() {
        Arcane arcane = new Arcane();
        arcane.setPuissance(5);
        assertEquals(15, arcane.degatSort());  // pour une puissance de 5, le dommage doit être 3 * 5
    }
}