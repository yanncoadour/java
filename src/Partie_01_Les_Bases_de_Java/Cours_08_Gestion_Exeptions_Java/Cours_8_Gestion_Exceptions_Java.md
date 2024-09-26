
# Cours 8 : Gestion des exceptions de base en Java (try-catch-finally)

## Objectifs :
- Comprendre la gestion des exceptions en Java
- Apprendre à utiliser les blocs `try`, `catch`, et `finally`
- Découvrir comment gérer les erreurs de manière efficace dans un programme

---

## 1. Qu'est-ce qu'une exception ?
Une **exception** est un événement qui interrompt l'exécution normale d'un programme. Elle peut se produire pour diverses raisons : une division par zéro, une tentative d'accès à un élément hors des limites d'un tableau, ou encore une entrée utilisateur incorrecte.

Java fournit un mécanisme pour capturer et gérer ces exceptions afin d'éviter que le programme ne plante brutalement.

---

## 2. Gestion des exceptions avec `try`, `catch`, et `finally`

### Syntaxe de base :
```java
try {
    // Code qui peut générer une exception
} catch (TypeException e) {
    // Code pour gérer l'exception
} finally {
    // Code qui s'exécute toujours, qu'il y ait une exception ou non
}
```

- **try** : Le bloc de code à surveiller pour des exceptions.
- **catch** : Le bloc où l'on capture et traite l'exception.
- **finally** : Le bloc qui s'exécute toujours, même si une exception est levée (optionnel).

---

## 3. Exemple simple de gestion d'exception
Voici un exemple qui montre comment gérer une exception liée à une division par zéro.

```java
public class GestionException {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int resultat = a / b;  // Cela va provoquer une exception
        } catch (ArithmeticException e) {
            System.out.println("Erreur : Division par zéro !");
        } finally {
            System.out.println("Bloc finally exécuté.");
        }
    }
}
```

### Explication :
- Si une division par zéro est tentée, une exception `ArithmeticException` est levée et capturée par le bloc `catch`.
- Le bloc `finally` est toujours exécuté, même si une exception est levée.

---

## 4. Utilisation de plusieurs blocs `catch`
Il est possible d'avoir plusieurs blocs `catch` pour capturer différents types d'exceptions.

### Exemple :
```java
public class GestionExceptionMultiple {
    public static void main(String[] args) {
        try {
            int[] tableau = {1, 2, 3};
            System.out.println(tableau[5]);  // Erreur : Index hors limites
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erreur : Index hors limites !");
        } catch (ArithmeticException e) {
            System.out.println("Erreur : Problème arithmétique !");
        } finally {
            System.out.println("Bloc finally exécuté.");
        }
    }
}
```

---

## 5. Le bloc `finally`
Le bloc `finally` est toujours exécuté, que l'exception soit levée ou non. Il est souvent utilisé pour libérer des ressources (comme fermer des fichiers ou des connexions) indépendamment de la réussite ou de l'échec du bloc `try`.

### Exemple :
```java
try {
    // Code qui peut générer une exception
} catch (Exception e) {
    System.out.println("Une exception a été capturée.");
} finally {
    System.out.println("Libération des ressources...");
}
```

---

## Exercices Pratiques

### Exercice 1 : Gestion d'une exception arithmétique
1. Créez un programme nommé `DivisionException.java`.
2. Écrivez un code qui divise deux nombres. Utilisez un bloc `try-catch` pour capturer l'exception en cas de division par zéro et afficher un message d'erreur.

### Exercice 2 : Gestion de plusieurs exceptions
1. Créez un programme nommé `MultipleExceptions.java`.
2. Écrivez un code qui tente d'accéder à un élément hors des limites d'un tableau et qui effectue une division par zéro. Utilisez plusieurs blocs `catch` pour capturer les exceptions `ArrayIndexOutOfBoundsException` et `ArithmeticException`.

### Exercice 3 : Utilisation du bloc `finally`
1. Créez un programme nommé `FinallyExample.java`.
2. Utilisez un bloc `try-catch` pour capturer une exception, puis un bloc `finally` pour afficher un message, qu'il y ait une exception ou non.

---

Ce cours vous a présenté les concepts de gestion des exceptions en Java à l'aide des blocs `try`, `catch`, et `finally`. Vous avez appris comment gérer les erreurs dans votre code de manière élégante et efficace. Les exercices vous aideront à appliquer ces concepts.
