
# Cours 9 : Classes, Objets et Instances en Java

## Objectifs :
- Comprendre la notion de classe et d'objet en Java
- Apprendre à créer des objets à partir d'une classe
- Découvrir comment utiliser des instances dans un programme Java

---

## 1. Qu'est-ce qu'une classe ?
Une **classe** est un modèle ou un plan qui définit les attributs (données) et les méthodes (comportements) d'un objet. En d'autres termes, une classe est une représentation abstraite des caractéristiques d'un objet dans le monde réel.

### Syntaxe :
```java
class NomDeLaClasse {
    // Attributs (ou propriétés)
    // Méthodes (ou comportements)
}
```

### Exemple :
```java
class Voiture {
    String marque;
    String modele;
    int annee;

    void demarrer() {
        System.out.println("La voiture démarre.");
    }

    void arreter() {
        System.out.println("La voiture s'arrête.");
    }
}
```

---

## 2. Qu'est-ce qu'un objet ?
Un **objet** est une instance d'une classe. Autrement dit, lorsqu'une classe est définie, vous pouvez créer plusieurs objets (instances) de cette classe. Chaque objet a ses propres valeurs pour les attributs définis par la classe.

### Exemple de création d'objet :
```java
public class Main {
    public static void main(String[] args) {
        // Création d'un objet de la classe Voiture
        Voiture maVoiture = new Voiture();
        maVoiture.marque = "Toyota";
        maVoiture.modele = "Corolla";
        maVoiture.annee = 2020;

        // Appel de la méthode de l'objet
        maVoiture.demarrer();
    }
}
```

Dans cet exemple, `maVoiture` est un objet (instance) de la classe `Voiture`.

---

## 3. Les attributs d'une classe
Les **attributs** d'une classe sont des variables qui décrivent les propriétés ou les caractéristiques de cette classe. Chaque objet créé à partir de cette classe peut avoir des valeurs différentes pour ses attributs.

### Exemple :
```java
class Personne {
    String nom;
    int age;
}
```

Dans cet exemple, la classe `Personne` a deux attributs : `nom` et `age`.

---

## 4. Les méthodes d'une classe
Les **méthodes** d'une classe définissent les actions ou comportements que les objets de cette classe peuvent effectuer.

### Exemple :
```java
class Personne {
    String nom;
    int age;

    void saluer() {
        System.out.println("Bonjour, je m'appelle " + nom);
    }
}
```

Dans cet exemple, la méthode `saluer()` affiche un message utilisant l'attribut `nom`.

---

## 5. Constructeurs
Un **constructeur** est une méthode spéciale qui est utilisée pour initialiser un objet lorsqu'il est créé. Le constructeur a le même nom que la classe et n'a pas de type de retour.

### Exemple de constructeur :
```java
class Voiture {
    String marque;
    String modele;
    int annee;

    // Constructeur
    Voiture(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    void afficherDetails() {
        System.out.println(marque + " " + modele + " (" + annee + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        Voiture maVoiture = new Voiture("Toyota", "Corolla", 2020);
        maVoiture.afficherDetails();
    }
}
```

---

## Exercices Pratiques

### Exercice 1 : Création d'une classe et d'un objet
1. Créez une classe nommée `Animal` avec deux attributs : `nom` et `espece`.
2. Ajoutez une méthode `decrire()` qui affiche le nom et l'espèce de l'animal.
3. Dans la méthode `main()`, créez un objet de la classe `Animal` et appelez la méthode `decrire()`.

### Exercice 2 : Utilisation d'un constructeur
1. Modifiez la classe `Animal` pour y ajouter un constructeur qui initialise les attributs `nom` et `espece`.
2. Créez un objet dans la méthode `main()` en utilisant le constructeur et appelez la méthode `decrire()`.

### Exercice 3 : Méthodes d'une classe
1. Créez une classe nommée `CompteBancaire` avec un attribut `solde`.
2. Ajoutez une méthode `deposer()` qui permet d'ajouter de l'argent au solde.
3. Ajoutez une méthode `retirer()` qui permet de retirer de l'argent.
4. Créez un objet `CompteBancaire` dans la méthode `main()`, déposez et retirez de l'argent, et affichez le solde après chaque opération.

---

Ce cours vous a introduit aux concepts fondamentaux des classes, des objets, et des instances en Java. Vous avez appris à créer des classes, à instancier des objets et à utiliser des constructeurs. Les exercices vous permettront de pratiquer ces concepts essentiels.
