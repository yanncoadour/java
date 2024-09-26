
# Cours 15 : Méthodes et attributs statiques en Java

## Objectifs :
- Comprendre le concept de méthodes et attributs statiques en Java
- Apprendre à utiliser le mot-clé `static`
- Découvrir les avantages des méthodes et attributs statiques

---

## 1. Qu'est-ce qu'une méthode ou un attribut statique ?
En Java, une méthode ou un attribut **statique** appartient à la classe elle-même, et non aux instances de la classe. Cela signifie qu'il peut être utilisé sans créer d'objet de la classe.

- Un **attribut statique** est partagé par toutes les instances de la classe.
- Une **méthode statique** peut être appelée directement via la classe, sans créer d'objet.

Le mot-clé `static` est utilisé pour déclarer une méthode ou un attribut statique.

### Exemple :
```java
class Calculatrice {
    // Attribut statique
    static int nombreOperations = 0;

    // Méthode statique
    static int additionner(int a, int b) {
        nombreOperations++;
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        // Appel de la méthode statique sans créer d'objet
        int resultat = Calculatrice.additionner(5, 3);
        System.out.println("Résultat : " + resultat);
        System.out.println("Nombre d'opérations : " + Calculatrice.nombreOperations);
    }
}
```

Dans cet exemple, la méthode `additionner()` et l'attribut `nombreOperations` sont statiques. Ils peuvent être utilisés directement via la classe `Calculatrice` sans avoir besoin de créer un objet.

---

## 2. Attributs statiques
Un **attribut statique** est une variable qui appartient à la classe plutôt qu'à chaque objet de cette classe. Tous les objets partagent la même copie de l'attribut statique.

### Exemple :
```java
class Voiture {
    static int nombreDeVoitures = 0;  // Attribut statique
    String marque;

    Voiture(String marque) {
        this.marque = marque;
        nombreDeVoitures++;  // Incrémentation de l'attribut statique
    }
}

public class Main {
    public static void main(String[] args) {
        Voiture voiture1 = new Voiture("Toyota");
        Voiture voiture2 = new Voiture("Honda");

        // Affichage du nombre de voitures (attribut statique partagé)
        System.out.println("Nombre de voitures : " + Voiture.nombreDeVoitures);
    }
}
```

Dans cet exemple, l'attribut statique `nombreDeVoitures` est partagé par toutes les instances de la classe `Voiture`. Chaque fois qu'une nouvelle voiture est créée, cet attribut est incrémenté.

---

## 3. Méthodes statiques
Une **méthode statique** est une méthode qui appartient à la classe et non à une instance de la classe. Les méthodes statiques peuvent être appelées directement via le nom de la classe.

### Caractéristiques des méthodes statiques :
- Elles ne peuvent pas accéder aux attributs non statiques de la classe.
- Elles ne peuvent pas utiliser le mot-clé `this` car elles ne sont pas liées à une instance.

### Exemple :
```java
class MathUtil {
    // Méthode statique
    static int carre(int nombre) {
        return nombre * nombre;
    }
}

public class Main {
    public static void main(String[] args) {
        // Appel de la méthode statique
        int resultat = MathUtil.carre(4);
        System.out.println("Le carré de 4 est : " + resultat);
    }
}
```

Dans cet exemple, la méthode `carre()` est statique et peut être appelée directement via la classe `MathUtil` sans créer d'objet.

---

## 4. Avantages des méthodes et attributs statiques
- **Réutilisabilité** : Les méthodes statiques peuvent être appelées sans créer d'instances, ce qui permet de réutiliser des fonctions utilitaires.
- **Efficacité** : Les attributs statiques sont partagés entre toutes les instances, économisant ainsi de la mémoire.
- **Simplicité** : Pour des fonctionnalités qui ne dépendent pas d'instances, les méthodes et attributs statiques simplifient la conception du programme.

---

## 5. Limitations des méthodes statiques
- Les méthodes statiques ne peuvent pas accéder aux attributs ou méthodes non statiques de la classe.
- Elles ne peuvent pas être redéfinies dans une sous-classe.
- Elles ne peuvent pas utiliser le mot-clé `this` car elles ne sont pas liées à une instance.

---

## Exercices Pratiques

### Exercice 1 : Attribut statique
1. Créez une classe `Personne` avec un attribut statique `nombrePersonnes` qui compte combien d'objets `Personne` ont été créés.
2. Dans la méthode `main()`, créez plusieurs objets `Personne` et affichez la valeur de `nombrePersonnes`.

### Exercice 2 : Méthode statique
1. Créez une classe `MathUtil` avec une méthode statique `multiplier()` qui prend deux entiers en paramètre et retourne leur produit.
2. Dans la méthode `main()`, appelez la méthode `multiplier()` sans créer d'objet de la classe.

### Exercice 3 : Méthode et attribut statiques
1. Créez une classe `CompteBancaire` avec un attribut statique `nombreComptes` qui compte le nombre de comptes créés.
2. Ajoutez une méthode statique `afficherNombreComptes()` qui affiche la valeur de `nombreComptes`.
3. Dans la méthode `main()`, créez plusieurs objets `CompteBancaire` et appelez la méthode statique pour afficher le nombre de comptes.

---

Ce cours vous a présenté les méthodes et attributs statiques en Java, leur utilité et leurs limitations. Les exercices vous permettront de mettre en pratique ces concepts pour les comprendre en profondeur.
