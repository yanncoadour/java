
# Cours 11 : Héritage en Java

## Objectifs :
- Comprendre le concept d'héritage en Java
- Apprendre à créer des classes qui héritent d'autres classes
- Découvrir l'utilisation du mot-clé `super` pour accéder aux membres de la classe parente

---

## 1. Qu'est-ce que l'héritage ?
L'**héritage** est un mécanisme en programmation orientée objet qui permet à une classe de dériver (ou hériter) d'une autre classe. La classe dérivée (ou **classe fille**) hérite des attributs et des méthodes de la classe d'origine (ou **classe parente**), ce qui permet de réutiliser du code existant.

### Syntaxe :
```java
class ClasseFille extends ClasseParente {
    // Code de la classe fille
}
```

L'héritage permet de créer une hiérarchie entre les classes, où une classe fille peut ajouter ses propres attributs et méthodes en plus de ceux hérités de la classe parente.

---

## 2. Exemple d'héritage simple
Voici un exemple d'héritage où la classe `Chien` hérite de la classe `Animal`.

```java
class Animal {
    String nom;

    void manger() {
        System.out.println(nom + " est en train de manger.");
    }
}

class Chien extends Animal {
    void aboyer() {
        System.out.println(nom + " aboie !");
    }
}

public class Main {
    public static void main(String[] args) {
        Chien monChien = new Chien();
        monChien.nom = "Rex";
        monChien.manger();  // Méthode héritée de la classe Animal
        monChien.aboyer();  // Méthode spécifique à la classe Chien
    }
}
```

Dans cet exemple, la classe `Chien` hérite de l'attribut `nom` et de la méthode `manger()` de la classe `Animal`, et elle ajoute sa propre méthode `aboyer()`.

---

## 3. Utilisation du mot-clé `super`
Le mot-clé `super` est utilisé pour faire référence à la classe parente. Il peut être utilisé pour :
- Appeler le constructeur de la classe parente.
- Accéder aux attributs et méthodes de la classe parente.

### Exemple avec `super` :
```java
class Animal {
    String nom;

    Animal(String nom) {
        this.nom = nom;
    }

    void manger() {
        System.out.println(nom + " mange.");
    }
}

class Chien extends Animal {
    Chien(String nom) {
        super(nom);  // Appel du constructeur de la classe parente
    }

    void aboyer() {
        System.out.println(nom + " aboie !");
    }
}

public class Main {
    public static void main(String[] args) {
        Chien monChien = new Chien("Rex");
        monChien.manger();  // Appel de la méthode héritée de Animal
        monChien.aboyer();  // Appel de la méthode spécifique à Chien
    }
}
```

Dans cet exemple, le mot-clé `super` est utilisé dans le constructeur de `Chien` pour appeler le constructeur de la classe parente `Animal`.

---

## 4. Héritage et polymorphisme
L'héritage permet également d'utiliser le **polymorphisme**, où une classe fille peut être traitée comme si elle était une instance de sa classe parente.

### Exemple de polymorphisme :
```java
class Animal {
    void faireDuBruit() {
        System.out.println("L'animal fait du bruit.");
    }
}

class Chien extends Animal {
    @Override
    void faireDuBruit() {
        System.out.println("Le chien aboie.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal monAnimal = new Chien();  // Polymorphisme
        monAnimal.faireDuBruit();  // Le chien aboie
    }
}
```

---

## 5. Classe finale
En Java, il est possible d'empêcher une classe d'être héritée en utilisant le mot-clé `final`.

### Exemple de classe finale :
```java
final class Animal {
    // Cette classe ne peut pas être héritée
}
```

---

## Exercices Pratiques

### Exercice 1 : Héritage simple
1. Créez une classe `Personne` avec les attributs `nom` et `age`.
2. Créez une classe `Etudiant` qui hérite de `Personne` et ajoute l'attribut `niveau`.
3. Dans la méthode `main()`, créez un objet `Etudiant` et affichez ses informations.

### Exercice 2 : Utilisation de `super`
1. Modifiez la classe `Personne` pour y ajouter un constructeur qui initialise `nom` et `age`.
2. Utilisez le mot-clé `super` dans le constructeur de `Etudiant` pour initialiser les attributs `nom` et `age`.
3. Affichez les informations de l'étudiant.

### Exercice 3 : Polymorphisme
1. Créez une classe `Animal` avec une méthode `faireDuBruit()`.
2. Créez deux classes filles `Chien` et `Chat` qui redéfinissent cette méthode.
3. Utilisez le polymorphisme dans la méthode `main()` pour traiter un `Chien` et un `Chat` comme des `Animal`.

---

Ce cours vous a présenté les concepts d'héritage en Java, ainsi que l'utilisation du mot-clé `super` et l'importance du polymorphisme. Les exercices vous permettront de pratiquer ces notions fondamentales de la programmation orientée objet.
