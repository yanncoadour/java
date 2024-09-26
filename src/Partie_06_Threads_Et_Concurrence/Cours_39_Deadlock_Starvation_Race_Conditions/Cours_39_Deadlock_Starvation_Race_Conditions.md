
# Cours 39 : Deadlock, Starvation, et Race Conditions en Java

## Objectifs :
- Comprendre les concepts de deadlock, starvation et race conditions en programmation multithreadée
- Apprendre à identifier et éviter ces problèmes de synchronisation
- Découvrir les bonnes pratiques pour garantir une exécution correcte des programmes multithreadés

---

## 1. Qu'est-ce qu'un deadlock ?
Un **deadlock** (ou interblocage) se produit lorsque deux ou plusieurs threads se bloquent mutuellement en essayant d'acquérir des ressources détenues par l'autre. Aucun des threads ne peut progresser, ce qui provoque un blocage complet du programme.

### Exemple de deadlock :
```java
class Ressource {
    public synchronized void methodeA(Ressource autre) {
        System.out.println(Thread.currentThread().getName() + " a exécuté methodeA");
        autre.methodeB();  // Appelle une méthode de l'autre ressource
    }

    public synchronized void methodeB() {
        System.out.println(Thread.currentThread().getName() + " a exécuté methodeB");
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Ressource ressource1 = new Ressource();
        Ressource ressource2 = new Ressource();

        Thread t1 = new Thread(() -> ressource1.methodeA(ressource2));
        Thread t2 = new Thread(() -> ressource2.methodeA(ressource1));

        t1.start();
        t2.start();
    }
}
```

Dans cet exemple, les deux threads essayent d'acquérir des verrous sur les deux ressources, ce qui entraîne un deadlock. Le thread 1 détient le verrou de `ressource1` et attend le verrou de `ressource2`, tandis que le thread 2 détient le verrou de `ressource2` et attend le verrou de `ressource1`. Ils restent bloqués.

### Comment éviter les deadlocks ?
- **Ordre des verrous** : Assurez-vous que tous les threads acquièrent les verrous dans le même ordre pour éviter les interblocages.
- **Timeouts** : Utilisez des timeouts avec les verrous pour libérer les ressources après un certain délai.
- **Utilisation de `tryLock()`** : L'interface `Lock` propose la méthode `tryLock()` qui permet d'essayer d'acquérir un verrou sans attendre indéfiniment.

---

## 2. Qu'est-ce que la starvation ?
La **starvation** survient lorsque certains threads n'obtiennent jamais l'accès aux ressources nécessaires pour s'exécuter, parce qu'un autre thread monopolise ces ressources. Cela peut se produire si les priorités des threads ne sont pas gérées correctement ou si certaines ressources sont continuellement utilisées par d'autres threads.

### Exemple de starvation :
```java
class RessourcePartagee {
    public synchronized void utiliser() {
        System.out.println(Thread.currentThread().getName() + " utilise la ressource");
        try {
            Thread.sleep(1000);  // Simuler l'utilisation de la ressource
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class StarvationExample {
    public static void main(String[] args) {
        RessourcePartagee ressource = new RessourcePartagee();

        Thread threadPrioritaire = new Thread(() -> {
            while (true) {
                ressource.utiliser();
            }
        }, "Thread Prioritaire");
        threadPrioritaire.setPriority(Thread.MAX_PRIORITY);

        Thread threadStarve = new Thread(() -> {
            while (true) {
                ressource.utiliser();
            }
        }, "Thread Starve");
        threadStarve.setPriority(Thread.MIN_PRIORITY);

        threadPrioritaire.start();
        threadStarve.start();
    }
}
```

Dans cet exemple, le thread avec la priorité maximale monopolise constamment l'accès à la ressource, empêchant le thread avec la priorité minimale d'y accéder.

