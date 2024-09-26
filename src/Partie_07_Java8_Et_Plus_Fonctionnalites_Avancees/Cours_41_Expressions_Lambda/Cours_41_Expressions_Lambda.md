
# Cours 41 : Expressions Lambda en Java

## Objectifs :
- Comprendre ce qu'est une expression lambda en Java
- Apprendre à utiliser les expressions lambda pour simplifier le code
- Découvrir des exemples concrets d'utilisation des lambdas avec les interfaces fonctionnelles

---

## 1. Qu'est-ce qu'une expression lambda ?
Une **expression lambda** est une façon concise d'écrire une implémentation d'une interface fonctionnelle en Java. Elle permet de simplifier le code en réduisant la quantité de code boilerplate (comme les classes anonymes) lors de l'implémentation d'interfaces avec une seule méthode abstraite.

### Syntaxe d'une expression lambda :
```java
(paramètres) -> { corps }
```

- **paramètres** : Les paramètres passés à la méthode.
- **->** : Séparateur entre les paramètres et le corps de l'expression.
- **corps** : Le bloc de code qui définit le comportement de la méthode.

### Exemple simple d'expression lambda :
```java
Runnable runnable = () -> {
    System.out.println("Bonjour depuis une expression lambda !");
};
new Thread(runnable).start();
```

Dans cet exemple, l'expression lambda implémente l'interface fonctionnelle `Runnable`, qui contient une méthode abstraite `run()`.

---

## 2. Les interfaces fonctionnelles
Une **interface fonctionnelle** est une interface qui ne contient qu'une seule méthode abstraite. Les expressions lambda peuvent être utilisées pour implémenter ces interfaces.

### Exemple d'interface fonctionnelle :
```java
@FunctionalInterface
interface Calculateur {
    int calculer(int a, int b);
}
```

Cette interface contient une seule méthode abstraite `calculer`. Les expressions lambda peuvent être utilisées pour fournir une implémentation de cette méthode.

### Exemple d'implémentation avec une expression lambda :
```java
public class Main {
    public static void main(String[] args) {
        Calculateur addition = (a, b) -> a + b;
        Calculateur multiplication = (a, b) -> a * b;

        System.out.println("Addition : " + addition.calculer(3, 5));
        System.out.println("Multiplication : " + multiplication.calculer(3, 5));
    }
}
```

Dans cet exemple, deux expressions lambda sont utilisées pour implémenter des opérations d'addition et de multiplication.

---

## 3. Avantages des expressions lambda
- **Code plus concis** : Les expressions lambda réduisent la quantité de code nécessaire pour implémenter des interfaces fonctionnelles.
- **Lisibilité** : Le code devient plus lisible et plus facile à comprendre lorsqu'il est écrit de manière concise avec des lambdas.
- **Flexibilité** : Les expressions lambda peuvent être utilisées avec des méthodes et des constructeurs de référence, rendant le code plus flexible et réutilisable.

---

## 4. Utilisation courante avec des collections
Les expressions lambda sont fréquemment utilisées avec les API des collections en Java, comme les méthodes `forEach()`, `map()`, et `filter()` de la classe `Stream`.

### Exemple avec `forEach()` :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        noms.forEach(nom -> System.out.println("Bonjour " + nom));
    }
}
```

Dans cet exemple, l'expression lambda passe chaque élément de la liste à la méthode `forEach()` pour l'afficher.

### Exemple avec `filter()` et `map()` :
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nombres = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> nombresPairs = nombres.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

        List<Integer> carrés = nombres.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());

        System.out.println("Nombres pairs : " + nombresPairs);
        System.out.println("Carrés : " + carrés);
    }
}
```

Dans cet exemple, `filter()` est utilisé pour filtrer les nombres pairs et `map()` est utilisé pour calculer le carré de chaque nombre.

---

## 5. Méthodes de référence
Une **méthode de référence** est une forme abrégée d'une expression lambda qui se réfère directement à une méthode existante. Elle est utilisée lorsque l'expression lambda appelle simplement une méthode.

### Exemple de méthode de référence :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        noms.forEach(System.out::println);  // Méthode de référence
    }
}
```

Dans cet exemple, `System.out::println` est une méthode de référence qui remplace une expression lambda.

### Syntaxe des méthodes de référence :
- **Méthode de référence statique** : `ClassName::methodName`
- **Méthode de référence d'instance** : `instance::methodName`
- **Constructeur de référence** : `ClassName::new`

---

## 6. Bonnes pratiques avec les expressions lambda
1. **Utiliser les lambda pour les interfaces fonctionnelles** : Les lambda ne peuvent être utilisées que pour les interfaces fonctionnelles (une seule méthode abstraite).
2. **Favoriser la lisibilité** : Bien que les expressions lambda permettent d'écrire du code plus concis, assurez-vous que le code reste lisible pour les autres développeurs.
3. **Utiliser des méthodes de référence lorsque c'est possible** : Les méthodes de référence sont plus lisibles et plus concises que les expressions lambda dans certains cas.
4. **Limiter la complexité** : Évitez d'écrire des expressions lambda trop complexes. Si le code devient difficile à comprendre, envisagez de le réécrire sous forme de méthode.

---

## Exercices Pratiques

### Exercice 1 : Implémentation d'une interface fonctionnelle
1. Créez une interface fonctionnelle `Operation` avec une méthode abstraite `executer(int a, int b)`.
2. Implémentez plusieurs opérations (addition, soustraction, multiplication) en utilisant des expressions lambda.

### Exercice 2 : Utilisation des lambdas avec les collections
1. Créez une liste de nombres et utilisez `filter()` avec une expression lambda pour extraire les nombres pairs.
2. Utilisez `map()` pour calculer le cube de chaque nombre de la liste.

---

Ce cours vous a introduit aux expressions lambda en Java, qui simplifient l'implémentation des interfaces fonctionnelles. Vous avez appris à utiliser des lambda dans des scénarios concrets, notamment avec les collections, et à améliorer la lisibilité de votre code grâce aux méthodes de référence. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
