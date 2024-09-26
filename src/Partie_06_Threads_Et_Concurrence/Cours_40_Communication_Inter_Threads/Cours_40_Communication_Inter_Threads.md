
# Cours 40 : Communication inter-threads en Java (wait, notify, notifyAll)

## Objectifs :
- Comprendre comment les threads peuvent communiquer entre eux en Java
- Apprendre à utiliser les méthodes `wait()`, `notify()`, et `notifyAll()` pour coordonner l'exécution des threads
- Découvrir des exemples concrets d'attente conditionnelle entre threads

---

## 1. Qu'est-ce que la communication inter-threads ?
En programmation multithreadée, il est souvent nécessaire que les threads communiquent et se coordonnent pour partager des ressources ou attendre des conditions spécifiques. Java fournit trois méthodes pour faciliter cette communication :
- **`wait()`** : Suspend l'exécution d'un thread jusqu'à ce qu'une condition soit remplie.
- **`notify()`** : Réveille un thread qui attend une condition.
- **`notifyAll()`** : Réveille tous les threads qui attendent une condition.

Ces méthodes ne peuvent être appelées que dans un bloc synchronisé, car elles dépendent du verrou de l'objet utilisé pour la synchronisation.

---

## 2. La méthode `wait()`
La méthode **`wait()`** met un thread en attente jusqu'à ce qu'un autre thread l'avertisse qu'il peut reprendre l'exécution. Elle doit être appelée depuis un bloc synchronisé ou une méthode synchronisée.

### Exemple d'utilisation de `wait()` :
```java
class CompteBancaire {
    private int solde = 0;

    public synchronized void deposer(int montant) {
        solde += montant;
        System.out.println("Dépôt de " + montant + " euros. Solde actuel : " + solde);
        notify();  // Réveille le thread en attente
    }

    public synchronized void retirer(int montant) throws InterruptedException {
        while (solde < montant) {
            System.out.println("Solde insuffisant, en attente de dépôt...");
            wait();  // Attend qu'un dépôt soit effectué
        }
        solde -= montant;
        System.out.println("Retrait de " + montant + " euros. Solde restant : " + solde);
    }
}

public class Main {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire();

        Thread t1 = new Thread(() -> {
            try {
                compte.retirer(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> compte.deposer(1000));

        t1.start();
        t2.start();
    }
}
```

Dans cet exemple, le thread `t1` attend jusqu'à ce que le solde soit suffisant pour retirer de l'argent en utilisant `wait()`. Une fois que `t2` dépose de l'argent, il appelle `notify()`, ce qui permet à `t1` de reprendre l'exécution.

---

## 3. La méthode `notify()`
La méthode **`notify()`** réveille un thread en attente d'une condition liée à l'objet sur lequel le verrou est détenu. Elle ne réveille qu'un seul thread, même si plusieurs sont en attente.

### Exemple avec `notify()` :
Dans l'exemple précédent, la méthode `deposer()` utilise `notify()` pour réveiller un thread en attente après un dépôt.

---

## 4. La méthode `notifyAll()`
La méthode **`notifyAll()`** réveille tous les threads en attente sur l'objet verrouillé. Tous les threads réveillés devront ensuite concourir pour acquérir le verrou.

### Exemple avec `notifyAll()` :
```java
class CompteBancaire {
    private int solde = 0;

    public synchronized void deposer(int montant) {
        solde += montant;
        System.out.println("Dépôt de " + montant + " euros. Solde actuel : " + solde);
        notifyAll();  // Réveille tous les threads en attente
    }

    public synchronized void retirer(int montant) throws InterruptedException {
        while (solde < montant) {
            System.out.println(Thread.currentThread().getName() + " en attente de dépôt...");
            wait();
        }
        solde -= montant;
        System.out.println(Thread.currentThread().getName() + " a retiré " + montant + " euros.");
    }
}

public class Main {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire();

        Thread t1 = new Thread(() -> {
            try {
                compte.retirer(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            try {
                compte.retirer(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread 2");

        Thread t3 = new Thread(() -> compte.deposer(1000), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
```

Dans cet exemple, `notifyAll()` réveille tous les threads en attente lorsqu'un dépôt est effectué. Les threads se disputeront ensuite le verrou pour continuer leur exécution.

---

## 5. Différences entre `notify()` et `notifyAll()`

| **Méthode**          | **Description**                                              |
|----------------------|--------------------------------------------------------------|
| **`notify()`**        | Réveille un seul thread en attente.                          |
| **`notifyAll()`**     | Réveille tous les threads en attente, qui concourront pour obtenir le verrou. |

Utilisez **`notify()`** lorsque vous êtes certain qu'un seul thread en attente peut continuer l'exécution, et **`notifyAll()`** lorsque plusieurs threads doivent potentiellement être réveillés.

---

## 6. Bonnes pratiques pour la communication inter-threads
1. **Utiliser un bloc synchronisé** : Les méthodes `wait()`, `notify()`, et `notifyAll()` doivent être utilisées dans un bloc ou une méthode synchronisée pour garantir que les threads accèdent correctement à la ressource partagée.
2. **Toujours utiliser un `while` pour `wait()`** : Utilisez toujours une boucle `while` plutôt qu'un simple `if` pour vérifier les conditions d'attente. Cela permet de revérifier la condition après le réveil du thread.
3. **Minimiser l'utilisation de `notifyAll()`** : Préférez `notify()` lorsque possible pour éviter de réveiller inutilement des threads qui ne peuvent pas encore continuer leur exécution.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `wait()` et `notify()`
1. Créez un programme où un thread attend la production d'un élément par un autre thread avant de le consommer.
2. Utilisez `wait()` pour mettre le consommateur en attente et `notify()` pour le réveiller après la production de l'élément.

### Exercice 2 : Utilisation de `notifyAll()`
1. Simulez un système où plusieurs threads attendent une ressource partagée.
2. Utilisez `notifyAll()` pour réveiller tous les threads en attente lorsque la ressource devient disponible.

---

Ce cours vous a introduit aux méthodes `wait()`, `notify()`, et `notifyAll()` en Java, qui permettent aux threads de se coordonner et de communiquer efficacement. Vous avez appris à gérer les attentes conditionnelles et à coordonner l'exécution de plusieurs threads dans un environnement multithreadé. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
