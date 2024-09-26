
# Cours 46 : Références de méthode en Java

## Objectifs :
- Comprendre ce qu'est une référence de méthode en Java
- Apprendre à utiliser les références de méthode pour simplifier les expressions lambda
- Découvrir les différents types de références de méthode disponibles

---

## 1. Qu'est-ce qu'une référence de méthode ?
Une **référence de méthode** est une forme plus concise d'une expression lambda qui appelle une méthode existante. Plutôt que d'écrire une expression lambda complète pour appeler une méthode, vous pouvez utiliser la référence directe à cette méthode. Cela améliore la lisibilité et simplifie le code.

### Syntaxe d'une référence de méthode :
```
Classe::méthode
```

---

## 2. Types de références de méthode
Il existe quatre types principaux de références de méthode en Java :

1. Référence à une méthode statique
2. Référence à une méthode d'instance sur un objet particulier
3. Référence à une méthode d'instance sur un objet arbitraire d'un type particulier
4. Référence à un constructeur

---

## 3. Référence à une méthode statique
Une **référence à une méthode statique** se réfère à une méthode statique d'une classe. C'est l'équivalent d'une expression lambda qui appelle cette méthode statique.

### Exemple avec une méthode statique :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void afficherMajuscules(String s) {
        System.out.println(s.toUpperCase());
    }

    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");

        // Référence à une méthode statique
        noms.forEach(Main::afficherMajuscules);
    }
}
```

Dans cet exemple, `Main::afficherMajuscules` est une référence à la méthode statique `afficherMajuscules`.

---

## 4. Référence à une méthode d'instance sur un objet particulier
Une **référence à une méthode d'instance sur un objet particulier** fait référence à une méthode d'instance d'un objet spécifique.

### Exemple avec une méthode d'instance sur un objet particulier :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public void afficher(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        Main main = new Main();

        // Référence à une méthode d'instance sur un objet particulier
        noms.forEach(main::afficher);
    }
}
```

Dans cet exemple, `main::afficher` est une référence à la méthode d'instance `afficher` de l'objet `main`.

---

## 5. Référence à une méthode d'instance sur un objet arbitraire d'un type particulier
Une **référence à une méthode d'instance sur un objet arbitraire** fait référence à une méthode d'instance sur un objet qui sera fourni à l'exécution. Il est utilisé en association avec des types de données spécifiques.

### Exemple avec une méthode d'instance sur un objet arbitraire :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");

        // Référence à une méthode d'instance sur un objet arbitraire
        noms.forEach(String::toUpperCase);
    }
}
```

Dans cet exemple, `String::toUpperCase` est une référence à la méthode d'instance `toUpperCase()` qui sera appliquée à chaque élément de la liste.

---

## 6. Référence à un constructeur
Une **référence à un constructeur** est utilisée pour appeler un constructeur d'une classe. Cela est utile lorsque vous devez créer des objets dans un contexte de programmation fonctionnelle.

### Exemple avec une référence à un constructeur :
```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Personne {
    private String nom;

    public Personne() {
        this.nom = "Inconnu";
    }

    public String getNom() {
        return nom;
    }

    public static void main(String[] args) {
        // Référence à un constructeur
        Supplier<Personne> fournisseur = Personne::new;
        Personne personne = fournisseur.get();
        System.out.println("Nom : " + personne.getNom());
    }
}
```

Dans cet exemple, `Personne::new` est une référence au constructeur par défaut de la classe `Personne`.

---

## 7. Comparaison avec les expressions lambda
Les références de méthode sont souvent utilisées pour simplifier les expressions lambda lorsque celles-ci se contentent d'appeler une méthode existante.

### Exemple de comparaison :
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");

        // Avec une expression lambda
        noms.forEach(nom -> System.out.println(nom));

        // Avec une référence de méthode
        noms.forEach(System.out::println);
    }
}
```

Dans cet exemple, la référence de méthode `System.out::println` remplace l'expression lambda `nom -> System.out.println(nom)`.

---

## 8. Bonnes pratiques avec les références de méthode
1. **Privilégier les références de méthode lorsque possible** : Les références de méthode sont plus lisibles et concises que les expressions lambda, surtout lorsqu'il s'agit simplement d'appeler une méthode existante.
2. **Utiliser les références de méthode avec des streams** : Les références de méthode sont particulièrement utiles avec l'API Stream pour transformer et filtrer des données de manière concise.
3. **Éviter les références de méthode dans des cas complexes** : Si l'utilisation d'une référence de méthode rend le code moins clair, préférez une expression lambda plus explicite.

---

## Exercices Pratiques

### Exercice 1 : Référence à une méthode statique
1. Créez une méthode statique qui prend un entier en paramètre et l'affiche.
2. Utilisez une référence de méthode pour appliquer cette méthode à une liste d'entiers.

### Exercice 2 : Référence à un constructeur
1. Créez une classe `Produit` avec un constructeur par défaut.
2. Utilisez une référence à un constructeur pour créer des instances de `Produit` dans une liste.

---

Ce cours vous a introduit aux références de méthode en Java, qui permettent de simplifier les expressions lambda lorsque vous avez simplement besoin d'appeler une méthode existante. Vous avez appris à utiliser les quatre types de références de méthode disponibles et à les appliquer dans différents contextes. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
