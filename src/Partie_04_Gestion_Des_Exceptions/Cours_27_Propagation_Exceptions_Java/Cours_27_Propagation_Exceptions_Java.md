
# Cours 27 : Propagation des exceptions en Java (throws)

## Objectifs :
- Comprendre le concept de propagation des exceptions en Java
- Apprendre à utiliser le mot-clé `throws` pour propager des exceptions
- Découvrir comment gérer les exceptions qui se propagent entre les méthodes

---

## 1. Qu'est-ce que la propagation des exceptions ?
En Java, lorsqu'une exception est levée (thrown), elle se propage dans la pile d'appels des méthodes jusqu'à ce qu'elle soit capturée et gérée par un bloc `try-catch`. Si l'exception n'est pas capturée dans la méthode où elle est levée, elle remonte à la méthode appelante, et ainsi de suite, jusqu'à ce qu'elle soit capturée ou qu'elle atteigne le niveau supérieur (le programme se termine alors avec une erreur).

---

## 2. Utilisation du mot-clé `throws`
Le mot-clé **`throws`** est utilisé dans la signature d'une méthode pour indiquer que cette méthode peut potentiellement lever une exception. Cela signifie que la méthode ne gère pas l'exception elle-même, mais la laisse être propagée à la méthode appelante.

### Syntaxe :
```java
typeDeRetour nomDeLaMéthode() throws NomException {
    // Code qui peut lever une exception
}
```

### Exemple :
```java
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            lireFichier();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public static void lireFichier() throws IOException {
        throw new IOException("Fichier introuvable");
    }
}
```

Dans cet exemple, la méthode `lireFichier()` jette une `IOException`, mais ne la capture pas. La méthode appelante (`main`) capture et gère l'exception à l'aide d'un bloc `try-catch`.

---

## 3. Propagation des exceptions à plusieurs niveaux
L'exception peut se propager à travers plusieurs méthodes si aucune d'entre elles ne la capture. Chaque méthode doit soit capturer l'exception, soit la propager à son tour en utilisant le mot-clé `throws`.

### Exemple avec plusieurs niveaux de méthodes :
```java
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            methodeA();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void methodeA() throws IOException {
        methodeB();
    }

    public static void methodeB() throws IOException {
        throw new IOException("Erreur dans methodeB()");
    }
}
```

Dans cet exemple, `methodeB()` lève une `IOException`, qui est propagée à `methodeA()`, et finalement capturée dans `main()`.

---

## 4. Exceptions vérifiées et propagation
Les **exceptions vérifiées** (comme `IOException`) doivent être soit capturées, soit propagées à la méthode appelante à l'aide du mot-clé `throws`. Si une méthode lève une exception vérifiée, elle doit être explicitement gérée par le programmeur.

### Exemple :
```java
public static void methode() throws IOException {
    // Lever une IOException
    throw new IOException("Erreur d'entrée/sortie");
}
```

Dans cet exemple, l'exception `IOException` est une exception vérifiée, donc elle doit être capturée ou propagée.

---

## 5. Exceptions non vérifiées et propagation
Les **exceptions non vérifiées** (comme `NullPointerException` et `ArithmeticException`) sont des sous-classes de `RuntimeException`. Elles peuvent être propagées automatiquement sans avoir besoin d'être déclarées avec `throws`.

### Exemple :
```java
public static void methodeNonVerifiee() {
    // Lever une NullPointerException
    throw new NullPointerException("Référence null");
}
```

Les exceptions non vérifiées peuvent se propager librement sans être explicitement déclarées, mais il est toujours possible de les capturer dans un bloc `try-catch`.

---

## 6. Différences entre exceptions capturées et propagées

| **Méthode**         | **Exceptions capturées**                            | **Exceptions propagées**                         |
|---------------------|-----------------------------------------------------|-------------------------------------------------|
| Bloc `try-catch`    | L'exception est capturée et gérée dans la méthode.   | L'exception est transmise à la méthode appelante. |
| Mot-clé `throws`    | Non nécessaire.                                      | Utilisation de `throws` pour propager l'exception. |
| Utilisation         | Lorsque l'erreur doit être traitée immédiatement.   | Lorsque la méthode appelante est mieux équipée pour gérer l'erreur. |

---

## 7. Bonnes pratiques pour la propagation des exceptions

1. **Utilisez `throws` pour des erreurs que la méthode appelante peut mieux gérer** : Si une méthode ne peut pas résoudre l'erreur, il est préférable de la propager.
2. **Capturez les exceptions au niveau approprié** : Ne capturez pas les exceptions si vous ne savez pas comment les traiter. Laissez-les être propagées à une méthode qui peut les gérer correctement.
3. **Soyez explicite avec les exceptions vérifiées** : Déclarez toujours les exceptions vérifiées avec `throws` si elles ne sont pas capturées.

---

## Exercices Pratiques

### Exercice 1 : Propagation d'une exception vérifiée
1. Créez une méthode `lireFichier()` qui lève une `FileNotFoundException`.
2. Utilisez `throws` pour propager l'exception à la méthode `main()`, où elle sera capturée et gérée.

### Exercice 2 : Propagation à plusieurs niveaux
1. Créez trois méthodes imbriquées `methode1()`, `methode2()`, et `methode3()`.
2. Dans `methode3()`, levez une exception.
3. Utilisez `throws` pour propager l'exception à travers les méthodes jusqu'à `main()`, où elle sera capturée.

---

Ce cours vous a montré comment propager des exceptions en Java en utilisant le mot-clé `throws`. Vous avez appris à transmettre des exceptions entre différentes méthodes et à les capturer au bon niveau pour améliorer la gestion des erreurs dans vos programmes. Les exercices vous permettront de pratiquer ces concepts dans des scénarios concrets.