### Comment éviter la starvation ?
- **Gestion des priorités** : Évitez de donner des priorités trop élevées à certains threads qui peuvent empêcher d'autres threads d'accéder aux ressources.
- **Équité** : Utilisez des mécanismes comme les sémaphores équitables ou les verrous équitables (`ReentrantLock(true)`) qui garantissent que les threads sont servis de manière équitable.

---

## 3. Qu'est-ce qu'une race condition ?
Une **race condition** se produit lorsque plusieurs threads accèdent à des ressources partagées de manière non synchronisée, provoquant des comportements imprévisibles. Si deux threads modifient la même donnée simultanément sans synchronisation, le résultat peut être incorrect ou incohérent.

### Exemple de race condition :
```java
class CompteBancaire {
    private int solde = 1000;

    public void retirer(int montant) {
        if (solde >= montant) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " euros. Solde restant : " + solde);
        } else {
            System.out.println("Solde insuffisant.");
        }
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire();

        Thread t1 = new Thread(() -> compte.retirer(500));
        Thread t2 = new Thread(() -> compte.retirer(500));

        t1.start();
        t2.start();
    }
}
```

Dans cet exemple, les deux threads tentent de retirer de l'argent simultanément, ce qui peut provoquer des résultats inattendus. Par exemple, le solde peut devenir négatif même si chaque retrait est censé vérifier que le solde est suffisant.

### Comment éviter les race conditions ?
- **Synchronisation** : Utilisez le mot-clé `synchronized` ou l'interface `Lock` pour protéger les sections critiques du code.
- **Collections thread-safe** : Utilisez des collections thread-safe comme `ConcurrentHashMap` ou `CopyOnWriteArrayList` pour gérer les accès concurrents aux collections.

---

## 4. Comparaison entre deadlock, starvation et race conditions

| **Concept**         | **Description**                                           | **Solution**                                   |
|---------------------|-----------------------------------------------------------|------------------------------------------------|
| **Deadlock**         | Deux threads se bloquent mutuellement en attendant des ressources détenues par l'autre. | Ordre des verrous, `tryLock()`                 |
| **Starvation**       | Un thread n'obtient jamais l'accès aux ressources car un autre thread les monopolise. | Gestion des priorités, équité (`fair locks`)    |
| **Race condition**   | Accès non synchronisé à des ressources partagées, entraînant des résultats imprévisibles. | Synchronisation, collections thread-safe       |

---

## 5. Bonnes pratiques pour éviter ces problèmes
1. **Utiliser des mécanismes de synchronisation** : Utilisez `synchronized`, `Lock`, ou des collections thread-safe pour éviter les race conditions.
2. **Suivre un ordre strict pour les verrous** : Lors de l'acquisition de plusieurs verrous, assurez-vous que tous les threads respectent le même ordre pour éviter les deadlocks.
3. **Éviter de monopoliser les ressources** : Répartissez l'accès aux ressources de manière équitable entre les threads pour éviter la starvation.
4. **Utiliser des outils de détection de concurrence** : Des outils comme **Thread Dump Analyzer** ou **Java VisualVM** peuvent aider à identifier les deadlocks ou les conditions de concurrence dans les programmes multithreadés.

---

## Exercices Pratiques

### Exercice 1 : Détection de deadlock
1. Créez deux threads qui tentent d'accéder à deux ressources partagées.
2. Provoquez un deadlock et analysez son comportement.

### Exercice 2 : Éviter la starvation
1. Créez un programme qui simule un environnement où un thread monopolise l'accès à une ressource.
2. Implémentez une solution pour répartir l'accès aux ressources de manière équitable.

---

Ce cours vous a introduit aux concepts de deadlock, starvation, et race conditions en Java. Vous avez appris à identifier ces problèmes de concurrence et à utiliser des mécanismes de synchronisation pour les éviter dans vos programmes multithreadés. Les exercices vous permettront de mieux comprendre ces concepts et de les appliquer dans des situations concrètes.
