package magie.test;
import magie.main.*;
import sport.main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SorcierTest {
    @Test
    void testConstructorWithParams() {
        Sport sport = new Sport("Football");
        Magie magie = new Feu();
        Sorcier sorcier = new Sorcier("Jean", sport, "elfe", magie);
        assertEquals("Jean", sorcier.getNom());
        assertEquals(sport, sorcier.getSport());
        assertEquals("elfe", sorcier.getRace());
        assertEquals(magie, sorcier.getMagie());
    }

    @Test
    void testSettersAndGetters() {
        Sport sport = new Sport("Basketball");
        Magie magie = new Arcane();
        Sorcier sorcier = new Sorcier("Pierre", sport, "troll", magie);
        Sport newSport = new Sport("Tennis");
        Magie newMagie = new Givre();
        sorcier.setNom("Paul");
        sorcier.setSport(newSport);
        sorcier.setRace("humain");
        sorcier.setMagie(newMagie);
        assertEquals("Paul", sorcier.getNom());
        assertEquals(newSport, sorcier.getSport());
        assertEquals("humain", sorcier.getRace());
        assertEquals(newMagie, sorcier.getMagie());
    }

    @Test
    void testSortRaciale() {
        Sport sport = new Sport("Football");
        sport.setTechnicite(7);
        sport.setEnthousiasme(8);
        Magie magie = new Feu();
        magie.setPuissance(5);
        Sorcier sorcier = new Sorcier("Jean", sport, "elfe", magie);
        assertEquals(3 * sport.scoreTotal() * magie.degatSort(), sorcier.sortRaciale());
    }

    @Test
    void testPratiquerSport() {
        Sport sport = new Sport("Football");
        sport.setTechnicite(7);
        sport.setEnthousiasme(8);
        Magie magie = new Feu();
        magie.setPuissance(5);
        Sorcier sorcier = new Sorcier("Jean", sport, "elfe", magie);
        sorcier.pratiquerSport();
    }
}
