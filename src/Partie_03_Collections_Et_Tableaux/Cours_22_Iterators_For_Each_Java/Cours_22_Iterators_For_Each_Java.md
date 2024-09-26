
# Cours 22 : Iterators et boucles (for-each) en Java

## Objectifs :
- Comprendre le concept des itérateurs en Java
- Apprendre à utiliser les itérateurs pour parcourir des collections
- Découvrir la boucle `for-each` pour simplifier l'itération sur les collections

---

## 1. Qu'est-ce qu'un itérateur en Java ?
Un **itérateur** est un objet qui permet de parcourir une collection d'éléments un par un, sans avoir besoin de connaître la structure sous-jacente de la collection. Les itérateurs sont particulièrement utiles lorsque vous devez parcourir des collections comme `ArrayList`, `HashSet`, ou `LinkedList`.

### Principales méthodes d'un itérateur :
- `hasNext()` : Renvoie `true` s'il reste des éléments à parcourir dans la collection.
- `next()` : Renvoie l'élément suivant dans la collection.
- `remove()` : Supprime l'élément courant de la collection.

### Exemple d'utilisation d'un itérateur :
```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Alice");
        liste.add("Bob");
        liste.add("Charlie");

        // Création d'un itérateur
        Iterator<String> iterateur = liste.iterator();

        // Parcours de la collection à l'aide de l'itérateur
        while (iterateur.hasNext()) {
            String nom = iterateur.next();
            System.out.println(nom);
        }
    }
}
```

Dans cet exemple, un itérateur est utilisé pour parcourir une `ArrayList`. La méthode `hasNext()` vérifie s'il reste des éléments à parcourir, et `next()` récupère chaque élément.

---

## 2. Utilisation de `remove()` avec un itérateur
L'itérateur permet également de supprimer des éléments tout en les parcourant. Il est recommandé d'utiliser la méthode `remove()` de l'itérateur pour éviter les erreurs de modification concurrente de la collection.

### Exemple avec suppression d'éléments :
```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Alice");
        liste.add("Bob");
        liste.add("Charlie");

        // Création de l'itérateur
        Iterator<String> iterateur = liste.iterator();

        // Suppression d'un élément tout en parcourant la liste
        while (iterateur.hasNext()) {
            String nom = iterateur.next();
            if (nom.equals("Bob")) {
                iterateur.remove();
            }
        }

        // Affichage de la liste après suppression
        System.out.println(liste);
    }
}
```

Dans cet exemple, l'itérateur parcourt la liste et supprime l'élément "Bob" à l'aide de `remove()`.

---

## 3. La boucle `for-each`
La boucle **`for-each`** est une structure simplifiée pour parcourir des collections. Elle est particulièrement utile pour les collections qui implémentent l'interface `Iterable`, comme les tableaux, les listes, les ensembles, etc. Contrairement à l'itérateur, la boucle `for-each` ne permet pas de supprimer des éléments directement.

### Syntaxe de la boucle `for-each` :
```java
for (type element : collection) {
    // Utilisation de l'élément
}
```

### Exemple d'utilisation de la boucle `for-each` :
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Alice");
        liste.add("Bob");
        liste.add("Charlie");

        // Utilisation de la boucle for-each
        for (String nom : liste) {
            System.out.println(nom);
        }
    }
}
```

Dans cet exemple, la boucle `for-each` est utilisée pour parcourir une `ArrayList` et afficher chaque élément.

---

## 4. Comparaison entre `Iterator` et `for-each`
| **Caractéristique**       | **Iterator**                                 | **For-each**                              |
|---------------------------|----------------------------------------------|-------------------------------------------|
| Parcours                  | Permet de parcourir tous les éléments        | Parcours simplifié des éléments           |
| Suppression d'éléments     | Oui, avec `remove()`                         | Non, suppression non permise              |
| Simplicité                | Nécessite des appels à `hasNext()` et `next()`| Plus simple, pas besoin de gestion d'itérateur |
| Collections compatibles    | Toutes les collections qui implémentent `Iterable` | Toutes les collections qui implémentent `Iterable` |

L'itérateur est plus flexible, surtout pour des opérations complexes comme la suppression d'éléments pendant l'itération. La boucle `for-each` est plus simple et lisible pour un parcours rapide.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de l'itérateur
1. Créez une `ArrayList` contenant des prénoms.
2. Parcourez la liste avec un itérateur et affichez chaque prénom.

### Exercice 2 : Suppression avec un itérateur
1. Créez une `ArrayList` contenant des prénoms, y compris des doublons.
2. Parcourez la liste avec un itérateur et supprimez tous les prénoms qui apparaissent en double.

### Exercice 3 : Boucle `for-each`
1. Créez une `HashSet` contenant des noms de villes.
2. Utilisez une boucle `for-each` pour afficher chaque ville.

---

Ce cours vous a présenté les itérateurs et la boucle `for-each` en Java, deux manières de parcourir des collections. Vous avez découvert les avantages et les inconvénients de chaque méthode. Les exercices vous permettront de pratiquer ces concepts et de mieux comprendre comment les utiliser dans vos programmes.
