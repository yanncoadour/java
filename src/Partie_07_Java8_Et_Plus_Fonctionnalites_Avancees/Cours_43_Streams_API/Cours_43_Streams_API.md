
# Cours 43 : Streams API en Java (traitement de collections avec Stream)

## Objectifs :
- Comprendre l'API Stream en Java pour traiter des collections de manière efficace
- Apprendre à utiliser les opérations de flux comme `filter()`, `map()`, `reduce()`, et bien d'autres
- Découvrir comment écrire du code plus concis et lisible pour le traitement de données

---

## 1. Qu'est-ce qu'un Stream en Java ?
Le **Stream** en Java est une séquence d'éléments sur lesquels vous pouvez effectuer des opérations de manière déclarative (comme les opérations SQL). Il ne s'agit pas d'une structure de données mais d'un **pipeline de traitement** d'éléments qui peut inclure des opérations comme le filtrage, la transformation, et la réduction des données.

### Caractéristiques des Streams :
- **Sans état** : Un stream ne stocke pas les données.
- **Lazy** : Les opérations sur un stream ne sont exécutées que lorsque des résultats sont réellement nécessaires.
- **Peut être infini** : Un stream peut représenter une source infinie de données.

---

## 2. Création d'un Stream
Vous pouvez créer un stream à partir de plusieurs sources, comme des collections, des tableaux, ou même des chaînes de caractères.

### Exemple de création d'un stream à partir d'une collection :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        noms.stream().forEach(nom -> System.out.println(nom));
    }
}
```

### Exemple de création d'un stream à partir d'un tableau :
```java
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] noms = {"Alice", "Bob", "Charlie"};
        Stream.of(noms).forEach(System.out::println);
    }
}
```

---

## 3. Opérations intermédiaires
Les **opérations intermédiaires** sont des opérations qui transforment un stream en un autre stream. Elles sont **lazy**, ce qui signifie qu'elles ne sont pas exécutées immédiatement, mais seulement lorsque des résultats sont nécessaires.

### 3.1 `filter()`
La méthode **`filter()`** est utilisée pour filtrer les éléments du stream en fonction d'un prédicat.

### Exemple avec `filter()` :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6);
        nombres.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}
```

### 3.2 `map()`
La méthode **`map()`** est utilisée pour transformer chaque élément d'un stream.

### Exemple avec `map()` :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        noms.stream()
            .map(nom -> nom.toUpperCase())
            .forEach(System.out::println);
    }
}
```

---

## 4. Opérations terminales
Les **opérations terminales** sont celles qui ferment le pipeline de traitement et retournent un résultat. Les opérations terminales **déclenchent** l'exécution des opérations intermédiaires.

### 4.1 `forEach()`
La méthode **`forEach()`** est utilisée pour itérer sur chaque élément du stream.

### 4.2 `collect()`
La méthode **`collect()`** est utilisée pour collecter les éléments d'un stream dans une collection ou une autre structure de données.

### Exemple avec `collect()` :
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> nomsEnMajuscules = noms.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(nomsEnMajuscules);
    }
}
```

---

## 5. Opérations de réduction
Les **opérations de réduction** prennent un stream d'éléments et les combinent pour produire un seul résultat.

### 5.1 `reduce()`
La méthode **`reduce()`** est utilisée pour combiner tous les éléments d'un stream en un seul résultat.

### Exemple avec `reduce()` :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5);
        int somme = nombres.stream()
            .reduce(0, (a, b) -> a + b);
        
        System.out.println("Somme : " + somme);
    }
}
```

---

## 6. Stream parallèle
Les **streams parallèles** permettent d'exécuter les opérations sur plusieurs threads pour améliorer les performances dans certains cas. Vous pouvez convertir un stream en un stream parallèle avec la méthode `parallelStream()`.

### Exemple de stream parallèle :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6);
        nombres.parallelStream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}
```

---

## 7. Bonnes pratiques avec les Streams
1. **Éviter les side-effects** : Les opérations sur un stream doivent être sans effet de bord, c'est-à-dire qu'elles ne doivent pas modifier l'état des objets ou produire des effets inattendus.
2. **Utiliser les streams parallèles avec précaution** : Bien que les streams parallèles puissent améliorer les performances, ils ne sont pas toujours appropriés pour tous les types de traitements.
3. **Favoriser la lisibilité** : Utilisez des noms de variables et des expressions lambda claires pour rendre les pipelines de traitement plus lisibles.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `filter()` et `map()`
1. Créez une liste de nombres.
2. Utilisez `filter()` pour conserver uniquement les nombres impairs, puis utilisez `map()` pour les multiplier par 2.

### Exercice 2 : Utilisation de `reduce()`
1. Créez un stream d'entiers et utilisez `reduce()` pour calculer le produit de tous les nombres.

---

Ce cours vous a introduit à l'API Stream en Java, qui permet de traiter les collections de manière efficace et déclarative. Vous avez appris à utiliser des opérations comme `filter()`, `map()`, et `reduce()` pour manipuler des données. Les exercices vous permettront de mettre en pratique ces concepts dans des scénarios réels.
