
# Cours 25 : Différence entre exceptions vérifiées et non vérifiées en Java

## Objectifs :
- Comprendre la différence entre les exceptions vérifiées et non vérifiées en Java
- Apprendre à gérer correctement les exceptions pour améliorer la robustesse du code
- Découvrir les meilleures pratiques pour l'utilisation des exceptions

---

## 1. Qu'est-ce qu'une exception en Java ?
En Java, une **exception** est un événement qui interrompt le flux normal d'exécution d'un programme. Les exceptions surviennent généralement lorsqu'une erreur se produit pendant l'exécution du programme (exemple : division par zéro, fichier introuvable). Java classe les exceptions en deux grandes catégories :
- **Exceptions vérifiées (checked exceptions)**
- **Exceptions non vérifiées (unchecked exceptions)**

---

## 2. Exceptions vérifiées (checked exceptions)
Les **exceptions vérifiées** sont celles qui doivent être gérées explicitement par le programmeur, soit en utilisant un bloc `try-catch`, soit en les déclarant avec le mot-clé `throws` dans la signature de la méthode. Ces exceptions sont vérifiées au moment de la compilation, et le programme ne compilera pas si elles ne sont pas traitées correctement.

### Exemple d'exceptions vérifiées :
- `IOException` (entrée/sortie)
- `SQLException` (accès à une base de données)
- `ClassNotFoundException` (classe introuvable)

### Exemple avec `IOException` :
```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File fichier = new File("exemple.txt");
            FileReader lecteur = new FileReader(fichier);
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `IOException` est une exception vérifiée. Java exige que nous la gérions explicitement avec un bloc `try-catch`.

---

## 3. Exceptions non vérifiées (unchecked exceptions)
Les **exceptions non vérifiées** ne nécessitent pas de gestion explicite par le programmeur. Elles ne sont pas vérifiées au moment de la compilation et surviennent généralement en raison d'erreurs de programmation. Toutes les exceptions qui héritent de `RuntimeException` sont des exceptions non vérifiées.

### Exemple d'exceptions non vérifiées :
- `NullPointerException` (référence null)
- `ArrayIndexOutOfBoundsException` (indice de tableau hors limites)
- `ArithmeticException` (erreur arithmétique, comme division par zéro)

### Exemple avec `ArrayIndexOutOfBoundsException` :
```java
public class Main {
    public static void main(String[] args) {
        int[] nombres = {1, 2, 3};
        System.out.println(nombres[5]);  // Provoque une ArrayIndexOutOfBoundsException
    }
}
```

Dans cet exemple, l'accès à un indice de tableau invalide déclenche une `ArrayIndexOutOfBoundsException`, mais Java ne nous oblige pas à la gérer explicitement.

---

## 4. Différences clés entre exceptions vérifiées et non vérifiées

| **Caractéristique**        | **Exceptions vérifiées**                        | **Exceptions non vérifiées**                  |
|----------------------------|-------------------------------------------------|----------------------------------------------|
| Vérification à la compilation | Oui, doit être gérée ou déclarée avec `throws`  | Non, aucune gestion obligatoire              |
| Classe parente             | Héritent de `Exception`, mais pas de `RuntimeException` | Héritent de `RuntimeException`              |
| Exemple                    | `IOException`, `SQLException`                  | `NullPointerException`, `ArrayIndexOutOfBoundsException` |
| Usage                      | Pour des erreurs que l'on peut raisonnablement anticiper et gérer | Pour des erreurs souvent causées par des bugs dans le code |
| Nécessité de gestion        | Doivent être gérées ou déclarées dans la signature de la méthode | Gestion optionnelle, mais recommandée |

---

## 5. Quand utiliser les exceptions vérifiées et non vérifiées ?

- **Exceptions vérifiées** : Elles sont généralement utilisées pour des erreurs que l'on peut anticiper et gérer. Par exemple, lorsqu'on tente de lire un fichier, il est possible que le fichier n'existe pas, et cela doit être traité.
- **Exceptions non vérifiées** : Utilisées pour des erreurs liées à des fautes de programmation (comme une division par zéro ou un accès à un tableau hors limites), qui sont souvent évitables avec des vérifications adéquates dans le code.

### Bonne pratique :
- Utilisez les **exceptions vérifiées** pour des erreurs que l'utilisateur ou l'environnement peuvent causer (ex: fichier manquant, problème réseau).
- Utilisez les **exceptions non vérifiées** pour des erreurs qui résultent de bugs dans le programme (ex: null pointer).

---

## Exercices Pratiques

### Exercice 1 : Gérer une exception vérifiée
1. Créez un programme qui tente de lire un fichier texte.
2. Utilisez un bloc `try-catch` pour gérer l'exception `FileNotFoundException`.

### Exercice 2 : Gérer une exception non vérifiée
1. Créez un tableau de trois éléments.
2. Essayez d'accéder à un indice en dehors des limites et gérez l'exception avec un bloc `try-catch`.

---

Ce cours vous a permis de comprendre la différence entre les exceptions vérifiées et non vérifiées en Java. Vous avez vu quand et comment les utiliser pour améliorer la robustesse de votre code. Les exercices vous aideront à mettre en pratique ces concepts dans vos propres programmes.
