
# Cours 33 : Lecteurs et écrivains de fichiers CSV, JSON, et XML en Java

## Objectifs :
- Apprendre à lire et écrire des fichiers CSV, JSON et XML en Java
- Comprendre les bibliothèques et outils couramment utilisés pour manipuler ces formats
- Découvrir les bonnes pratiques pour gérer ces fichiers dans vos applications Java

---

## 1. Manipulation de fichiers CSV

### 1.1 Lire un fichier CSV
Un fichier **CSV** (Comma-Separated Values) contient des données sous forme de texte, où chaque ligne représente un enregistrement et les valeurs sont séparées par des virgules (ou un autre séparateur).

### Exemple de lecture d'un fichier CSV :
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fichier = "exemple.csv";
        String ligne;
        String separateur = ",";

        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
            while ((ligne = reader.readLine()) != null) {
                String[] valeurs = ligne.split(separateur);  // Séparer les valeurs
                for (String valeur : valeurs) {
                    System.out.print(valeur + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }
}
```

Dans cet exemple, chaque ligne du fichier CSV est lue puis découpée en valeurs grâce à la méthode `split()`.

### 1.2 Écrire un fichier CSV
Pour écrire dans un fichier CSV, il suffit d'écrire chaque enregistrement sous forme de chaîne de texte où les valeurs sont séparées par des virgules.

### Exemple d'écriture d'un fichier CSV :
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fichier = "exemple.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            writer.write("Nom,Prenom,Age");
            writer.newLine();
            writer.write("Dupont,Jean,30");
            writer.newLine();
            writer.write("Durand,Marie,25");
        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans le fichier : " + e.getMessage());
        }
    }
}
```

---

## 2. Manipulation de fichiers JSON

### 2.1 Lire un fichier JSON
**JSON** (JavaScript Object Notation) est un format léger de données souvent utilisé pour échanger des informations. En Java, la bibliothèque **Jackson** ou **Gson** est couramment utilisée pour lire et écrire des fichiers JSON.

### Exemple avec la bibliothèque Jackson pour lire un fichier JSON :
```java
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Personne personne = mapper.readValue(new File("exemple.json"), Personne.class);
            System.out.println("Nom : " + personne.getNom());
            System.out.println("Prénom : " + personne.getPrenom());
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier JSON : " + e.getMessage());
        }
    }
}

class Personne {
    private String nom;
    private String prenom;

    // Getters et setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
}
```

### 2.2 Écrire un fichier JSON
La bibliothèque Jackson permet également d'écrire des objets Java sous forme de fichiers JSON.

### Exemple d'écriture d'un fichier JSON :
```java
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Personne personne = new Personne("Dupont", "Jean");
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("exemple.json"), personne);
        } catch (IOException e) {
            System.out.println("Erreur d'écriture dans le fichier JSON : " + e.getMessage());
        }
    }
}

class Personne {
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters et setters
}
```

---

## 3. Manipulation de fichiers XML

### 3.1 Lire un fichier XML
**XML** (eXtensible Markup Language) est un format de données souvent utilisé pour les configurations et les échanges de données. En Java, la bibliothèque **JAXB** (Java Architecture for XML Binding) est souvent utilisée pour manipuler les fichiers XML.

### Exemple de lecture d'un fichier XML avec JAXB :
```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Personne.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Personne personne = (Personne) unmarshaller.unmarshal(new File("exemple.xml"));
            System.out.println("Nom : " + personne.getNom());
            System.out.println("Prénom : " + personne.getPrenom());
        } catch (JAXBException e) {
            System.out.println("Erreur de lecture du fichier XML : " + e.getMessage());
        }
    }
}

class Personne {
    private String nom;
    private String prenom;

    // Getters et setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
}
```

### 3.2 Écrire un fichier XML
JAXB permet également de sérialiser un objet Java en fichier XML.

### Exemple d'écriture d'un fichier XML avec JAXB :
```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Personne.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Personne personne = new Personne("Dupont", "Jean");
            marshaller.marshal(personne, new File("exemple.xml"));
        } catch (JAXBException e) {
            System.out.println("Erreur d'écriture dans le fichier XML : " + e.getMessage());
        }
    }
}

class Personne {
    private String nom;
    private String prenom;

    public Personne() {}
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters et setters
}
```

---

## Exercices Pratiques

### Exercice 1 : Manipulation de fichiers CSV
1. Créez un programme qui lit un fichier CSV et affiche chaque enregistrement dans la console.
2. Créez un programme qui écrit plusieurs lignes dans un fichier CSV.

### Exercice 2 : Manipulation de fichiers JSON
1. Lisez un fichier JSON contenant des informations sur une personne et affichez les détails.
2. Écrivez un objet Java sous forme de fichier JSON.

### Exercice 3 : Manipulation de fichiers XML
1. Lisez un fichier XML contenant des informations sur une personne et affichez les détails.
2. Sérialisez un objet Java en fichier XML.

---

Ce cours vous a introduit à la lecture et l'écriture de fichiers CSV, JSON et XML en Java. Vous avez découvert les bibliothèques et méthodes courantes pour manipuler ces formats et appris à les intégrer dans vos programmes. Les exercices vous permettront de mettre en pratique ces concepts et de manipuler ces formats dans vos projets Java.
