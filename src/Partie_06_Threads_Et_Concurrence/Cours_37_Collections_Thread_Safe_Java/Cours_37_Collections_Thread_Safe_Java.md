
# Cours 37 : Collections Thread-safe en Java (ConcurrentHashMap, CopyOnWriteArrayList)

## Objectifs :
- Comprendre le concept de collections thread-safe en Java
- Découvrir les classes `ConcurrentHashMap` et `CopyOnWriteArrayList` qui permettent de gérer des collections dans des environnements multithreadés
- Apprendre à utiliser ces collections pour éviter les conditions de course et autres problèmes de synchronisation

---

## 1. Qu'est-ce qu'une collection thread-safe ?
Une **collection thread-safe** permet à plusieurs threads d'accéder et de modifier une collection sans provoquer de conflits de données ou de comportements imprévisibles. En Java, les collections standard (comme `ArrayList` ou `HashMap`) ne sont pas thread-safe, ce qui signifie qu'elles peuvent entraîner des erreurs si elles sont utilisées simultanément par plusieurs threads.

Les collections thread-safe sont conçues pour garantir la sécurité des threads en utilisant des mécanismes de synchronisation ou des copies immuables des données pour gérer les accès concurrents.

---

## 2. `ConcurrentHashMap`
La classe **`ConcurrentHashMap`** fait partie du package `java.util.concurrent` et est une version thread-safe de `HashMap`. Contrairement à `HashMap`, `ConcurrentHashMap` permet des lectures simultanées sans verrou global, tout en s'assurant que les écritures sont correctement synchronisées.

### Exemple d'utilisation de `ConcurrentHashMap` :
```java
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        System.out.println("Valeur pour Alice : " + map.get("Alice"));

        // Ajouter un élément de manière concurrente
        Thread t1 = new Thread(() -> map.put("David", 40));
        Thread t2 = new Thread(() -> map.put("Eve", 28));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valeur pour David : " + map.get("David"));
    }
}
```

Dans cet exemple, `ConcurrentHashMap` permet à plusieurs threads d'ajouter des éléments simultanément sans provoquer de conflits de données. Les lectures et écritures sont gérées de manière sûre et performante.

### Avantages de `ConcurrentHashMap` :
- **Accès concurrent sécurisé** : Permet à plusieurs threads de lire et écrire dans la map sans avoir besoin de synchroniser manuellement les accès.
- **Performance** : Utilise un verrouillage segmenté pour minimiser les blocages tout en assurant la cohérence des données.

---

## 3. `CopyOnWriteArrayList`
La classe **`CopyOnWriteArrayList`** est une version thread-safe de `ArrayList`. Elle fonctionne en créant une copie de la liste chaque fois qu'une modification (ajout, suppression, etc.) est effectuée. Cela permet aux threads de lire la liste sans avoir à se soucier des modifications concurrentes.

### Exemple d'utilisation de `CopyOnWriteArrayList` :
```java
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> liste = new CopyOnWriteArrayList<>();

        liste.add("Alice");
        liste.add("Bob");
        liste.add("Charlie");

        System.out.println("Liste : " + liste);

        // Modification concurrente
        Thread t1 = new Thread(() -> liste.add("David"));
        Thread t2 = new Thread(() -> liste.add("Eve"));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Liste après ajout : " + liste);
    }
}
```

Dans cet exemple, `CopyOnWriteArrayList` permet à plusieurs threads d'ajouter des éléments simultanément sans provoquer d'incohérences. Les opérations de lecture sont rapides, car elles ne nécessitent pas de verrouillage, mais les modifications entraînent la création d'une nouvelle copie de la liste.

### Avantages de `CopyOnWriteArrayList` :
- **Lecture rapide** : Les lectures sont très rapides et ne nécessitent pas de verrouillage.
- **Sécurité des threads** : Les modifications sont gérées en créant une nouvelle copie de la liste, ce qui évite les conflits entre les lectures et les écritures.
- **Usage recommandé** : Cette collection est idéale dans des environnements où les lectures sont fréquentes et les modifications sont rares.

---

## 4. Comparaison entre `ConcurrentHashMap` et `CopyOnWriteArrayList`

| **Caractéristique**           | **ConcurrentHashMap**                      | **CopyOnWriteArrayList**                   |
|-------------------------------|--------------------------------------------|--------------------------------------------|
| Synchronisation                | Lecture et écriture simultanées sécurisées | Lecture rapide, modification crée une copie |
| Performance                    | Optimisé pour les accès concurrents        | Optimisé pour les lectures fréquentes       |
| Usage                          | Lorsque des lectures et écritures simultanées sont fréquentes | Lorsque les lectures sont nombreuses et les écritures rares |

---

## 5. Bonnes pratiques avec les collections thread-safe
1. **Choisir la collection adaptée** : Utilisez `ConcurrentHashMap` lorsque vous avez besoin d'accéder fréquemment en lecture et en écriture à une map, et `CopyOnWriteArrayList` lorsque les lectures sont fréquentes et les modifications rares.
2. **Minimiser les modifications** : Évitez d'utiliser `CopyOnWriteArrayList` si les modifications sont fréquentes, car cela peut entraîner des problèmes de performance.
3. **Utiliser les collections thread-safe dans les environnements multithread** : Les collections standards comme `ArrayList` ou `HashMap` ne sont pas sécurisées pour les threads et peuvent provoquer des comportements imprévisibles si elles sont utilisées dans des environnements multithreadés sans synchronisation.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `ConcurrentHashMap`
1. Créez un programme qui utilise `ConcurrentHashMap` pour stocker et mettre à jour les scores des joueurs dans un jeu multijoueur.
2. Utilisez plusieurs threads pour ajouter et modifier les scores simultanément.

### Exercice 2 : Utilisation de `CopyOnWriteArrayList`
1. Créez un programme qui utilise `CopyOnWriteArrayList` pour gérer une liste de participants à un événement.
2. Simulez l'ajout de participants par plusieurs threads et affichez la liste finale.

---

Ce cours vous a introduit aux collections thread-safe en Java, avec un focus sur `ConcurrentHashMap` et `CopyOnWriteArrayList`. Vous avez appris à utiliser ces collections pour gérer des environnements multithreadés de manière sûre et performante, tout en évitant les problèmes de synchronisation. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
