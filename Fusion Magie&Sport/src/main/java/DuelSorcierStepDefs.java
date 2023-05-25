import fusionArene.Arene;
import magie.main.*;
import sport.main.Sport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class DuelSorcierStepDefs {

    private Arene arene = Arene.getInstance();
    private Sorcier sorcier1;
    private Sorcier sorcier2;

    private String degatsSorcier1;
    private String degatsSorcier2;

    @Given("Il y a un sorcier nommé {string} de race {string} qui pratique le sport {string} et utilise la magie {string} avec une puissance de {int}")
    public void givenSorcier(String nom, String race, String nomSport, String typeMagie, Integer puissance) {
        Sport sport = new Sport(nomSport);

        Magie magie;
        switch (typeMagie) {
            case "feu":
                magie = new Feu();
                break;
            case "givre":
                magie = new Givre();
                break;
            case "arcane":
                magie = new Arcane();
                break;
            default:
                throw new IllegalArgumentException("Type de magie inconnu: " + typeMagie);
        }
        magie.setPuissance(puissance);

        Sorcier sorcier = new Sorcier(nom, sport, race, magie);

        if (sorcier1 == null) {
            sorcier1 = sorcier;
            arene.setSorcier1(sorcier1);
        } else {
            sorcier2 = sorcier;
            arene.setSorcier2(sorcier2);
            arene.initialize(sorcier1, sorcier2);
        }
    }
    @When("Les sorciers entrent dans l'arène")
    public void les_sorciers_entrent_dans_l_arène() {
        // Les sorciers entrent dans l'arène
    }

    @When("Le sorcier {string} attaque le sorcier {string}")
    public void whenSorcierAttaque(String nomAttaquant, String nomVictime) {
        if (arene.getSorcier1().getNom().equals(nomAttaquant)) {
            arene.attaquerSorcier2();
        } else if (arene.getSorcier2().getNom().equals(nomAttaquant)) {
            arene.attaquerSorcier1();
        } else {
            throw new IllegalArgumentException("Sorcier attaquant non trouvé: " + nomAttaquant);
        }
    }

    @Then("Le sorcier {string} doit avoir moins de {int} points de vie")
    public void thenVieDiminuee(String nomSorcier, Integer pointsDeVie) {
        if (sorcier1.getNom().equals(nomSorcier)) {
            assertTrue(arene.getVie1() < pointsDeVie);
        } else if (sorcier2.getNom().equals(nomSorcier)) {
            assertTrue(arene.getVie2() < pointsDeVie);
        } else {
            throw new IllegalArgumentException("Sorcier non trouvé: " + nomSorcier);
        }
    }
    @When("Le sorcier {string} attaque le sorcier {string} jusqu'à la victoire")
    public void whenSorcierAttaqueJusquALaVictoire(String nomAttaquant, String nomVictime) {
        while (!arene.victoire().startsWith("Le sorcier " + nomAttaquant)) {
            if (arene.getSorcier1().getNom().equals(nomAttaquant)) {
                arene.attaquerSorcier2();
            } else if (arene.getSorcier2().getNom().equals(nomAttaquant)) {
                arene.attaquerSorcier1();
            } else {
                throw new IllegalArgumentException("Sorcier attaquant non trouvé: " + nomAttaquant);
            }
        }
    }

    @Then("Le sorcier {string} doit remporter le duel")
    public void thenSorcierRemporteDuel(String nomSorcier) {
        String resultatVictoire = arene.victoire();
        assertEquals("Le sorcier " + nomSorcier + " a remporté le duel.", resultatVictoire);
    }

    @Given("Il y a un sorcier nommé {string} de race {string} qui utilise la magie {string} avec une puissance de {int}")
    public void givenSorcier(String nom, String race, String typeMagie, Integer puissance) {
        Magie magie;
        switch (typeMagie) {
            case "feu":
                magie = new Feu();
                break;
            case "givre":
                magie = new Givre();
                break;
            default:
                throw new IllegalArgumentException("Type de magie inconnu: " + typeMagie);
        }
        magie.setPuissance(puissance);

        Sorcier sorcier = new Sorcier(nom, null, race, magie);

        if (sorcier1 == null) {
            sorcier1 = sorcier;
        } else {
            sorcier2 = sorcier;
        }
    }

    @When("Le sorcier {string} utilise son sort magique")
    public void whenSorcierUtiliseSort(String nomSorcier) {
        if (sorcier1.getNom().equals(nomSorcier)) {
            degatsSorcier1 = sorcier1.getMagie().getType();
        } else if (sorcier2.getNom().equals(nomSorcier)) {
            degatsSorcier2 = sorcier2.getMagie().getType();
        } else {
            throw new IllegalArgumentException("Sorcier non trouvé: " + nomSorcier);
        }
    }

    @Then("Le sorcier {string} doit infliger des dégâts de {string}")
    public void thenDegatsInfliges(String nomSorcier, String typeDegats) {
        if (sorcier1.getNom().equals(nomSorcier)) {
            assertEquals(typeDegats, sorcier1.getMagie().getType());
        } else if (sorcier2.getNom().equals(nomSorcier)) {
            assertEquals(typeDegats, sorcier2.getMagie().getType());
        } else {
            throw new IllegalArgumentException("Sorcier non trouvé: " + nomSorcier);
        }
    }

    @Given("Il y a un sorcier nommé {string} de race {string} avec une puissance de {int}")
    public void givenSorcier(String nom, String race, int puissance) {
        Sport sport = new Sport("Magie");
        Magie magie = new Feu(); // Par défaut, on utilise la magie "Feu"
        magie.setPuissance(puissance);

        Sorcier sorcier = new Sorcier(nom, sport, race, magie);

        if (sorcier1 == null) {
            sorcier1 = sorcier;
            arene.setSorcier1(sorcier1);
        } else {
            sorcier2 = sorcier;
            arene.setSorcier2(sorcier2);
        }
    }

    @Then("Les sorciers ont la puissance configurée correctement")
    public void thenPuissanceConfigureeCorrectement() {
        assertEquals(5, sorcier1.getMagie().getPuissance());
        assertEquals(8, sorcier2.getMagie().getPuissance());
    }

    @Then("Les sorciers ont la race correctement instanciée")
    public void thenRaceCorrectementInstancee() {
        assertEquals("elfe", sorcier1.getRace());
        assertEquals("humain", sorcier2.getRace());
    }




}
