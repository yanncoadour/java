
# Cours 23 : Collections synchronisées et non synchronisées en Java

## Objectifs :
- Comprendre la différence entre les collections synchronisées et non synchronisées en Java
- Apprendre à utiliser les collections synchronisées pour garantir la sécurité des threads
- Découvrir les classes synchronisées fournies par Java et comment les utiliser

---

## 1. Qu'est-ce qu'une collection non synchronisée ?
Une **collection non synchronisée** permet à plusieurs threads d'accéder simultanément à une collection, mais sans protection contre les conflits de données. Cela signifie que si plusieurs threads modifient ou accèdent à une collection en même temps, des comportements inattendus peuvent se produire (comme des incohérences dans les données).

### Exemple d'une collection non synchronisée (ArrayList) :
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Alice");
        liste.add("Bob");
        liste.add("Charlie");

        // Parcourir et afficher la liste
        for (String nom : liste) {
            System.out.println(nom);
        }
    }
}
```

Dans cet exemple, `ArrayList` n'est pas synchronisée. Si plusieurs threads accèdent à cette liste en même temps, des problèmes de cohérence peuvent survenir.

---

## 2. Collections synchronisées
Une **collection synchronisée** garantit que les opérations sur la collection sont sécurisées dans un environnement multithread. Cela signifie qu'un seul thread peut accéder ou modifier la collection à un moment donné, évitant ainsi les conflits.

En Java, vous pouvez obtenir des versions synchronisées des collections en utilisant la classe `Collections`.

### Exemple de synchronisation d'une `ArrayList` :
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> liste = Collections.synchronizedList(new ArrayList<>());
        liste.add("Alice");
        liste.add("Bob");
        liste.add("Charlie");

        // Synchronisation lors de l'accès à la liste
        synchronized (liste) {
            for (String nom : liste) {
                System.out.println(nom);
            }
        }
    }
}
```

Dans cet exemple, la méthode `Collections.synchronizedList()` est utilisée pour obtenir une version synchronisée de `ArrayList`. L'utilisation de `synchronized` garantit qu'un seul thread accède à la liste à la fois.

---

## 3. Classes synchronisées fournies par Java
Java fournit plusieurs classes synchronisées prêtes à l'emploi qui peuvent être utilisées dans des environnements multithread.

### Principales classes synchronisées :
1. **Vector** : Une version synchronisée de `ArrayList`.
2. **Hashtable** : Une version synchronisée de `HashMap`.
3. **Stack** : Une structure de pile synchronisée.

### Exemple de la classe `Vector` :
```java
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Alice");
        vector.add("Bob");
        vector.add("Charlie");

        // Parcourir et afficher le vector
        for (String nom : vector) {
            System.out.println(nom);
        }
    }
}
```

Dans cet exemple, la classe `Vector` est utilisée pour stocker des éléments de manière synchronisée. Chaque méthode de `Vector` est sécurisée pour les threads, ce qui évite les problèmes liés à la concurrence.

---

## 4. Collections synchronisées avec `ConcurrentHashMap`
La classe **`ConcurrentHashMap`** est une alternative à `Hashtable` qui est plus efficace dans les environnements multithread. Contrairement à `Hashtable`, elle permet à plusieurs threads de lire et écrire simultanément dans la map, tout en garantissant la sécurité des threads.

### Exemple d'utilisation de `ConcurrentHashMap` :
```java
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        // Afficher les éléments de la map
        for (String nom : map.keySet()) {
            System.out.println(nom + " : " + map.get(nom));
        }
    }
}
```

`ConcurrentHashMap` est plus performante que `Hashtable` car elle utilise un mécanisme de verrouillage plus granulaire, ce qui permet des lectures et des écritures simultanées.

---

## 5. Comparaison entre collections synchronisées et non synchronisées
| **Caractéristique**       | **Collections non synchronisées**           | **Collections synchronisées**                 |
|---------------------------|--------------------------------------------|----------------------------------------------|
| Sécurité des threads       | Non sécurisées en environnement multithread| Sécurisées en environnement multithread      |
| Performance                | Meilleure performance en mode single-thread| Moins performantes en environnement multithread |
| Concurrence                | Accès simultané non protégé                | Accès protégé avec des mécanismes de synchronisation |

---

## 6. Quand utiliser les collections synchronisées ?
- **Environnement multithread** : Si votre application utilise plusieurs threads qui accèdent ou modifient une collection simultanément, vous devez utiliser des collections synchronisées pour éviter les problèmes de cohérence des données.
- **ConcurrentHashMap** : Si vous avez besoin d'une collection hautement concurrente pour des opérations fréquentes de lecture et d'écriture, préférez `ConcurrentHashMap` à `Hashtable`.

---

## Exercices Pratiques

### Exercice 1 : Utilisation d'une collection synchronisée
1. Créez une `ArrayList` et synchronisez-la à l'aide de `Collections.synchronizedList()`.
2. Ajoutez plusieurs éléments à la liste et parcourez-la en utilisant un bloc `synchronized`.

### Exercice 2 : Comparaison entre `HashMap` et `ConcurrentHashMap`
1. Créez une `HashMap` et une `ConcurrentHashMap`.
2. Utilisez plusieurs threads pour lire et écrire dans chaque map et comparez les performances.

---

Ce cours vous a présenté les collections synchronisées et non synchronisées en Java, ainsi que leurs différences. Vous avez découvert comment synchroniser des collections existantes et les classes synchronisées fournies par Java. Les exercices vous permettront de pratiquer ces concepts dans des environnements multithread.
