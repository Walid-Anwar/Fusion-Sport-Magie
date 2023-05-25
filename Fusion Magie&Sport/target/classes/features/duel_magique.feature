Feature: Duel entre deux sorciers

  Scenario: Sorcier 1 attaque Sorcier 2
    Given Il y a un sorcier nommé "John" de race "elfe" qui pratique le sport "duel" et utilise la magie "givre" avec une puissance de 10
    And Il y a un sorcier nommé "Doe" de race "troll" qui pratique le sport "duel" et utilise la magie "givre" avec une puissance de 10
    When Les sorciers entrent dans l'arène
    And Le sorcier "John" attaque le sorcier "Doe"
    Then Le sorcier "Doe" doit avoir moins de 150 points de vie


  Scenario: Sorcier 2 gagne en attaquant Sorcier 1
    Given Il y a un sorcier nommé "John" de race "troll" qui pratique le sport "duel" et utilise la magie "feu" avec une puissance de 10
    And Il y a un sorcier nommé "Doe" de race "troll" qui pratique le sport "duel" et utilise la magie "givre" avec une puissance de 10
    When Les sorciers entrent dans l'arène
    And Le sorcier "John" attaque le sorcier "Doe" jusqu'à la victoire
    Then Le sorcier "John" doit remporter le duel

