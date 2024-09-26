
# Cours 36 : Verrous en Java (synchronized, Lock)

## Objectifs :
- Comprendre l'utilisation des verrous pour synchroniser l'accès aux ressources partagées dans un programme multithreadé
- Apprendre à utiliser le mot-clé `synchronized` pour la synchronisation simple
- Découvrir l'interface `Lock` pour une gestion plus fine de la synchronisation

---

## 1. Qu'est-ce qu'un verrou ?
Un **verrou** est un mécanisme qui permet de contrôler l'accès à une ressource partagée entre plusieurs threads. En Java, il existe deux manières principales de verrouiller des sections de code pour éviter les accès concurrents :
1. **Le mot-clé `synchronized`** : Fournit une synchronisation simple au niveau des méthodes ou des blocs de code.
2. **L'interface `Lock`** : Offre un contrôle plus flexible et granulaire sur les verrous.

---

## 2. Utilisation du mot-clé `synchronized`
Le mot-clé **`synchronized`** est la méthode la plus simple pour synchroniser l'accès à des méthodes ou des blocs de code critiques. Lorsqu'une méthode ou un bloc est marqué comme `synchronized`, un seul thread peut y accéder à un moment donné.

### Exemple d'utilisation de `synchronized` :
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

Dans cet exemple, la méthode `retirer()` est synchronisée. Cela signifie qu'un seul thread peut exécuter cette méthode à la fois, garantissant que le solde est mis à jour correctement.

### Synchronisation d'un bloc de code :
Plutôt que de synchroniser une méthode entière, vous pouvez synchroniser uniquement une partie du code avec un bloc `synchronized`.

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

### Synchronisation statique :
Pour synchroniser une méthode ou un bloc statique, le verrou est appliqué sur la classe elle-même.

```java
class Banque {
    private static int totalComptes = 0;

    public static synchronized void creerCompte() {
        totalComptes++;
        System.out.println("Compte créé. Total : " + totalComptes);
    }
}
```

---

## 3. Utilisation de l'interface `Lock`
L'interface **`Lock`** (fournie par le package `java.util.concurrent.locks`) offre un contrôle plus flexible sur les verrous que le mot-clé `synchronized`. Elle permet, par exemple, de vérifier si un verrou est disponible, d'interrompre un thread qui attend un verrou, ou de mettre en place des verrous à durée limitée.

### Exemple d'utilisation de `Lock` :
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

Dans cet exemple, le verrou est acquis au début de la méthode avec `lock()` et libéré à la fin avec `unlock()`. Cela garantit qu'un seul thread accède à la méthode `retirer()` à la fois.

### Méthodes principales de l'interface `Lock` :
- **`lock()`** : Acquiert le verrou.
- **`unlock()`** : Libère le verrou.
- **`tryLock()`** : Tente d'acquérir le verrou sans attendre.
- **`lockInterruptibly()`** : Acquiert le verrou tout en permettant d'interrompre le thread en attente.

---

## 4. Différences entre `synchronized` et `Lock`

| **Caractéristique**           | **synchronized**                        | **Lock**                                 |
|-------------------------------|-----------------------------------------|------------------------------------------|
| Simplicité                    | Facile à utiliser, syntaxe simple.       | Plus complexe, mais plus flexible.       |
| Contrôle                      | Verrouillage automatique et libération. | Libération manuelle du verrou nécessaire.|
| Fonctionnalités avancées       | Moins de flexibilité.                   | Permet des fonctionnalités avancées comme `tryLock()`. |
| Gestion des interruptions      | Non, les threads ne peuvent pas être interrompus pendant l'attente. | Oui, avec `lockInterruptibly()`. |

L'interface `Lock` est plus flexible que le mot-clé `synchronized`, mais elle est également plus complexe à utiliser, car elle nécessite une gestion manuelle des verrous.

---

## 5. Bonnes pratiques pour l'utilisation des verrous
1. **Utilisez `synchronized` pour la simplicité** : Si vous avez simplement besoin de protéger une méthode ou un bloc de code, `synchronized` est suffisant et facile à utiliser.
2. **Utilisez `Lock` pour plus de flexibilité** : Lorsque vous avez besoin de fonctionnalités avancées (comme `tryLock()` ou la gestion des interruptions), préférez l'interface `Lock`.
3. **Toujours libérer les verrous** : Avec `Lock`, il est important de toujours libérer les verrous dans un bloc `finally` pour garantir qu'ils sont toujours relâchés, même en cas d'exception.
4. **Évitez les blocages mutuels (deadlocks)** : Faites attention aux situations où plusieurs threads peuvent se bloquer mutuellement en essayant d'acquérir plusieurs verrous.

---

## Exercices Pratiques

### Exercice 1 : Synchronisation avec `synchronized`
1. Créez une classe `CompteBancaire` avec des méthodes synchronisées pour déposer et retirer de l'argent.
2. Utilisez plusieurs threads pour tester l'accès concurrent à ces méthodes.

### Exercice 2 : Synchronisation avec `Lock`
1. Modifiez la classe précédente pour utiliser l'interface `Lock` au lieu de `synchronized`.
2. Ajoutez un mécanisme pour interrompre un thread qui attend un verrou.

---

Ce cours vous a introduit à l'utilisation des verrous en Java avec le mot-clé `synchronized` et l'interface `Lock`. Vous avez appris à synchroniser l'accès aux ressources partagées et à utiliser des mécanismes avancés de synchronisation pour éviter les conditions de course dans vos programmes multithreadés.
