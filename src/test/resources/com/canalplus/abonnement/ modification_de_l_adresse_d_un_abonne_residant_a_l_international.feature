Feature: Modification de l'adresse d'un abonné résidant à l’international


  Scenario: Modification de l'adresse d'un abonné résidant à l’international
    Given un abonné avec plusieurs contrats et une adresse principale à l’international
    When le conseiller modifie l'adresse de l'abonné
    Then l’adresse est modifiée uniquement sur le premier contrat de l’abonné
    And un mouvement de modification d'adresse est créé avec la nouvelle adresse
