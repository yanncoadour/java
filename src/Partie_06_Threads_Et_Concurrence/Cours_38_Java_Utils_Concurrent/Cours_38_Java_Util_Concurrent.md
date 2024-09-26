
# Cours 38 : API `java.util.concurrent` en Java (Executors, Future, Callable)

## Objectifs :
- Comprendre l'API `java.util.concurrent` pour gérer des tâches asynchrones et des threads en Java
- Apprendre à utiliser les classes `ExecutorService`, `Future`, et `Callable` pour soumettre et gérer des tâches concurrentes
- Découvrir comment utiliser les pools de threads pour optimiser l'exécution des tâches

---

## 1. Présentation de l'API `java.util.concurrent`
L'API **`java.util.concurrent`** fournit un ensemble d'outils pour gérer la concurrence en Java, facilitant l'exécution de tâches asynchrones et la gestion des threads. Elle introduit des concepts avancés comme les **pools de threads**, les **tâches asynchrones**, et les **verrous** qui simplifient le développement de programmes multithreadés.

---

## 2. L'interface `ExecutorService`
La classe **`ExecutorService`** est utilisée pour gérer un pool de threads et soumettre des tâches qui peuvent être exécutées de manière asynchrone. Plutôt que de créer manuellement des threads, vous pouvez soumettre des tâches à un **pool de threads** pour un traitement plus efficace et organisé.

### Exemple de création d'un pool de threads avec `ExecutorService` :
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);  // Pool de 3 threads

        // Soumettre des tâches à exécuter
        for (int i = 1; i <= 5; i++) {
            executor.submit(() -> {
                System.out.println("Tâche exécutée par : " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();  // Arrêter l'executor après l'exécution des tâches
    }
}
```

Dans cet exemple, un pool de 3 threads est créé avec `Executors.newFixedThreadPool()`. Les tâches soumises sont exécutées par les threads du pool, et l'executor est arrêté après l'exécution des tâches.

### Méthodes importantes de `ExecutorService` :
- **`submit(Runnable task)`** : Soumet une tâche pour exécution.
- **`shutdown()`** : Arrête l'executor une fois que toutes les tâches soumises sont terminées.
- **`shutdownNow()`** : Arrête immédiatement l'executor en tentant d'interrompre les tâches en cours.

---

## 3. Interface `Callable` et `Future`
L'interface **`Callable`** est similaire à `Runnable`, mais elle permet de retourner un résultat après l'exécution d'une tâche et de lever une exception. **`Future`** est utilisé pour représenter le résultat d'une tâche asynchrone qui peut ne pas être immédiatement disponible.

### Exemple avec `Callable` et `Future` :
```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> callableTask = () -> {
            System.out.println("Calcul en cours...");
            Thread.sleep(2000);  // Simuler un calcul long
            return 42;
        };

        Future<Integer> future = executor.submit(callableTask);

        try {
            System.out.println("Résultat du calcul : " + future.get());  // Obtenir le résultat
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
```

Dans cet exemple, une tâche `Callable` est soumise à un `ExecutorService`, et son résultat est récupéré via l'objet `Future`. La méthode `get()` de `Future` permet d'attendre la fin de l'exécution de la tâche et de récupérer son résultat.

### Méthodes importantes de `Future` :
- **`get()`** : Bloque jusqu'à ce que le résultat de la tâche soit disponible.
- **`cancel(boolean mayInterruptIfRunning)`** : Annule la tâche si elle est en cours d'exécution.
- **`isDone()`** : Vérifie si la tâche est terminée.

---

## 4. Différence entre `Runnable` et `Callable`

| **Caractéristique**       | **Runnable**                          | **Callable**                           |
|---------------------------|---------------------------------------|----------------------------------------|
| Retourne une valeur        | Non                                   | Oui (via `Future`)                    |
| Peut lever une exception   | Non                                   | Oui                                   |
| Utilisation                | Tâches sans résultat                  | Tâches avec un résultat ou une exception |

---

## 5. Gestion des pools de threads avec `Executors`
La classe **`Executors`** propose plusieurs méthodes utilitaires pour créer des pools de threads adaptés à différents types de tâches :

- **`newFixedThreadPool(int n)`** : Crée un pool de threads avec un nombre fixe de threads.
- **`newCachedThreadPool()`** : Crée un pool de threads qui crée de nouveaux threads à la demande et les réutilise lorsqu'ils sont disponibles.
- **`newSingleThreadExecutor()`** : Crée un executor à thread unique qui exécute les tâches dans l'ordre.

### Exemple d'utilisation de `newCachedThreadPool()` :
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            executor.submit(() -> {
                System.out.println("Tâche exécutée par : " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
```

Dans cet exemple, le pool de threads créé avec `newCachedThreadPool()` peut créer de nouveaux threads selon les besoins et réutiliser les threads disponibles pour optimiser l'exécution.

---

## 6. Bonnes pratiques avec `ExecutorService`, `Callable`, et `Future`
1. **Utiliser les pools de threads** : Préférez l'utilisation de pools de threads avec `ExecutorService` plutôt que de créer manuellement des threads pour une gestion plus efficace des ressources.
2. **Toujours fermer l'Executor** : Assurez-vous d'appeler `shutdown()` ou `shutdownNow()` pour arrêter proprement les executors après l'exécution des tâches.
3. **Utiliser `Callable` pour les tâches avec résultat** : Lorsque vous avez besoin de retourner un résultat ou de gérer des exceptions, préférez `Callable` à `Runnable`.
4. **Gérer les exceptions avec `Future`** : Lors de l'utilisation de `Future`, gérez les exceptions pouvant être levées par les tâches avec un bloc `try-catch`.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `ExecutorService`
1. Créez un programme qui soumet plusieurs tâches à un pool de threads de taille fixe (par exemple, 3 threads).
2. Utilisez `shutdown()` pour arrêter proprement l'executor après l'exécution des tâches.

### Exercice 2 : Utilisation de `Callable` et `Future`
1. Créez une tâche `Callable` qui simule un calcul long et retourne un résultat.
2. Utilisez `Future` pour récupérer le résultat de la tâche une fois terminée.

---

Ce cours vous a introduit à l'API `java.util.concurrent`, en mettant l'accent sur l'utilisation de `ExecutorService`, `Callable`, et `Future`. Vous avez appris à soumettre et gérer des tâches asynchrones de manière efficace avec les pools de threads. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
