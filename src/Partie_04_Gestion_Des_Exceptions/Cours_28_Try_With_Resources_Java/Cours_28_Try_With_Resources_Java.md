
# Cours 28 : Gestion des ressources avec `try-with-resources` en Java

## Objectifs :
- Comprendre le concept de gestion automatique des ressources avec `try-with-resources` en Java
- Apprendre à utiliser `try-with-resources` pour fermer automatiquement les ressources
- Découvrir les avantages de cette méthode par rapport à la gestion manuelle des ressources

---

## 1. Qu'est-ce que `try-with-resources` ?
Le **`try-with-resources`** est une structure introduite dans Java 7 qui permet de gérer automatiquement la fermeture des ressources telles que les fichiers, les flux ou les connexions à une base de données. Lorsque vous utilisez cette structure, Java garantit que les ressources seront fermées automatiquement à la fin du bloc `try`, même si une exception est levée.

---

## 2. Pourquoi utiliser `try-with-resources` ?
Lorsque vous travaillez avec des ressources (comme des fichiers ou des bases de données), il est important de les fermer après utilisation pour éviter les fuites de mémoire ou autres problèmes. Avant Java 7, cela devait être fait manuellement dans un bloc `finally`. Avec `try-with-resources`, cela est géré automatiquement.

### Gestion manuelle des ressources (avant Java 7) :
```java
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileReader lecteur = null;
        try {
            lecteur = new FileReader("exemple.txt");
            // Lire le fichier
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier");
        } finally {
            if (lecteur != null) {
                try {
                    lecteur.close();  // Fermeture manuelle de la ressource
                } catch (IOException e) {
                    System.out.println("Erreur de fermeture du fichier");
                }
            }
        }
    }
}
```

Dans cet exemple, la fermeture du fichier doit être effectuée manuellement dans un bloc `finally`. Cela peut rendre le code plus complexe et difficile à maintenir.

---

## 3. Utilisation de `try-with-resources`
Avec `try-with-resources`, vous pouvez déclarer et initialiser des ressources dans le bloc `try`, et celles-ci seront automatiquement fermées à la fin du bloc, même si une exception est levée.

### Syntaxe :
```java
try (TypeRessource nomRessource = new TypeRessource()) {
    // Utilisation de la ressource
} catch (ExceptionType e) {
    // Gestion des exceptions
}
```

### Exemple avec `FileReader` :
```java
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileReader lecteur = new FileReader("exemple.txt")) {
            // Lire le fichier
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier");
        }
    }
}
```

Dans cet exemple, la ressource `FileReader` est automatiquement fermée à la fin du bloc `try`.

---

## 4. Conditions d'utilisation de `try-with-resources`
Pour être utilisée dans un bloc `try-with-resources`, une ressource doit implémenter l'interface **`AutoCloseable`** (ou **`Closeable`**). Cela garantit que la méthode `close()` sera appelée à la fin de l'utilisation de la ressource.

### Exemple avec une ressource personnalisée :
```java
class MaRessource implements AutoCloseable {
    public void utiliser() {
        System.out.println("Ressource utilisée");
    }

    @Override
    public void close() {
        System.out.println("Ressource fermée");
    }
}

public class Main {
    public static void main(String[] args) {
        try (MaRessource ressource = new MaRessource()) {
            ressource.utiliser();
        }
    }
}
```

Dans cet exemple, la classe `MaRessource` implémente `AutoCloseable`, ce qui permet à la méthode `close()` d'être appelée automatiquement à la fin du bloc `try`.

---

## 5. Gestion multiple de ressources
Vous pouvez déclarer plusieurs ressources dans un seul bloc `try-with-resources`. Toutes les ressources seront fermées automatiquement, et cela dans l'ordre inverse de leur ouverture.

### Exemple avec plusieurs ressources :
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileReader lecteur = new FileReader("exemple.txt");
             BufferedReader bufferedReader = new BufferedReader(lecteur)) {
            // Lire le fichier
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier");
        }
    }
}
```

Dans cet exemple, `FileReader` et `BufferedReader` sont automatiquement fermés à la fin du bloc `try`.

---

## 6. Avantages du `try-with-resources`
- **Code plus propre** : Le code est plus simple et facile à lire car la fermeture des ressources est gérée automatiquement.
- **Moins d'erreurs** : Vous ne risquez pas d'oublier de fermer une ressource, ce qui réduit les risques de fuites de mémoire ou d'autres problèmes liés aux ressources non fermées.
- **Fermeture automatique** : Les ressources sont toujours fermées, même en cas d'exception.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `try-with-resources`
1. Créez un programme qui lit le contenu d'un fichier texte en utilisant `try-with-resources`.
2. Assurez-vous que la ressource est automatiquement fermée à la fin du bloc `try`.

### Exercice 2 : Création d'une ressource personnalisée
1. Créez une classe `ConnexionBaseDeDonnees` qui implémente `AutoCloseable`.
2. Utilisez `try-with-resources` pour ouvrir et fermer la connexion automatiquement.

---

Ce cours vous a introduit à la gestion automatique des ressources en Java avec `try-with-resources`. Vous avez appris à utiliser cette structure pour simplifier votre code et réduire les erreurs liées à la gestion des ressources. Les exercices vous permettront de pratiquer ces concepts et de comprendre comment ils peuvent améliorer la fiabilité de vos programmes.
