
# Cours 30 : Sérialisation et désérialisation d'objets en Java

## Objectifs :
- Comprendre les concepts de sérialisation et de désérialisation d'objets en Java
- Apprendre à sérialiser des objets pour les enregistrer sous forme de données binaires
- Découvrir comment désérialiser des objets pour les restaurer depuis des fichiers ou d'autres sources

---

## 1. Qu'est-ce que la sérialisation ?
La **sérialisation** est le processus de conversion d'un objet Java en une séquence de bytes, afin qu'il puisse être stocké dans un fichier ou transmis sur un réseau. Cela permet de sauvegarder l'état de l'objet et de le restaurer plus tard. 

La **désérialisation** est l'opération inverse, qui consiste à reconstruire un objet à partir d'une séquence de bytes.

---

## 2. Sérialisation d'un objet en Java
Pour qu'un objet puisse être sérialisé, il doit implémenter l'interface **`Serializable`**. Cette interface ne contient aucune méthode ; elle est utilisée pour marquer une classe comme sérialisable.

### Exemple d'une classe sérialisable :
```java
import java.io.Serializable;

class Personne implements Serializable {
    private String nom;
    private int age;

    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personne[nom=" + nom + ", age=" + age + "]";
    }
}
```

Dans cet exemple, la classe `Personne` implémente `Serializable`, ce qui permet à ses instances d'être sérialisées.

---

## 3. Sérialiser un objet avec `ObjectOutputStream`
La classe **`ObjectOutputStream`** est utilisée pour sérialiser des objets et les écrire dans des fichiers ou d'autres flux de sortie.

### Exemple de sérialisation d'un objet dans un fichier :
```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Personne personne = new Personne("Alice", 30);

        try (FileOutputStream fileOut = new FileOutputStream("personne.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(personne);  // Sérialisation de l'objet
            System.out.println("L'objet a été sérialisé avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Dans cet exemple, l'objet `personne` est sérialisé et écrit dans un fichier `personne.ser`.

---

## 4. Désérialiser un objet avec `ObjectInputStream`
Pour désérialiser un objet, vous devez utiliser la classe **`ObjectInputStream`**, qui lit les bytes sérialisés et les reconvertit en objet.

### Exemple de désérialisation d'un objet depuis un fichier :
```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("personne.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Personne personne = (Personne) in.readObject();  // Désérialisation de l'objet
            System.out.println("L'objet désérialisé : " + personne);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

Dans cet exemple, l'objet `personne` est lu depuis le fichier `personne.ser` et reconstruit via la désérialisation.

---

## 5. Transitoire et sérialisation
Si vous ne souhaitez pas que certains attributs d'un objet soient sérialisés, vous pouvez les marquer avec le mot-clé **`transient`**. Cela signifie que ces attributs seront ignorés lors de la sérialisation.

### Exemple avec un attribut `transient` :
```java
import java.io.Serializable;

class Personne implements Serializable {
    private String nom;
    private int age;
    transient private String motDePasse;  // Ne sera pas sérialisé

    public Personne(String nom, int age, String motDePasse) {
        this.nom = nom;
        this.age = age;
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Personne[nom=" + nom + ", age=" + age + ", motDePasse=" + motDePasse + "]";
    }
}
```

Dans cet exemple, l'attribut `motDePasse` est marqué comme `transient`, donc il ne sera pas sauvegardé lors de la sérialisation.

---

## 6. Gestion des versions avec `serialVersionUID`
Chaque classe sérialisable possède un identifiant appelé **`serialVersionUID`**, qui est utilisé pour vérifier la compatibilité entre les versions d'une classe lors de la désérialisation. Si la classe a changé et que le `serialVersionUID` ne correspond pas, une erreur de désérialisation peut se produire.

### Exemple d'utilisation de `serialVersionUID` :
```java
class Personne implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nom;
    private int age;

    // Constructeurs, getters, setters, etc.
}
```

Il est recommandé de définir explicitement `serialVersionUID` pour éviter les erreurs de compatibilité entre les versions d'une classe.

---

## 7. Bonnes pratiques pour la sérialisation
1. **Marquez les objets comme `Serializable`** : Assurez-vous que toutes les classes que vous souhaitez sérialiser implémentent `Serializable`.
2. **Utilisez `transient` pour les attributs sensibles** : Marquez les informations sensibles comme les mots de passe ou les données temporaires avec `transient` pour qu'elles ne soient pas sérialisées.
3. **Définissez `serialVersionUID`** : Assurez-vous de définir un `serialVersionUID` pour contrôler la version de vos classes et éviter des problèmes de compatibilité.

---

## Exercices Pratiques

### Exercice 1 : Sérialisation et désérialisation d'un objet
1. Créez une classe `Etudiant` qui implémente `Serializable`.
2. Sérialisez une instance de `Etudiant` dans un fichier.
3. Désérialisez l'objet et affichez ses détails.

### Exercice 2 : Utilisation du mot-clé `transient`
1. Ajoutez un attribut `motDePasse` à la classe `Etudiant`.
2. Marquez cet attribut comme `transient` et vérifiez qu'il n'est pas sérialisé.

---

Ce cours vous a introduit aux concepts de sérialisation et de désérialisation en Java. Vous avez appris à sérialiser et désérialiser des objets à l'aide de `ObjectOutputStream` et `ObjectInputStream`, ainsi que les bonnes pratiques associées à la gestion des attributs sensibles et des versions de classes. Les exercices vous permettront de mettre en pratique ces concepts.
