Feature: Modifier l'adresse d'un abonné
  Modification de l'adresse d'un abonné

  Scenario: Modification de l'adresse d'un abonné résidant en France
    Given un abonné avec plusieurs contrats et une adresse principale en France
    When le conseiller modifie l'adresse de l'abonné
    Then la nouvelle adresse de l’abonné est enregistrée sur l'ensemble des contrats de l'abonné
    And un mouvement de modification d'adresse est créé avec la nouvelle adresse