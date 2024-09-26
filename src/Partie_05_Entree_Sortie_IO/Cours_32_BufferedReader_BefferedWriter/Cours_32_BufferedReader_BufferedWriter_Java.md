
# Cours 32 : `BufferedReader` et `BufferedWriter` en Java

## Objectifs :
- Comprendre l'utilité des classes `BufferedReader` et `BufferedWriter` en Java
- Apprendre à lire et écrire des fichiers de manière plus efficace grâce au buffering
- Découvrir les méthodes courantes pour la manipulation de fichiers textuels

---

## 1. Qu'est-ce que le buffering ?
Le **buffering** consiste à utiliser un tampon (mémoire intermédiaire) pour lire ou écrire de grandes quantités de données en une seule fois, plutôt que d'effectuer des opérations I/O (entrée/sortie) fréquentes. Cela permet d'améliorer les performances, en particulier lors du traitement de fichiers volumineux.

En Java, les classes **`BufferedReader`** et **`BufferedWriter`** sont utilisées pour le buffering lors de la lecture et de l'écriture de fichiers texte.

---

## 2. La classe `BufferedReader`
La classe **`BufferedReader`** est utilisée pour lire du texte à partir d'un flux d'entrée de manière plus efficace en utilisant un tampon. Elle permet de lire les données ligne par ligne ou caractère par caractère.

### Exemple d'utilisation de `BufferedReader` :
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("exemple.txt"))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                System.out.println(ligne);  // Affichage de chaque ligne du fichier
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `BufferedReader` est utilisé pour lire un fichier texte ligne par ligne à l'aide de la méthode `readLine()`.

### Méthodes courantes de `BufferedReader` :
- **`readLine()`** : Lit une ligne de texte et renvoie `null` à la fin du fichier.
- **`close()`** : Ferme le flux après utilisation pour libérer les ressources.

---

## 3. La classe `BufferedWriter`
La classe **`BufferedWriter`** est utilisée pour écrire du texte dans un fichier de manière plus efficace en utilisant un tampon. Elle permet d'écrire des données ligne par ligne ou caractère par caractère.

### Exemple d'utilisation de `BufferedWriter` :
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sortie.txt"))) {
            writer.write("Ligne 1");
            writer.newLine();  // Ajout d'un saut de ligne
            writer.write("Ligne 2");
        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans le fichier : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `BufferedWriter` est utilisé pour écrire des lignes de texte dans un fichier. La méthode `newLine()` ajoute un saut de ligne entre chaque écriture.

### Méthodes courantes de `BufferedWriter` :
- **`write()`** : Écrit une chaîne de caractères dans le fichier.
- **`newLine()`** : Insère un saut de ligne dans le fichier.
- **`close()`** : Ferme le flux après utilisation.

---

## 4. Pourquoi utiliser `BufferedReader` et `BufferedWriter` ?
Les classes `BufferedReader` et `BufferedWriter` sont utilisées pour améliorer les performances des opérations de lecture et d'écriture de fichiers en limitant le nombre d'accès disque. Elles sont particulièrement utiles lorsque vous travaillez avec de gros fichiers ou lorsque vous effectuez de nombreuses opérations I/O.

### Avantages :
- **Performance** : En utilisant un tampon, les opérations de lecture et d'écriture sont plus rapides.
- **Simplicité** : Les méthodes comme `readLine()` et `newLine()` facilitent la manipulation des fichiers texte.

---

## 5. Bonnes pratiques avec `BufferedReader` et `BufferedWriter`
1. **Toujours fermer les flux** : Assurez-vous de fermer les flux en utilisant la méthode `close()` ou en employant un bloc `try-with-resources` pour libérer les ressources.
2. **Utilisez un tampon pour de grandes quantités de données** : Pour les fichiers volumineux ou les nombreuses opérations I/O, privilégiez l'utilisation de `BufferedReader` et `BufferedWriter` pour des performances accrues.
3. **Évitez de mélanger les flux** : Ne mélangez pas les flux de bytes (comme `InputStream`) et les flux de caractères (comme `Reader`) pour éviter les erreurs de conversion.

---

## Exercices Pratiques

### Exercice 1 : Lecture d'un fichier avec `BufferedReader`
1. Créez un fichier texte contenant plusieurs lignes de texte.
2. Utilisez `BufferedReader` pour lire le fichier ligne par ligne et afficher chaque ligne dans la console.

### Exercice 2 : Écriture dans un fichier avec `BufferedWriter`
1. Créez un programme qui écrit plusieurs lignes de texte dans un fichier en utilisant `BufferedWriter`.
2. Assurez-vous d'ajouter des sauts de ligne entre chaque écriture.

---

Ce cours vous a présenté les classes `BufferedReader` et `BufferedWriter` en Java, qui permettent de lire et d'écrire des fichiers texte de manière plus efficace. Vous avez découvert les principales méthodes associées à ces classes et vu comment les utiliser dans des opérations courantes de gestion de fichiers. Les exercices vous permettront de pratiquer ces concepts et de mieux comprendre leur utilisation.
