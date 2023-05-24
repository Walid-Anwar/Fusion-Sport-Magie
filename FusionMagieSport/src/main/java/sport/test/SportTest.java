package sport.test;
import sport.main.Sport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SportTest {
    @Test
    void testDefaultConstructor() {
        Sport sport = new Sport();
        assertEquals("nomSport", sport.getNomSport());
        assertEquals(0, sport.getTechnicite());
        assertEquals(0, sport.getEnthousiasme());
    }

    @Test
    void testConstructorWithParam() {
        Sport sport = new Sport("Football");
        assertEquals("Football", sport.getNomSport());
        assertEquals(0, sport.getTechnicite());
        assertEquals(0, sport.getEnthousiasme());
    }

    @Test
    void testSettersAndGetters() {
        Sport sport = new Sport();
        sport.setNomSport("Basketball");
        sport.setTechnicite(7);
        sport.setEnthousiasme(8);
        assertEquals("Basketball", sport.getNomSport());
        assertEquals(7, sport.getTechnicite());
        assertEquals(8, sport.getEnthousiasme());
    }

    @Test
    void testScoreTotal() {
        Sport sport = new Sport();
        sport.setTechnicite(7);
        sport.setEnthousiasme(8);
        assertEquals(8, sport.scoreTotal());  // la moyenne arrondie à l'entier supérieur de 7 et 8 est 8
    }

    @Test
    void testScoreTotalWithDifferentValues() {
        Sport sport = new Sport();
        sport.setTechnicite(7);
        sport.setEnthousiasme(9);
        assertEquals(8, sport.scoreTotal());  // la moyenne arrondie à l'entier supérieur de 7 et 9 est 8
    }
}
