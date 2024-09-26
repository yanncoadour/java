
# Cours 21 : Collections en Java (ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap)

## Objectifs :
- Comprendre le fonctionnement des principales collections en Java
- Apprendre à utiliser les classes `ArrayList`, `LinkedList`, `HashSet`, `TreeSet`, `HashMap`, et `TreeMap`
- Découvrir les différences entre ces structures de données et leurs cas d'utilisation

---

## 1. La classe `ArrayList`
La classe **`ArrayList`** est une implémentation de la liste qui permet de stocker des éléments dans un tableau redimensionnable. Elle est idéale lorsque vous avez besoin d'accéder fréquemment aux éléments par leur index, car l'accès aux éléments est rapide.

### Caractéristiques :
- Les éléments sont stockés de manière séquentielle.
- Accès rapide aux éléments par index.
- L'ajout et la suppression d'éléments sont coûteux si effectués au milieu de la liste.

### Exemple d'utilisation :
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Alice");
        liste.add("Bob");
        liste.add("Charlie");

        // Affichage de la liste
        for (String nom : liste) {
            System.out.println(nom);
        }
    }
}
```

---

## 2. La classe `LinkedList`
La classe **`LinkedList`** est une implémentation d'une liste chaînée en Java. Contrairement à `ArrayList`, elle est plus efficace pour les opérations d'insertion et de suppression.

### Caractéristiques :
- Bonne performance pour les ajouts et suppressions d'éléments, en particulier au début ou au milieu de la liste.
- Moins efficace que `ArrayList` pour accéder aux éléments par index.

### Exemple d'utilisation :
```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> liste = new LinkedList<>();
        liste.add("Alice");
        liste.add("Bob");
        liste.addFirst("Charlie");

        // Affichage de la liste
        for (String nom : liste) {
            System.out.println(nom);
        }
    }
}
```

---

## 3. La classe `HashSet`
La classe **`HashSet`** implémente l'interface `Set` et stocke les éléments sans ordre particulier. Elle ne permet pas de doublons.

### Caractéristiques :
- Pas de doublons.
- Les éléments ne sont pas ordonnés.
- Les opérations comme `add()`, `remove()`, et `contains()` sont très rapides.

### Exemple d'utilisation :
```java
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> ensemble = new HashSet<>();
        ensemble.add("Alice");
        ensemble.add("Bob");
        ensemble.add("Alice");  // Ce doublon ne sera pas ajouté

        // Affichage de l'ensemble
        for (String nom : ensemble) {
            System.out.println(nom);
        }
    }
}
```

---

## 4. La classe `TreeSet`
La classe **`TreeSet`** est une autre implémentation de l'interface `Set`. Contrairement à `HashSet`, elle stocke les éléments dans un ordre trié.

### Caractéristiques :
- Pas de doublons.
- Les éléments sont automatiquement triés.
- Plus lent que `HashSet` pour les opérations d'ajout et de suppression.

### Exemple d'utilisation :
```java
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> ensemble = new TreeSet<>();
        ensemble.add("Charlie");
        ensemble.add("Alice");
        ensemble.add("Bob");

        // Affichage des éléments triés
        for (String nom : ensemble) {
            System.out.println(nom);
        }
    }
}
```

---

## 5. La classe `HashMap`
La classe **`HashMap`** est une implémentation de la structure de données map. Elle associe des clés uniques à des valeurs et permet de rechercher rapidement des valeurs par clé.

### Caractéristiques :
- Les éléments ne sont pas ordonnés.
- Accès rapide aux valeurs par clé.
- Les clés sont uniques, mais les valeurs peuvent être dupliquées.

### Exemple d'utilisation :
```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        // Affichage de la map
        for (String nom : map.keySet()) {
            System.out.println(nom + " : " + map.get(nom));
        }
    }
}
```

---

## 6. La classe `TreeMap`
La classe **`TreeMap`** est une autre implémentation de la structure `Map` qui trie les clés dans l'ordre naturel ou par un comparateur.

### Caractéristiques :
- Trie les clés dans l'ordre naturel (ou par un comparateur personnalisé).
- Plus lente que `HashMap` pour l'ajout et la suppression d'éléments.

### Exemple d'utilisation :
```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Charlie", 35);
        map.put("Alice", 30);
        map.put("Bob", 25);

        // Affichage des clés triées
        for (String nom : map.keySet()) {
            System.out.println(nom + " : " + map.get(nom));
        }
    }
}
```

---

## 7. Comparaison des collections

| **Classe**   | **Ordre des éléments** | **Doublons** | **Performance d'accès** | **Utilisation**                           |
|--------------|------------------------|--------------|-------------------------|-------------------------------------------|
| `ArrayList`  | Ordonné par index       | Autorisé     | Accès rapide par index   | Utilisé pour des accès fréquents par index. |
| `LinkedList` | Ordonné par insertion   | Autorisé     | Accès plus lent par index | Idéal pour les ajouts et suppressions fréquents. |
| `HashSet`    | Non ordonné             | Pas de doublons | Rapide pour `add()`, `remove()` | Utilisé lorsque l'ordre n'est pas important et que vous voulez éviter les doublons. |
| `TreeSet`    | Trié                   | Pas de doublons | Plus lent que `HashSet`  | Utilisé lorsque l'ordre des éléments est important. |
| `HashMap`    | Non ordonné             | Clés uniques  | Accès rapide par clé     | Utilisé pour associer des clés uniques à des valeurs. |
| `TreeMap`    | Trié par clés           | Clés uniques  | Plus lent que `HashMap`  | Utilisé lorsque l'ordre des clés est important. |

---

## Exercices Pratiques

### Exercice 1 : Utilisation d'`ArrayList`
1. Créez une liste d'amis avec `ArrayList` et ajoutez plusieurs noms.
2. Parcourez la liste pour afficher chaque nom.

### Exercice 2 : Utilisation de `HashSet`
1. Créez un ensemble de villes avec `HashSet` et ajoutez plusieurs villes, y compris des doublons.
2. Affichez toutes les villes pour vérifier que les doublons ne sont pas ajoutés.

### Exercice 3 : Utilisation de `HashMap`
1. Créez une `HashMap` pour stocker les noms d'employés associés à leurs numéros d'identification.
2. Affichez chaque employé et son numéro d'identification.

---

Ce cours vous a introduit aux principales collections en Java : `ArrayList`, `LinkedList`, `HashSet`, `TreeSet`, `HashMap`, et `TreeMap`. Vous avez découvert leurs caractéristiques et leurs cas d'utilisation. Les exercices vous permettront de pratiquer ces concepts pour bien comprendre leur fonctionnement.
