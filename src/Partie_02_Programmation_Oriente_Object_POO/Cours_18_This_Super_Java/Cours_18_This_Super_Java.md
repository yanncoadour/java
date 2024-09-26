
# Cours 18 : Les mots-clés `this` et `super` en Java

## Objectifs :
- Comprendre le rôle du mot-clé `this` en Java
- Apprendre à utiliser le mot-clé `super` pour accéder aux membres de la classe parente
- Découvrir comment utiliser `this` et `super` dans des constructeurs et méthodes

---

## 1. Le mot-clé `this`
Le mot-clé **`this`** fait référence à l'instance actuelle d'une classe. Il est utilisé pour différencier les attributs d'une classe des paramètres d'une méthode ou d'un constructeur, ou pour appeler une méthode ou un constructeur de la même classe.

### Utilisation principale de `this` :
1. **Accéder aux attributs** : Lorsque les paramètres d'une méthode ou d'un constructeur ont le même nom que les attributs, `this` permet de référencer les attributs de la classe.

2. **Appeler un constructeur** : `this()` peut être utilisé pour appeler un autre constructeur de la même classe.

### Exemple de `this` pour accéder aux attributs :
```java
class Personne {
    private String nom;
    private int age;

    public Personne(String nom, int age) {
        this.nom = nom;  // Utilisation de 'this' pour accéder à l'attribut 'nom'
        this.age = age;
    }

    public void afficherDetails() {
        System.out.println("Nom : " + this.nom + ", Âge : " + this.age);
    }
}

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne("Alice", 25);
        p.afficherDetails();
    }
}
```

### Exemple de `this()` pour appeler un constructeur :
```java
class Personne {
    private String nom;
    private int age;

    // Constructeur principal
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Constructeur secondaire qui appelle le constructeur principal
    public Personne() {
        this("Inconnu", 0);  // Appel du constructeur principal avec 'this()'
    }

    public void afficherDetails() {
        System.out.println("Nom : " + this.nom + ", Âge : " + this.age);
    }
}

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne();
        p.afficherDetails();
    }
}
```

---

## 2. Le mot-clé `super`
Le mot-clé **`super`** est utilisé pour faire référence à la classe parente d'une classe. Il permet d'accéder aux méthodes et attributs de la classe parente, et d'appeler son constructeur.

### Utilisation principale de `super` :
1. **Accéder aux méthodes de la classe parente** : Vous pouvez utiliser `super` pour appeler une méthode redéfinie dans la classe parente.
2. **Appeler le constructeur de la classe parente** : Le mot-clé `super()` peut être utilisé pour appeler le constructeur de la classe parente depuis un constructeur de la classe fille.

### Exemple de `super` pour appeler une méthode de la classe parente :
```java
class Animal {
    public void faireDuBruit() {
        System.out.println("L'animal fait du bruit.");
    }
}

class Chien extends Animal {
    @Override
    public void faireDuBruit() {
        super.faireDuBruit();  // Appel de la méthode de la classe parente
        System.out.println("Le chien aboie.");
    }
}

public class Main {
    public static void main(String[] args) {
        Chien chien = new Chien();
        chien.faireDuBruit();
    }
}
```

### Exemple de `super()` pour appeler un constructeur de la classe parente :
```java
class Animal {
    private String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public void afficherNom() {
        System.out.println("Nom : " + this.nom);
    }
}

class Chien extends Animal {
    private String race;

    public Chien(String nom, String race) {
        super(nom);  // Appel du constructeur de la classe parente
        this.race = race;
    }

    public void afficherDetails() {
        super.afficherNom();  // Appel de la méthode de la classe parente
        System.out.println("Race : " + this.race);
    }
}

public class Main {
    public static void main(String[] args) {
        Chien chien = new Chien("Rex", "Berger Allemand");
        chien.afficherDetails();
    }
}
```

---

## 3. Différences entre `this` et `super`
| **`this`**                         | **`super`**                          |
|------------------------------------|--------------------------------------|
| Fait référence à l'instance actuelle de la classe. | Fait référence à la classe parente. |
| Utilisé pour accéder aux membres (attributs, méthodes) de la classe actuelle. | Utilisé pour accéder aux membres de la classe parente. |
| Peut être utilisé pour appeler un autre constructeur de la même classe. | Peut être utilisé pour appeler le constructeur de la classe parente. |

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `this`
1. Créez une classe `Produit` avec des attributs `nom` et `prix`.
2. Utilisez `this` dans le constructeur pour initialiser les attributs.
3. Dans la méthode `main()`, créez un objet `Produit` et affichez ses détails.

### Exercice 2 : Utilisation de `super`
1. Créez une classe `Vehicule` avec un attribut `marque` et une méthode `afficherMarque()`.
2. Créez une classe fille `Voiture` avec un attribut supplémentaire `modele`.
3. Utilisez `super()` dans le constructeur de `Voiture` pour initialiser `marque` et `modele`.
4. Affichez les détails de la voiture dans la méthode `main()`.

### Exercice 3 : Combiner `this` et `super`
1. Créez une classe `Employe` avec un attribut `nom` et une méthode pour afficher le nom.
2. Créez une classe fille `Manager` avec un attribut supplémentaire `departement`.
3. Utilisez `super()` pour initialiser le nom et `this` pour initialiser le département.
4. Affichez les détails dans la méthode `main()`.

---

Ce cours vous a présenté les mots-clés `this` et `super` en Java, ainsi que leurs différences et leurs utilisations dans les constructeurs et les méthodes. Les exercices vous aideront à mettre en pratique ces concepts pour bien comprendre leur fonctionnement.
