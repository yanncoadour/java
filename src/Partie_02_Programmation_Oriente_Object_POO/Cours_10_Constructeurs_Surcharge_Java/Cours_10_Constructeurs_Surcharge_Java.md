
# Cours 10 : Constructeurs et surcharge en Java

## Objectifs :
- Comprendre le rôle des constructeurs en Java
- Apprendre à utiliser et créer des constructeurs
- Découvrir la surcharge des constructeurs et son utilité

---

## 1. Qu'est-ce qu'un constructeur ?
Un **constructeur** est une méthode spéciale qui est appelée automatiquement lorsque vous créez un objet à partir d'une classe. Il sert à initialiser les attributs de l'objet.

### Caractéristiques d'un constructeur :
- Le constructeur porte toujours le même nom que la classe.
- Il n'a pas de type de retour, pas même `void`.
- Il est appelé automatiquement lors de la création d'un objet avec `new`.

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

Dans cet exemple, le constructeur `Voiture()` est utilisé pour initialiser les attributs `marque`, `modele` et `annee` lors de la création d'un objet.

---

## 2. Constructeur par défaut
Si vous ne définissez pas de constructeur dans une classe, Java fournit automatiquement un **constructeur par défaut**. Ce constructeur ne prend aucun paramètre et n'initialise pas les attributs.

### Exemple de constructeur par défaut :
```java
class Voiture {
    String marque;
    String modele;
    int annee;
}

public class Main {
    public static void main(String[] args) {
        Voiture maVoiture = new Voiture();  // Appel du constructeur par défaut
        maVoiture.marque = "Toyota";
        maVoiture.modele = "Corolla";
        maVoiture.annee = 2020;
        System.out.println(maVoiture.marque + " " + maVoiture.modele + " (" + maVoiture.annee + ")");
    }
}
```

---

## 3. Surcharge des constructeurs
La **surcharge des constructeurs** permet d'avoir plusieurs constructeurs dans une même classe, chacun acceptant un nombre différent de paramètres. Cela permet d'offrir plusieurs façons de créer un objet.

### Exemple de surcharge de constructeurs :
```java
class Voiture {
    String marque;
    String modele;
    int annee;

    // Constructeur sans paramètres
    Voiture() {
        this.marque = "Inconnue";
        this.modele = "Inconnu";
        this.annee = 0;
    }

    // Constructeur avec paramètres
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
        Voiture voiture1 = new Voiture();  // Appel du constructeur sans paramètres
        voiture1.afficherDetails();

        Voiture voiture2 = new Voiture("Honda", "Civic", 2021);  // Appel du constructeur avec paramètres
        voiture2.afficherDetails();
    }
}
```

Dans cet exemple, la classe `Voiture` a deux constructeurs : un sans paramètres et un avec des paramètres. Cela permet de créer un objet avec ou sans fournir de valeurs initiales.

---

## 4. Utilisation de `this()` dans les constructeurs
Vous pouvez utiliser `this()` pour appeler un autre constructeur depuis un constructeur. Cela est utile pour éviter de répéter du code.

### Exemple :
```java
class Voiture {
    String marque;
    String modele;
    int annee;

    // Constructeur principal
    Voiture(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    // Appel du constructeur principal
    Voiture() {
        this("Inconnue", "Inconnu", 0);
    }

    void afficherDetails() {
        System.out.println(marque + " " + modele + " (" + annee + ")");
    }
}
```

---

## Exercices Pratiques

### Exercice 1 : Constructeur simple
1. Créez une classe nommée `Personne` avec les attributs `nom` et `age`.
2. Déclarez un constructeur qui initialise ces attributs.
3. Dans la méthode `main()`, créez un objet `Personne` en passant un nom et un âge, et affichez ces informations.

### Exercice 2 : Constructeur par défaut
1. Modifiez la classe `Personne` pour ajouter un constructeur par défaut qui initialise le nom à "Inconnu" et l'âge à 0.
2. Dans la méthode `main()`, créez un objet à l'aide du constructeur par défaut et affichez ses informations.

### Exercice 3 : Surcharge de constructeurs
1. Créez une classe nommée `Rectangle` avec les attributs `largeur` et `hauteur`.
2. Déclarez deux constructeurs : un sans paramètres qui initialise les dimensions à 1, et un autre qui accepte des valeurs pour la largeur et la hauteur.
3. Créez des objets `Rectangle` en utilisant les deux constructeurs et affichez les dimensions.

---

Ce cours vous a présenté les concepts des constructeurs et de la surcharge en Java. Vous avez appris comment initialiser des objets à l'aide de constructeurs et comment fournir plusieurs options de création grâce à la surcharge. Les exercices vous aideront à mettre en pratique ces concepts.
