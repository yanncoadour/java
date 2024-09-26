
# Cours 42 : Interfaces Fonctionnelles en Java

## Objectifs :
- Comprendre ce qu'est une interface fonctionnelle en Java
- Apprendre à utiliser les interfaces fonctionnelles avec les expressions lambda
- Découvrir les interfaces fonctionnelles prédéfinies en Java et leur utilisation

---

## 1. Qu'est-ce qu'une interface fonctionnelle ?
Une **interface fonctionnelle** est une interface qui ne contient qu'une seule méthode abstraite. En Java, les interfaces fonctionnelles sont utilisées comme cibles pour les expressions lambda et les références de méthode. Elles facilitent l'écriture de code plus concis et lisible.

### Exemple d'interface fonctionnelle :
```java
@FunctionalInterface
interface Operation {
    int executer(int a, int b);
}
```

Dans cet exemple, l'interface `Operation` est une interface fonctionnelle car elle ne contient qu'une seule méthode abstraite `executer`.

### Utilisation avec une expression lambda :
```java
public class Main {
    public static void main(String[] args) {
        Operation addition = (a, b) -> a + b;
        System.out.println("Addition : " + addition.executer(5, 3));
    }
}
```

Dans cet exemple, une expression lambda est utilisée pour fournir une implémentation de l'interface fonctionnelle `Operation`.

---

## 2. L'annotation `@FunctionalInterface`
Java fournit l'annotation **`@FunctionalInterface`** pour marquer une interface comme fonctionnelle. Bien que cette annotation soit optionnelle, elle permet de s'assurer que l'interface ne contienne qu'une seule méthode abstraite. Si l'interface contient plus d'une méthode abstraite, une erreur de compilation sera levée.

### Exemple avec `@FunctionalInterface` :
```java
@FunctionalInterface
interface Operation {
    int executer(int a, int b);
}
```

L'annotation `@FunctionalInterface` garantit que l'interface ne peut contenir qu'une seule méthode abstraite, assurant ainsi sa compatibilité avec les expressions lambda.

---

## 3. Interfaces fonctionnelles prédéfinies en Java
Java 8 a introduit plusieurs **interfaces fonctionnelles prédéfinies** dans le package `java.util.function`. Ces interfaces sont conçues pour couvrir les cas d'utilisation courants des expressions lambda.

### 3.1 L'interface `Predicate`
L'interface **`Predicate<T>`** représente une fonction qui prend un argument et retourne un booléen. Elle est souvent utilisée pour tester des conditions.

### Exemple avec `Predicate` :
```java
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> estPair = n -> n % 2 == 0;
        System.out.println("4 est pair : " + estPair.test(4));
        System.out.println("7 est pair : " + estPair.test(7));
    }
}
```

### 3.2 L'interface `Function`
L'interface **`Function<T, R>`** représente une fonction qui prend un argument de type `T` et retourne une valeur de type `R`.

### Exemple avec `Function` :
```java
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> longueur = s -> s.length();
        System.out.println("Longueur de 'Bonjour' : " + longueur.apply("Bonjour"));
    }
}
```

### 3.3 L'interface `Consumer`
L'interface **`Consumer<T>`** représente une fonction qui prend un argument de type `T` et ne retourne rien. Elle est souvent utilisée pour appliquer une action sur chaque élément d'une collection.

### Exemple avec `Consumer` :
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> afficher = nom -> System.out.println("Bonjour " + nom);
        noms.forEach(afficher);
    }
}
```

### 3.4 L'interface `Supplier`
L'interface **`Supplier<T>`** représente une fonction qui ne prend aucun argument mais retourne une valeur de type `T`.

### Exemple avec `Supplier` :
```java
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> message = () -> "Bonjour depuis Supplier";
        System.out.println(message.get());
    }
}
```

---

## 4. Avantages des interfaces fonctionnelles
- **Simplicité** : Elles permettent d'écrire du code plus simple et concis en utilisant des expressions lambda au lieu de classes anonymes.
- **Réutilisabilité** : Les interfaces fonctionnelles prédéfinies peuvent être réutilisées dans divers contextes, ce qui réduit le besoin de créer des interfaces personnalisées.
- **Lisibilité** : L'utilisation d'expressions lambda avec des interfaces fonctionnelles améliore la lisibilité du code.

---

## 5. Créer des interfaces fonctionnelles personnalisées
Vous pouvez créer vos propres interfaces fonctionnelles en définissant une interface avec une seule méthode abstraite. Ces interfaces peuvent ensuite être utilisées avec des expressions lambda.

### Exemple d'interface fonctionnelle personnalisée :
```java
@FunctionalInterface
interface Calcul {
    int appliquer(int a, int b);
}
```

### Utilisation d'une interface fonctionnelle personnalisée :
```java
public class Main {
    public static void main(String[] args) {
        Calcul addition = (a, b) -> a + b;
        Calcul multiplication = (a, b) -> a * b;

        System.out.println("Addition : " + addition.appliquer(5, 3));
        System.out.println("Multiplication : " + multiplication.appliquer(5, 3));
    }
}
```

---

## 6. Bonnes pratiques avec les interfaces fonctionnelles
1. **Utiliser `@FunctionalInterface`** : Toujours annoter les interfaces fonctionnelles avec `@FunctionalInterface` pour garantir qu'elles respectent les règles des interfaces fonctionnelles.
2. **Privilégier les interfaces prédéfinies** : Utilisez les interfaces fonctionnelles prédéfinies (`Predicate`, `Function`, `Consumer`, etc.) lorsque possible, plutôt que de créer de nouvelles interfaces.
3. **Favoriser la lisibilité** : Les expressions lambda doivent rester simples et faciles à comprendre. Si une expression lambda devient complexe, envisagez d'utiliser une méthode nommée à la place.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `Predicate`
1. Créez un programme qui filtre une liste de nombres pour ne conserver que les nombres pairs en utilisant un `Predicate`.

### Exercice 2 : Création d'une interface fonctionnelle personnalisée
1. Créez une interface fonctionnelle `Calcul` avec une méthode abstraite `appliquer(int a, int b)`.
2. Implémentez plusieurs opérations (addition, soustraction, multiplication) en utilisant des expressions lambda.

---

Ce cours vous a introduit aux interfaces fonctionnelles en Java, en mettant l'accent sur leur utilisation avec les expressions lambda. Vous avez également découvert les interfaces fonctionnelles prédéfinies en Java et appris à créer vos propres interfaces fonctionnelles personnalisées. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
