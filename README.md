# Abonnement Canal Plus

API de gestion des abonnements Canal Plus.

## Tutoriel

Après récupération du projet, la commande a executé depuis le dossier du projet est :

> mvn clean install

Et pour démarrer l'application :

> mvn spring-boot:run

## Problèmes rencontrés

N'ayant jamais utilisé le framework TestNG et n'ayant jamais mise en place une application Cucumber, 
l'application rencontre plusieurs problèmes au niveau de ces deux frameworks :

- **TestNG**
    - Je n'ai pas réussi à appeler un service sans qu'il me renvoit Null via l'annotation **@Autowired** que ça soit 
      dans **@TestBefore** ou **@TestAfter**, mais les appels aux services marchent 
      correctement lorsque les appels se font au niveau de **@Test**
      
    - Une façon de contourné le problème rencontré pour l'appel aux services aurait été de faire
    tout les appels dans **@Test**, mais ça n'aurait pas été propre donc j'ai préféré skip les tests
      avec **@Test(enabled = false)**.
      
- **Cucumber**
    - À l'image de TestNG, les appels aux services me renvoit Null, j'ai malgré tout écrit les 
      scénarios et les steps sans que les services marchent.
      
## Bonnes pratiques

Durant mon développement, plusieurs bonnes pratiques ont été mise en place :

- Principe du TDD malgré les erreurs rencontrés côté test au niveau de l'application.
- Commentaires au niveau du code afin que tout soit compréhensible.
- Respect des conventions en terme de commit git.

## Notes

- Le code (noms de variables, noms de class, noms de méthodes...) a été rédigé en français.
- 1er commit le 23 janvier 2021 à 19h31 // dernier commit le 26 janvier à 20h19.

### En vous remerciant à l'avance pour votre temps et votre attention
