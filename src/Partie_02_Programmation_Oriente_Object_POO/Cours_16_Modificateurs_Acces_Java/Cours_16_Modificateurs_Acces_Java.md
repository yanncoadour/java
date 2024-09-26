
# Cours 16 : Modificateurs d'accès en Java (public, private, protected)

## Objectifs :
- Comprendre le rôle des modificateurs d'accès en Java
- Apprendre à utiliser les modificateurs `public`, `private`, et `protected`
- Découvrir comment contrôler l'accès aux attributs et méthodes d'une classe

---

## 1. Qu'est-ce qu'un modificateur d'accès ?
Les **modificateurs d'accès** en Java permettent de contrôler la visibilité des attributs, méthodes et classes d'un programme. Ils définissent qui peut accéder à ces éléments, qu'il s'agisse de la classe elle-même, d'autres classes du même package, ou même de classes externes.

Java dispose de trois principaux modificateurs d'accès :
- `public`
- `private`
- `protected`

Il existe également un **modificateur d'accès par défaut** (aucun modificateur), qui est utilisé lorsqu'aucun autre modificateur n'est spécifié.

---

## 2. Le modificateur `public`
Lorsque vous utilisez le mot-clé **`public`**, l'attribut, la méthode ou la classe est accessible depuis n'importe quelle autre classe, quel que soit son package.

### Exemple :
```java
class Personne {
    public String nom;

    public void direBonjour() {
        System.out.println("Bonjour, je m'appelle " + nom);
    }
}

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne();
        p.nom = "Alice";
        p.direBonjour();
    }
}
```

Dans cet exemple, l'attribut `nom` et la méthode `direBonjour()` sont publics, donc accessibles depuis la classe `Main`.

---

## 3. Le modificateur `private`
Le modificateur **`private`** signifie que l'attribut ou la méthode n'est accessible que dans la classe où il est défini. Il est utilisé pour **protéger** les données et éviter qu'elles ne soient modifiées directement par d'autres classes.

### Exemple :
```java
class Personne {
    private String nom;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void direBonjour() {
        System.out.println("Bonjour, je m'appelle " + nom);
    }
}

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne();
        // p.nom = "Alice";  // Erreur, l'attribut est privé
        p.setNom("Alice");  // Correct, utilisation du setter
        p.direBonjour();
    }
}
```

Dans cet exemple, l'attribut `nom` est privé et ne peut pas être modifié directement depuis la classe `Main`. Le setter `setNom()` est utilisé pour modifier sa valeur.

---

## 4. Le modificateur `protected`
Le modificateur **`protected`** permet de rendre un attribut ou une méthode accessible :
- à la classe elle-même,
- aux classes du même package,
- et aux sous-classes (même si elles se trouvent dans un autre package).

### Exemple :
```java
class Animal {
    protected String nom;

    protected void faireDuBruit() {
        System.out.println(nom + " fait du bruit.");
    }
}

class Chien extends Animal {
    public void aboyer() {
        nom = "Rex";
        faireDuBruit();  // Accessible car Chien est une sous-classe
        System.out.println("Le chien aboie.");
    }
}

public class Main {
    public static void main(String[] args) {
        Chien chien = new Chien();
        chien.aboyer();
    }
}
```

Dans cet exemple, l'attribut `nom` et la méthode `faireDuBruit()` sont protégés et peuvent être utilisés dans la classe `Chien`, qui hérite de `Animal`.

---

## 5. Accès par défaut (sans modificateur)
Lorsque vous ne spécifiez pas de modificateur d'accès, l'accès est restreint au package. Cela signifie que l'attribut ou la méthode est accessible aux autres classes du même package, mais pas à celles qui sont en dehors du package.

### Exemple :
```java
class Personne {
    String nom;  // Modificateur d'accès par défaut

    void direBonjour() {
        System.out.println("Bonjour, je m'appelle " + nom);
    }
}

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne();
        p.nom = "Alice";  // Accessible car dans le même package
        p.direBonjour();
    }
}
```

---

## 6. Résumé des modificateurs d'accès

| Modificateur | Classe | Package | Sous-classe | Monde extérieur |
|--------------|--------|---------|-------------|-----------------|
| `public`     | Oui    | Oui     | Oui         | Oui             |
| `protected`  | Oui    | Oui     | Oui         | Non             |
| Aucun (par défaut) | Oui    | Oui     | Non         | Non             |
| `private`    | Oui    | Non     | Non         | Non             |

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `public` et `private`
1. Créez une classe `CompteBancaire` avec un attribut privé `solde`.
2. Déclarez des méthodes publiques pour déposer et retirer de l'argent.
3. Dans la méthode `main()`, créez un compte bancaire, déposez de l'argent, retirez de l'argent et affichez le solde.

### Exercice 2 : Utilisation de `protected`
1. Créez une classe `Vehicule` avec un attribut protégé `vitesseMax`.
2. Créez une classe fille `Moto` qui hérite de `Vehicule` et implémente une méthode pour afficher la vitesse maximale.
3. Dans la méthode `main()`, créez un objet `Moto` et affichez la vitesse maximale.

### Exercice 3 : Accès par défaut
1. Créez deux classes dans le même package, `Personne` et `Employe`.
2. Dans la classe `Personne`, déclarez un attribut sans modificateur et affichez-le dans la classe `Employe`.
3. Testez l'accès à cet attribut depuis une classe d'un autre package.

---

Ce cours vous a présenté les modificateurs d'accès en Java (`public`, `private`, `protected`) et comment les utiliser pour contrôler l'accès aux attributs et méthodes d'une classe. Les exercices vous aideront à mettre en pratique ces concepts.
