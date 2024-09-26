
# Cours 35 : Synchronisation des threads en Java

## Objectifs :
- Comprendre pourquoi la synchronisation des threads est importante en Java
- Apprendre à utiliser le mot-clé `synchronized` pour éviter les conflits d'accès aux ressources partagées
- Découvrir d'autres mécanismes de synchronisation, comme les blocs synchronisés et les verrous

---

## 1. Pourquoi synchroniser les threads ?
Lorsque plusieurs threads accèdent simultanément à des ressources partagées (comme des variables ou des objets), il existe un risque de **conditions de course** (race conditions). Cela signifie que les threads peuvent interférer entre eux, provoquant des comportements inattendus dans le programme.

### Exemple de problème sans synchronisation :
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

public class Main {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire();
        Thread t1 = new Thread(() -> compte.retirer(500));
        Thread t2 = new Thread(() -> compte.retirer(500));

        t1.start();
        t2.start();
    }
}
```

Dans cet exemple, deux threads tentent de retirer de l'argent simultanément d'un compte bancaire. Sans synchronisation, il peut arriver que les deux threads accèdent à la méthode `retirer()` en même temps, entraînant un retrait incorrect.

---

## 2. Utilisation du mot-clé `synchronized`
Le mot-clé **`synchronized`** garantit que seuls les threads peuvent accéder à une méthode ou un bloc de code à un moment donné. Cela permet de protéger les ressources partagées contre les accès concurrents.

### Exemple de méthode synchronisée :
```java
class CompteBancaire {
    private int solde = 1000;

    public synchronized void retirer(int montant) {
        if (solde >= montant) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " euros. Solde restant : " + solde);
        } else {
            System.out.println("Solde insuffisant.");
        }
    }
}
```

Dans cet exemple, la méthode `retirer()` est synchronisée. Cela signifie qu'un seul thread peut accéder à cette méthode à la fois, garantissant que les retraits sont effectués correctement.

### Méthodes synchronisées :
- **Méthode synchronisée** : La méthode entière est protégée, empêchant d'autres threads d'y accéder tant qu'un thread l'utilise.
- **Bloc synchronisé** : Seule une partie du code est protégée, ce qui permet de limiter la portée de la synchronisation.

---

## 3. Synchronisation avec un bloc `synchronized`
Plutôt que de synchroniser une méthode entière, vous pouvez synchroniser uniquement une partie du code avec un **bloc `synchronized`**. Cela peut améliorer les performances en permettant à d'autres threads d'exécuter d'autres parties de la méthode.

### Exemple de bloc `synchronized` :
```java
class CompteBancaire {
    private int solde = 1000;

    public void retirer(int montant) {
        synchronized (this) {
            if (solde >= montant) {
                solde -= montant;
                System.out.println("Retrait de " + montant + " euros. Solde restant : " + solde);
            } else {
                System.out.println("Solde insuffisant.");
            }
        }
    }
}
```

Dans cet exemple, seul le bloc `synchronized` est protégé, ce qui permet à d'autres threads d'accéder à d'autres méthodes ou parties de l'objet.

---

## 4. Synchronisation statique
Il est également possible de synchroniser des méthodes ou des blocs statiques. Dans ce cas, le verrou est appliqué au niveau de la classe plutôt qu'au niveau de l'objet.

### Exemple de méthode statique synchronisée :
```java
class Banque {
    private static int totalComptes = 0;

    public static synchronized void creerCompte() {
        totalComptes++;
        System.out.println("Compte créé. Total : " + totalComptes);
    }
}
```

Dans cet exemple, la méthode statique `creerCompte()` est synchronisée, garantissant que le compteur `totalComptes` est mis à jour de manière sûre.

---

## 5. Utilisation des verrous (Locks)
Java propose également une API de synchronisation plus flexible avec l'interface **`Lock`** (disponible dans le package `java.util.concurrent.locks`). Les verrous permettent un contrôle plus précis de l'accès aux ressources partagées et peuvent être utilisés à la place du mot-clé `synchronized`.

### Exemple d'utilisation d'un verrou :
```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CompteBancaire {
    private int solde = 1000;
    private Lock verrou = new ReentrantLock();

    public void retirer(int montant) {
        verrou.lock();  // Acquérir le verrou
        try {
            if (solde >= montant) {
                solde -= montant;
                System.out.println("Retrait de " + montant + " euros. Solde restant : " + solde);
            } else {
                System.out.println("Solde insuffisant.");
            }
        } finally {
            verrou.unlock();  // Libérer le verrou
        }
    }
}
```

Dans cet exemple, le verrou garantit que seule une section du code est protégée, tout en offrant plus de contrôle que le mot-clé `synchronized`.

---

## 6. Bonnes pratiques pour la synchronisation des threads

1. **Limiter la portée de la synchronisation** : Synchronisez uniquement les sections critiques de code pour éviter les blocages inutiles et améliorer les performances.
2. **Utiliser les verrous quand c'est nécessaire** : Les verrous offrent plus de flexibilité que le mot-clé `synchronized`, mais sont également plus complexes à gérer. Utilisez-les lorsque vous avez besoin d'un contrôle plus fin sur la synchronisation.
3. **Éviter les blocages mutuels (deadlocks)** : Assurez-vous que les threads ne se bloquent pas mutuellement en essayant d'acquérir des verrous dans des ordres différents. Les blocages mutuels peuvent provoquer un arrêt complet de l'application.

---

## Exercices Pratiques

### Exercice 1 : Synchronisation de méthodes
1. Créez une classe `CompteBancaire` avec une méthode `deposer()` et une méthode `retirer()`.
2. Synchronisez ces méthodes pour éviter les conflits d'accès lors de l'utilisation simultanée par plusieurs threads.

### Exercice 2 : Utilisation de blocs synchronisés
1. Créez une classe qui simule une file d'attente pour un guichet bancaire.
2. Synchronisez uniquement la partie du code qui retire un client de la file d'attente.

---

Ce cours vous a introduit aux concepts de synchronisation des threads en Java. Vous avez appris à utiliser le mot-clé `synchronized`, les blocs synchronisés, et les verrous pour protéger les ressources partagées dans les programmes multithreadés. Les exercices vous permettront de pratiquer ces concepts et de mieux comprendre la synchronisation des threads.
