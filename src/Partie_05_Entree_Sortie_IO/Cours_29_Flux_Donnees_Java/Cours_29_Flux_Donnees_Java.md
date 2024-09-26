
# Cours 29 : Flux de données en Java (InputStream, OutputStream, Reader, Writer)

## Objectifs :
- Comprendre les différents types de flux de données en Java
- Apprendre à utiliser `InputStream` et `OutputStream` pour gérer les flux de bytes
- Découvrir l'utilisation de `Reader` et `Writer` pour gérer les flux de caractères

---

## 1. Qu'est-ce qu'un flux de données en Java ?
Un **flux de données** (stream) en Java est une séquence ordonnée de données qui permet de lire ou d'écrire des informations de manière continue. Les flux de données sont utilisés pour transférer des données depuis et vers des fichiers, des réseaux ou d'autres sources d'entrée/sortie.

Il existe deux types de flux de base :
- **Flux de bytes** : Utilisés pour lire et écrire des données binaires (images, fichiers, etc.). Les classes de base sont `InputStream` et `OutputStream`.
- **Flux de caractères** : Utilisés pour lire et écrire des données textuelles. Les classes de base sont `Reader` et `Writer`.

---

## 2. Flux de bytes : `InputStream` et `OutputStream`
Les flux de bytes sont utilisés pour lire et écrire des données au niveau binaire. Ils sont adaptés pour traiter des fichiers tels que des images, des vidéos ou des fichiers audio.

### `InputStream` : Lire des données
La classe **`InputStream`** est la classe de base pour lire des bytes à partir de différentes sources comme des fichiers, des réseaux, ou des entrées utilisateur.

### Exemple d'utilisation de `FileInputStream` :
```java
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("exemple.txt")) {
            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                System.out.print((char) byteData);  // Conversion du byte en char
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `FileInputStream` lit les données d'un fichier byte par byte et les affiche sous forme de caractères.

### `OutputStream` : Écrire des données
La classe **`OutputStream`** est la classe de base pour écrire des bytes dans des fichiers, des réseaux ou d'autres destinations.

### Exemple d'utilisation de `FileOutputStream` :
```java
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("sortie.txt")) {
            String data = "Bonjour, monde!";
            outputStream.write(data.getBytes());  // Écriture des bytes
        } catch (IOException e) {
            System.out.println("Erreur d'écriture : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `FileOutputStream` écrit des données textuelles sous forme de bytes dans un fichier.

---

## 3. Flux de caractères : `Reader` et `Writer`
Les flux de caractères sont conçus pour lire et écrire des données sous forme de caractères (texte). Ils sont plus adaptés que les flux de bytes pour traiter des données textuelles.

### `Reader` : Lire des caractères
La classe **`Reader`** est la classe de base pour lire des caractères à partir de différentes sources comme des fichiers, des réseaux ou des entrées utilisateur.

### Exemple d'utilisation de `FileReader` :
```java
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("exemple.txt")) {
            int charData;
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);  // Affichage des caractères lus
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
    }
}
```

### `Writer` : Écrire des caractères
La classe **`Writer`** est la classe de base pour écrire des caractères dans des fichiers, des réseaux ou d'autres destinations.

### Exemple d'utilisation de `FileWriter` :
```java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("sortie.txt")) {
            writer.write("Bonjour, monde!");
        } catch (IOException e) {
            System.out.println("Erreur d'écriture : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, `FileWriter` écrit des caractères dans un fichier.

---

## 4. Différences entre flux de bytes et flux de caractères

| **Flux de bytes**                      | **Flux de caractères**                   |
|----------------------------------------|------------------------------------------|
| Utilise les classes `InputStream` et `OutputStream`. | Utilise les classes `Reader` et `Writer`. |
| Conçu pour traiter des données binaires. | Conçu pour traiter des données textuelles. |
| Chaque byte est traité indépendamment.  | Les données sont traitées en tant que caractères. |

---

## 5. Utilisation des `BufferedReader` et `BufferedWriter`
Les classes **`BufferedReader`** et **`BufferedWriter`** sont des classes spécialisées qui améliorent les performances en fournissant un tampon (buffer) pour les lectures et écritures de données.

### Exemple avec `BufferedReader` :
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("exemple.txt"))) {
            String ligne;
            while ((ligne = bufferedReader.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }
    }
}
```

### Exemple avec `BufferedWriter` :
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sortie.txt"))) {
            bufferedWriter.write("Bonjour, monde!");
        } catch (IOException e) {
            System.out.println("Erreur d'écriture : " + e.getMessage());
        }
    }
}
```

Les classes `BufferedReader` et `BufferedWriter` permettent des lectures et écritures plus efficaces en limitant le nombre d'accès disque grâce à l'utilisation d'un tampon.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `FileInputStream` et `FileOutputStream`
1. Lisez le contenu d'un fichier binaire avec `FileInputStream`.
2. Écrivez les données lues dans un autre fichier en utilisant `FileOutputStream`.

### Exercice 2 : Lecture et écriture de fichiers texte
1. Lisez le contenu d'un fichier texte ligne par ligne avec `BufferedReader`.
2. Écrivez ce contenu dans un autre fichier avec `BufferedWriter`.

---

Ce cours vous a introduit aux différents types de flux en Java : les flux de bytes et les flux de caractères. Vous avez appris à utiliser `InputStream`, `OutputStream`, `Reader` et `Writer` pour lire et écrire des données. Les exercices vous permettront de pratiquer ces concepts et de mieux comprendre leur utilisation.
