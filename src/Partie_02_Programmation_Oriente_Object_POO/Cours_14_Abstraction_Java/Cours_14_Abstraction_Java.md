
# Cours 14 : Abstraction en Java (classes abstraites et interfaces)

## Objectifs :
- Comprendre le concept d'abstraction en Java
- Apprendre à utiliser les classes abstraites
- Découvrir l'utilisation des interfaces pour implémenter l'abstraction

---

## 1. Qu'est-ce que l'abstraction ?
L'**abstraction** est un principe de la programmation orientée objet qui permet de se concentrer sur les aspects essentiels d'un objet, tout en cachant les détails d'implémentation. L'abstraction en Java est réalisée à l'aide des **classes abstraites** et des **interfaces**.

---

## 2. Classes abstraites
Une **classe abstraite** est une classe qui ne peut pas être instanciée directement. Elle peut contenir des méthodes abstraites (non implémentées) ainsi que des méthodes concrètes (implémentées). Une classe abstraite sert de modèle pour d'autres classes qui doivent implémenter ses méthodes abstraites.

### Syntaxe :
```java
abstract class NomClasseAbstraite {
    // Méthode abstraite
    abstract void methodeAbstraite();

    // Méthode concrète
    void methodeConcree() {
        // Implémentation
    }
}
```

### Exemple de classe abstraite :
```java
abstract class Animal {
    String nom;

    // Méthode abstraite
    abstract void faireDuBruit();

    // Méthode concrète
    void dormir() {
        System.out.println(nom + " dort.");
    }
}

class Chien extends Animal {
    // Implémentation de la méthode abstraite
    void faireDuBruit() {
        System.out.println("Le chien aboie.");
    }
}

public class Main {
    public static void main(String[] args) {
        Chien monChien = new Chien();
        monChien.nom = "Rex";
        monChien.faireDuBruit();
        monChien.dormir();
    }
}
```

Dans cet exemple, la classe `Animal` est abstraite et contient une méthode abstraite `faireDuBruit()`. La classe `Chien` hérite de `Animal` et fournit une implémentation concrète de cette méthode.

---

## 3. Interfaces
Une **interface** est une forme plus stricte d'abstraction. Contrairement à une classe abstraite, une interface ne peut contenir que des déclarations de méthodes (jusqu'à Java 8, où des méthodes par défaut et statiques peuvent être ajoutées). Toutes les méthodes dans une interface sont implicitement abstraites.

### Syntaxe :
```java
interface NomInterface {
    void methodeAbstraite();
}
```

### Exemple d'interface :
```java
interface Volant {
    void voler();
}

class Avion implements Volant {
    public void voler() {
        System.out.println("L'avion vole.");
    }
}

class Oiseau implements Volant {
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}

public class Main {
    public static void main(String[] args) {
        Volant avion = new Avion();
        avion.voler();

        Volant oiseau = new Oiseau();
        oiseau.voler();
    }
}
```

Dans cet exemple, l'interface `Volant` est implémentée par les classes `Avion` et `Oiseau`. Chaque classe fournit sa propre implémentation de la méthode `voler()`.

---

## 4. Différences entre classes abstraites et interfaces
| **Caractéristique**      | **Classe abstraite**                                  | **Interface**                            |
|--------------------------|-------------------------------------------------------|------------------------------------------|
| Instanciation            | Ne peut pas être instanciée                           | Ne peut pas être instanciée              |
| Héritage                 | Une classe peut hériter d'une seule classe abstraite  | Une classe peut implémenter plusieurs interfaces |
| Méthodes                 | Peut contenir des méthodes abstraites et concrètes    | Ne peut contenir que des méthodes abstraites (jusqu'à Java 8) |
| Constructeurs            | Peut avoir un constructeur                            | Ne peut pas avoir de constructeur        |
| Mots-clés                | Utilise `abstract` pour déclarer une classe           | Utilise `interface` pour déclarer une interface |

---

## 5. Utilisation de `default` dans les interfaces (à partir de Java 8)
Depuis Java 8, il est possible de déclarer des méthodes par défaut dans une interface. Une méthode par défaut a une implémentation, mais elle peut être redéfinie par une classe qui implémente l'interface.

### Exemple :
```java
interface Volant {
    default void decoller() {
        System.out.println("Décollage en cours...");
    }

    void voler();
}

class Avion implements Volant {
    public void voler() {
        System.out.println("L'avion vole.");
    }
}

public class Main {
    public static void main(String[] args) {
        Avion avion = new Avion();
        avion.decoller();
        avion.voler();
    }
}
```

Dans cet exemple, la méthode `decoller()` est une méthode par défaut dans l'interface `Volant`, et elle est appelée sans être redéfinie dans la classe `Avion`.

---

## Exercices Pratiques

### Exercice 1 : Classe abstraite
1. Créez une classe abstraite `Vehicule` avec une méthode abstraite `deplacer()`.
2. Créez deux classes filles `Voiture` et `Bateau` qui héritent de `Vehicule` et implémentent la méthode `deplacer()`.
3. Dans la méthode `main()`, créez des objets `Voiture` et `Bateau`, et appelez leur méthode `deplacer()`.

### Exercice 2 : Interface
1. Créez une interface `Nageur` avec une méthode `nager()`.
2. Créez deux classes `Poisson` et `Humain` qui implémentent cette interface.
3. Dans la méthode `main()`, utilisez l'interface `Nageur` pour créer des objets `Poisson` et `Humain`, puis appelez leur méthode `nager()`.

### Exercice 3 : Méthode par défaut dans une interface
1. Créez une interface `AppareilElectrique` avec une méthode par défaut `allumer()` et une méthode abstraite `fonctionner()`.
2. Implémentez cette interface dans les classes `Ordinateur` et `Television`.
3. Dans la méthode `main()`, créez des objets `Ordinateur` et `Television`, et appelez les méthodes `allumer()` et `fonctionner()`.

---

Ce cours vous a présenté l'abstraction en Java à travers les classes abstraites et les interfaces, ainsi que leurs différences et leurs avantages. Les exercices vous permettront de pratiquer et de comprendre comment appliquer l'abstraction dans vos programmes.
