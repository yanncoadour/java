
# Cours 31 : Gestion des fichiers en Java (File, Path, Files)

## Objectifs :
- Comprendre comment manipuler des fichiers et des répertoires en Java
- Découvrir l'utilisation des classes `File`, `Path` et `Files`
- Apprendre à effectuer des opérations courantes comme la création, la lecture, l'écriture et la suppression de fichiers

---

## 1. La classe `File`
La classe **`File`** représente un fichier ou un répertoire sur le système de fichiers. Elle permet de manipuler des fichiers et des répertoires, mais ne permet pas de lire ou écrire directement dans les fichiers.

### Création d'un objet `File` :
```java
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fichier = new File("exemple.txt");
        if (fichier.exists()) {
            System.out.println("Le fichier existe.");
        } else {
            System.out.println("Le fichier n'existe pas.");
        }
    }
}
```

Dans cet exemple, l'objet `File` représente un fichier nommé "exemple.txt". La méthode `exists()` permet de vérifier si ce fichier existe.

### Opérations courantes avec `File` :
- `exists()` : Vérifie si le fichier ou répertoire existe.
- `createNewFile()` : Crée un nouveau fichier.
- `delete()` : Supprime un fichier.
- `mkdir()` : Crée un nouveau répertoire.

---

## 2. La classe `Path`
Introduite avec Java 7, la classe **`Path`** fait partie du package `java.nio.file` et représente une abstraction des chemins de fichiers. Elle est plus moderne que la classe `File` et offre plus de fonctionnalités pour manipuler les chemins de fichiers.

### Exemple de création d'un objet `Path` :
```java
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path chemin = Paths.get("exemple.txt");
        System.out.println("Chemin : " + chemin.toAbsolutePath());
    }
}
```

Dans cet exemple, l'objet `Path` représente un chemin vers le fichier "exemple.txt". La méthode `toAbsolutePath()` renvoie le chemin absolu du fichier.

---

## 3. La classe `Files`
La classe **`Files`** fournit des méthodes utilitaires pour manipuler des fichiers et des répertoires. Elle permet d'effectuer des opérations telles que la création, la lecture, l'écriture et la suppression de fichiers, en plus de la copie et du déplacement.

### Lire le contenu d'un fichier avec `Files.readAllLines()` :
```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path chemin = Paths.get("exemple.txt");
        try {
            List<String> lignes = Files.readAllLines(chemin);
            for (String ligne : lignes) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `Files.readAllLines()` lit toutes les lignes du fichier "exemple.txt" et les affiche.

### Écrire dans un fichier avec `Files.write()` :
```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Path chemin = Paths.get("exemple.txt");
        try {
            Files.write(chemin, Arrays.asList("Ligne 1", "Ligne 2", "Ligne 3"));
            System.out.println("Données écrites dans le fichier.");
        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans le fichier : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `Files.write()` écrit plusieurs lignes dans le fichier "exemple.txt".

### Supprimer un fichier avec `Files.delete()` :
```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Path chemin = Paths.get("exemple.txt");
        try {
            Files.delete(chemin);
            System.out.println("Fichier supprimé.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la suppression du fichier : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `Files.delete()` supprime le fichier "exemple.txt".

---

## 4. Comparaison entre `File`, `Path`, et `Files`

| **Caractéristique**         | **File**                               | **Path**                             | **Files**                                 |
|-----------------------------|----------------------------------------|--------------------------------------|-------------------------------------------|
| Création de fichiers/répertoires | Oui                                | Non                                  | Oui                                       |
| Représentation des chemins   | Représente des chemins de fichiers et de répertoires | Représente des chemins de fichiers  | Utilitaire pour manipuler les fichiers et répertoires |
| Lecture et écriture          | Non, nécessite des flux (`InputStream`, `OutputStream`) | Non                                  | Oui, avec des méthodes comme `readAllLines()`, `write()` |

---

## 5. Bonnes pratiques pour la gestion des fichiers
1. **Utilisez `Path` et `Files`** : Préférez `Path` et `Files` à `File` pour une gestion plus moderne des fichiers.
2. **Gérez les exceptions** : Les opérations sur les fichiers peuvent échouer (fichier manquant, permissions insuffisantes), donc il est important de toujours gérer les exceptions `IOException`.
3. **Vérifiez l'existence des fichiers** : Avant de lire ou écrire dans un fichier, assurez-vous qu'il existe en utilisant des méthodes comme `exists()`.

---

## Exercices Pratiques

### Exercice 1 : Lecture et écriture avec `Files`
1. Créez un fichier texte et écrivez plusieurs lignes dedans en utilisant `Files.write()`.
2. Lisez ensuite le fichier avec `Files.readAllLines()` et affichez son contenu.

### Exercice 2 : Manipulation des répertoires
1. Créez un répertoire avec `Files.createDirectory()`.
2. Créez plusieurs fichiers dans ce répertoire.
3. Supprimez le répertoire et son contenu avec `Files.delete()`.

---

Ce cours vous a introduit à la gestion des fichiers en Java en utilisant les classes `File`, `Path`, et `Files`. Vous avez appris à effectuer des opérations courantes comme la lecture, l'écriture, et la suppression de fichiers. Les exercices vous permettront de pratiquer ces concepts et de mieux comprendre comment manipuler les fichiers dans vos programmes.
