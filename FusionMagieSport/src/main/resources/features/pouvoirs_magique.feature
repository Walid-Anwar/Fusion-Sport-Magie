
Feature: Pouvoirs magiques des sorciers

  Scenario: Sorciers utilisant différents sorts
    Given Il y a un sorcier nommé "John" de race "elfe" qui utilise la magie "feu" avec une puissance de 5
    And Il y a un sorcier nommé "Doe" de race "humain" qui utilise la magie "givre" avec une puissance de 8
    When Le sorcier "John" utilise son sort magique
    And Le sorcier "Doe" utilise son sort magique
    Then Le sorcier "John" doit infliger des dégâts de "feu"
    And Le sorcier "Doe" doit infliger des dégâts de "givre"

  Scenario: Configuration des sorciers
    Given Il y a un sorcier nommé "John" de race "elfe" avec une puissance de 5
    And Il y a un sorcier nommé "Doe" de race "humain" avec une puissance de 8
    Then Les sorciers ont la puissance configurée correctement
    And Les sorciers ont la race correctement instanciée
