
# Cours 45 : Programmation fonctionnelle avec `map`, `filter`, et `reduce` en Java

## Objectifs :
- Comprendre le concept de programmation fonctionnelle en Java
- Apprendre à utiliser les méthodes `map()`, `filter()`, et `reduce()` pour traiter des collections de manière déclarative
- Découvrir comment simplifier le code en utilisant ces fonctions dans l'API Stream

---

## 1. Qu'est-ce que la programmation fonctionnelle ?
La **programmation fonctionnelle** est un paradigme de programmation qui traite les opérations comme des fonctions mathématiques pures. Elle se concentre sur **l'immutabilité** et **l'absence d'effets de bord**, permettant d'écrire du code plus concis, lisible, et prévisible.

En Java, la programmation fonctionnelle est largement supportée via l'**API Stream**, introduite avec Java 8. Les méthodes **`map()`**, **`filter()`**, et **`reduce()`** sont au cœur de ce style de programmation et permettent de manipuler des collections de manière fluide et déclarative.

---

## 2. La méthode `map()`
La méthode **`map()`** est utilisée pour transformer chaque élément d'un stream en appliquant une fonction de transformation. Elle prend une **`Function<T, R>`** en paramètre, où `T` est le type de l'élément d'entrée et `R` est le type de l'élément transformé.

### Exemple avec `map()` :
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");

        // Transformer chaque nom en majuscules
        List<String> nomsMajuscules = noms.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(nomsMajuscules);
    }
}
```

Dans cet exemple, la méthode `map()` transforme chaque élément de la liste de noms en majuscules.

---

## 3. La méthode `filter()`
La méthode **`filter()`** est utilisée pour sélectionner les éléments d'un stream qui répondent à une condition donnée. Elle prend un **`Predicate<T>`** en paramètre, où `T` est le type de l'élément, et retourne un booléen pour indiquer si l'élément doit être conservé.

### Exemple avec `filter()` :
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Filtrer les nombres pairs
        List<Integer> nombresPairs = nombres.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

        System.out.println(nombresPairs);
    }
}
```

Dans cet exemple, `filter()` est utilisé pour conserver uniquement les nombres pairs dans la liste.

---

## 4. La méthode `reduce()`
La méthode **`reduce()`** est utilisée pour combiner tous les éléments d'un stream en un seul résultat, en appliquant de manière répétée une opération binaire (comme l'addition ou la multiplication). Elle est souvent utilisée pour calculer des sommes, des produits, ou pour combiner des chaînes de caractères.

### Exemple avec `reduce()` :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5);

        // Calculer la somme de tous les nombres
        int somme = nombres.stream()
            .reduce(0, (a, b) -> a + b);

        System.out.println("Somme : " + somme);
    }
}
```

Dans cet exemple, `reduce()` est utilisé pour calculer la somme de tous les nombres dans la liste.

---

## 5. Combiner `map()`, `filter()`, et `reduce()`
L'un des avantages de la programmation fonctionnelle est la capacité à combiner plusieurs opérations de transformation et de filtrage dans une seule chaîne d'exécution. En utilisant `map()`, `filter()`, et `reduce()` ensemble, vous pouvez construire des pipelines de traitement complexes de manière fluide et déclarative.

### Exemple combiné :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Filtrer les nombres pairs, les transformer en leur carré, et calculer la somme
        int somme = nombres.stream()
            .filter(n -> n % 2 == 0)       // Conserver les nombres pairs
            .map(n -> n * n)               // Les transformer en leur carré
            .reduce(0, Integer::sum);      // Calculer la somme

        System.out.println("Somme des carrés des nombres pairs : " + somme);
    }
}
```

Dans cet exemple, les nombres pairs sont filtrés, transformés en leur carré, puis la somme des carrés est calculée.

---

## 6. Bonnes pratiques avec `map()`, `filter()`, et `reduce()`
1. **Immutabilité** : Les méthodes de l'API Stream ne modifient pas la collection d'origine. Chaque opération retourne un nouveau stream ou une nouvelle valeur, ce qui respecte les principes de l'immutabilité.
2. **Chaînage fluide** : Profitez du chaînage fluide des méthodes `map()`, `filter()`, et `reduce()` pour écrire du code concis et lisible.
3. **Précaution avec `reduce()`** : Assurez-vous que la fonction de réduction est associative et commutative lorsque vous l'utilisez dans des streams parallèles, pour garantir un comportement cohérent.
4. **Favoriser la lisibilité** : Bien que la programmation fonctionnelle permette d'écrire du code plus concis, veillez à ne pas sacrifier la lisibilité. Utilisez des noms de variables clairs et des lambdas simples.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `map()` et `filter()`
1. Créez une liste de noms.
2. Utilisez `filter()` pour ne conserver que les noms qui commencent par "A", puis utilisez `map()` pour les convertir en majuscules.

### Exercice 2 : Utilisation de `reduce()`
1. Créez une liste d'entiers.
2. Utilisez `reduce()` pour calculer le produit de tous les entiers dans la liste.

---

Ce cours vous a introduit à la programmation fonctionnelle en Java avec l'utilisation de `map()`, `filter()`, et `reduce()`. Vous avez appris à manipuler des collections de manière déclarative et à combiner ces méthodes pour écrire du code plus concis et lisible. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
