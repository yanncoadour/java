
# Cours 24 : Algorithmes sur les collections en Java (tri, recherche, etc.)

## Objectifs :
- Comprendre les algorithmes de base appliqués aux collections en Java
- Apprendre à trier et rechercher des éléments dans les collections
- Utiliser les méthodes utilitaires de la classe `Collections`

---

## 1. Introduction
Java fournit un ensemble d'algorithmes utiles pour manipuler des collections via la classe **`Collections`**. Ces algorithmes incluent :
- Le **tri** des collections.
- La **recherche** d'éléments dans une collection.
- La **permutation** des éléments.
- L'**inversion** de l'ordre des éléments.

Ces algorithmes fonctionnent avec les collections qui implémentent l'interface `List`, comme `ArrayList` ou `LinkedList`.

---

## 2. Tri des collections

### Méthode `Collections.sort()`
La méthode **`sort()`** permet de trier une collection qui implémente l'interface `List`. Par défaut, elle trie les éléments selon l'ordre naturel (ordre croissant pour les nombres, ordre alphabétique pour les chaînes).

### Exemple de tri d'une liste :
```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Charlie");
        noms.add("Alice");
        noms.add("Bob");

        // Tri de la liste dans l'ordre alphabétique
        Collections.sort(noms);

        // Affichage de la liste triée
        for (String nom : noms) {
            System.out.println(nom);
        }
    }
}
```

### Tri personnalisé avec un `Comparator`
Si vous avez besoin d'un ordre spécifique, vous pouvez utiliser un **`Comparator`** pour définir l'ordre de tri.

### Exemple de tri personnalisé :
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Charlie");
        noms.add("Alice");
        noms.add("Bob");

        // Tri inverse (ordre décroissant)
        Collections.sort(noms, Comparator.reverseOrder());

        // Affichage de la liste triée dans l'ordre inverse
        for (String nom : noms) {
            System.out.println(nom);
        }
    }
}
```

---

## 3. Recherche dans les collections

### Méthode `Collections.binarySearch()`
La méthode **`binarySearch()`** permet de rechercher un élément dans une collection triée. Elle retourne l'index de l'élément recherché ou un nombre négatif si l'élément n'est pas trouvé. La collection doit être triée avant d'effectuer la recherche binaire.

### Exemple de recherche binaire :
```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nombres = new ArrayList<>();
        nombres.add(10);
        nombres.add(5);
        nombres.add(30);

        // Tri de la liste avant la recherche
        Collections.sort(nombres);

        // Recherche binaire de l'élément 10
        int index = Collections.binarySearch(nombres, 10);
        System.out.println("L'élément 10 est à l'index : " + index);
    }
}
```

---

## 4. Inverser l'ordre des éléments

### Méthode `Collections.reverse()`
La méthode **`reverse()`** permet d'inverser l'ordre des éléments dans une liste.

### Exemple d'inversion d'une liste :
```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Charlie");
        noms.add("Alice");
        noms.add("Bob");

        // Inversion de la liste
        Collections.reverse(noms);

        // Affichage de la liste inversée
        for (String nom : noms) {
            System.out.println(nom);
        }
    }
}
```

---

## 5. Permuter les éléments

### Méthode `Collections.shuffle()`
La méthode **`shuffle()`** permet de permuter les éléments d'une collection de manière aléatoire. Elle est souvent utilisée pour mélanger des éléments, comme dans le cas de cartes de jeu.

### Exemple de permutation d'une liste :
```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Charlie");
        noms.add("Alice");
        noms.add("Bob");

        // Mélange des éléments de la liste
        Collections.shuffle(noms);

        // Affichage de la liste mélangée
        for (String nom : noms) {
            System.out.println(nom);
        }
    }
}
```

---

## 6. Autres méthodes utiles de `Collections`
- **`max()` et `min()`** : Ces méthodes permettent de trouver les éléments maximum et minimum dans une collection.
- **`frequency()`** : Retourne la fréquence d'un élément dans une collection.
- **`swap()`** : Permet d'échanger deux éléments dans une liste.

### Exemple d'utilisation de `max()` et `min()` :
```java
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nombres = new ArrayList<>();
        nombres.add(10);
        nombres.add(5);
        nombres.add(30);

        // Trouver le maximum et le minimum
        int max = Collections.max(nombres);
        int min = Collections.min(nombres);

        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
    }
}
```

---

## Exercices Pratiques

### Exercice 1 : Tri d'une collection
1. Créez une liste de prénoms.
2. Triez la liste dans l'ordre alphabétique et affichez-la.

### Exercice 2 : Recherche binaire dans une collection
1. Créez une liste de nombres entiers.
2. Triez la liste et utilisez `Collections.binarySearch()` pour rechercher un nombre spécifique.

### Exercice 3 : Mélanger et inverser une collection
1. Créez une liste de villes.
2. Mélangez les éléments de la liste avec `shuffle()`.
3. Inversez l'ordre de la liste avec `reverse()` et affichez-la.

---

Ce cours vous a présenté les principaux algorithmes disponibles pour manipuler des collections en Java, notamment le tri, la recherche, l'inversion et la permutation. Les exercices vous permettront de pratiquer ces algorithmes et de comprendre comment les utiliser dans vos programmes.
