
# Cours 34 : Gestion des threads en Java (Thread, Runnable)

## Objectifs :
- Comprendre le concept de multitâche en Java avec les threads
- Apprendre à créer et gérer des threads avec les interfaces `Thread` et `Runnable`
- Découvrir les bonnes pratiques pour le développement de programmes multithreadés

---

## 1. Qu'est-ce qu'un thread ?
Un **thread** est une unité d'exécution indépendante au sein d'un programme. En Java, chaque programme est exécuté par au moins un thread principal (main thread), mais vous pouvez créer plusieurs threads pour exécuter des tâches simultanément (multitâche).

L'utilisation des threads permet d'améliorer les performances des programmes, notamment pour les opérations qui peuvent être effectuées en parallèle (comme le traitement de données, les entrées/sorties, etc.).

---

## 2. Création d'un thread avec la classe `Thread`
La manière la plus simple de créer un thread en Java est d'étendre la classe **`Thread`** et de redéfinir la méthode `run()`.

### Exemple de création d'un thread avec `Thread` :
```java
public class MonThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("MonThread - Compteur : " + i);
            try {
                Thread.sleep(1000);  // Suspendre le thread pendant 1 seconde
            } catch (InterruptedException e) {
                System.out.println("Thread interrompu.");
            }
        }
    }

    public static void main(String[] args) {
        MonThread thread = new MonThread();
        thread.start();  // Démarrer le thread
    }
}
```

Dans cet exemple, la classe `MonThread` hérite de la classe `Thread` et redéfinit la méthode `run()`, qui contient le code à exécuter. Le thread est démarré avec la méthode `start()`.

### Méthodes importantes de la classe `Thread` :
- **`start()`** : Démarre l'exécution d'un thread.
- **`run()`** : Contient le code à exécuter par le thread.
- **`sleep(long millis)`** : Suspend le thread pendant une période spécifiée en millisecondes.
- **`join()`** : Attend la fin d'exécution d'un autre thread.

---

## 3. Création d'un thread avec l'interface `Runnable`
Une autre manière de créer un thread est d'implémenter l'interface **`Runnable`**. Cette méthode est souvent préférée car elle permet à la classe de conserver la possibilité d'hériter d'une autre classe.

### Exemple de création d'un thread avec `Runnable` :
```java
public class MonRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("MonRunnable - Compteur : " + i);
            try {
                Thread.sleep(1000);  // Suspendre le thread pendant 1 seconde
            } catch (InterruptedException e) {
                System.out.println("Thread interrompu.");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MonRunnable());
        thread.start();  // Démarrer le thread
    }
}
```

Dans cet exemple, la classe `MonRunnable` implémente l'interface `Runnable` et définit la méthode `run()`. Le thread est créé en passant une instance de `MonRunnable` au constructeur de la classe `Thread`.

---

## 4. Différences entre `Thread` et `Runnable`

| **Caractéristique**       | **Thread**                               | **Runnable**                             |
|---------------------------|------------------------------------------|------------------------------------------|
| Héritage                  | Nécessite d'étendre la classe `Thread`.  | Implémente `Runnable`, donc la classe peut hériter d'une autre classe. |
| Flexibilité               | Moins flexible car elle limite l'héritage. | Plus flexible, car permet l'héritage multiple. |

L'interface `Runnable` est souvent préférée, surtout lorsque vous devez hériter d'une autre classe ou pour une plus grande flexibilité.

---

## 5. Synchronisation des threads
Lorsqu'un programme comporte plusieurs threads qui partagent des ressources (comme des variables ou des objets), il est essentiel de synchroniser les accès à ces ressources pour éviter les conditions de course (race conditions).

### Exemple de synchronisation avec `synchronized` :
```java
class Banque {
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

public class MonRunnable implements Runnable {
    private Banque banque;

    public MonRunnable(Banque banque) {
        this.banque = banque;
    }

    @Override
    public void run() {
        banque.retirer(500);
    }

    public static void main(String[] args) {
        Banque banque = new Banque();
        Thread t1 = new Thread(new MonRunnable(banque));
        Thread t2 = new Thread(new MonRunnable(banque));
        t1.start();
        t2.start();
    }
}
```

Dans cet exemple, la méthode `retirer()` est marquée comme `synchronized` pour garantir que seuls les threads peuvent accéder à cette méthode un à un, évitant ainsi les conflits de ressources.

---

## 6. Gestion des interruptions
Les threads peuvent être interrompus à tout moment par un autre thread. En Java, vous pouvez utiliser la méthode `interrupt()` pour signaler à un thread qu'il doit s'arrêter.

### Exemple de gestion des interruptions :
```java
public class MonRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrompu !");
                return;
            }
            System.out.println("Compteur : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrompu pendant le sommeil.");
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MonRunnable());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();  // Interrompre le thread après 2 secondes
    }
}
```

Dans cet exemple, le thread vérifie s'il a été interrompu à l'aide de `isInterrupted()` et peut s'arrêter proprement en conséquence.

---

## Exercices Pratiques

### Exercice 1 : Création et gestion de threads
1. Créez une classe qui implémente `Runnable` et affiche un compteur de 1 à 10.
2. Démarrez deux threads qui exécutent ce compteur en parallèle.

### Exercice 2 : Synchronisation des threads
1. Créez une classe `CompteBancaire` avec une méthode `deposer()` et `retirer()`.
2. Utilisez la synchronisation pour garantir que les méthodes ne sont pas appelées simultanément par plusieurs threads.

---

Ce cours vous a introduit à la gestion des threads en Java avec les classes `Thread` et `Runnable`. Vous avez appris à créer des threads, à les synchroniser et à les interrompre. Les exercices vous permettront de mettre en pratique ces concepts et de mieux comprendre la programmation multithread en Java.
