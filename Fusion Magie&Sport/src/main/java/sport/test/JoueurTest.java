package sport.test;

import sport.main.Joueur;
import sport.main.Sport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {
    @Test
    void testConstructorWithParam() {
        Sport sport = new Sport("Football");
        Joueur joueur = new Joueur("Jean", sport);
        assertEquals("Jean", joueur.getNom());
        assertEquals(sport, joueur.getSport());
    }

    @Test
    void testSettersAndGetters() {
        Sport sport = new Sport("Basketball");
        Joueur joueur = new Joueur("Pierre", sport);
        Sport newSport = new Sport("Tennis");
        joueur.setNom("Paul");
        joueur.setSport(newSport);
        assertEquals("Paul", joueur.getNom());
        assertEquals(newSport, joueur.getSport());
    }

    @Test
    void testPratiquerSport() {
        Sport sport = new Sport("Football");
        sport.setTechnicite(7);
        sport.setEnthousiasme(8);
        Joueur joueur = new Joueur("Jean", sport);
        // ici, nous vérifions simplement que cette méthode peut être appelée sans erreur
        // car elle ne retourne rien et son effet est un affichage à l'écran
        joueur.pratiquerSport();
    }
}
