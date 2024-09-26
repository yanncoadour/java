
# Cours 1 : Introduction à la Programmation Orientée Objet (POO) en Java

## Objectifs :
- Comprendre les principes fondamentaux de la POO
- Découvrir les concepts de classes et d'objets
- Appréhender les avantages de la POO par rapport à la programmation procédurale

---

## 1. Qu'est-ce que la Programmation Orientée Objet (POO) ?
La programmation orientée objet est un paradigme de programmation qui repose sur l'organisation du code en **objets**. Un objet est une instance d'une **classe**, qui peut contenir des attributs (données) et des méthodes (comportements). La POO vise à mieux structurer et réutiliser le code, et à modéliser des entités du monde réel.

Les principaux concepts de la POO sont :
- **Encapsulation** : Protéger les données en restreignant leur accès via des méthodes publiques.
- **Héritage** : Permettre à une classe de dériver d'une autre classe, en héritant de ses attributs et méthodes.
- **Polymorphisme** : Capacité d'une méthode ou d'un objet à se comporter différemment selon le contexte.
- **Abstraction** : Simplifier la complexité en cachant les détails d'implémentation.

---

## 2. Classe et Objet
En Java, une classe est un plan ou un modèle à partir duquel des objets peuvent être créés. Un objet est une instance d'une classe et représente une entité du monde réel.

### Exemple de classe :
```java
class Voiture {
    // Attributs de la classe Voiture
    String marque;
    String modele;
    int annee;

    // Constructeur de la classe Voiture
    Voiture(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    // Méthode pour afficher les informations de la voiture
    void afficherInfos() {
        System.out.println("Marque: " + this.marque + ", Modèle: " + this.modele + ", Année: " + this.annee);
    }
}
```

### Exemple de création d'objet :
```java
public class Main {
    public static void main(String[] args) {
        // Création d'un objet voiture
        Voiture maVoiture = new Voiture("Toyota", "Corolla", 2020);
        // Appel d'une méthode sur l'objet
        maVoiture.afficherInfos();
    }
}
```

---

## 3. Encapsulation
L'encapsulation consiste à protéger les données en utilisant des modificateurs d'accès, comme `private` pour rendre les attributs d'une classe non accessibles directement depuis l'extérieur. L'accès se fait via des méthodes publiques (getters et setters).

### Exemple d'encapsulation :
```java
class Personne {
    private String nom;
    private int age;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

---

## 4. Avantages de la POO
- **Réutilisabilité** : Les classes et objets peuvent être réutilisés dans différents contextes.
- **Modularité** : Le code est plus facilement maintenable et compréhensible, car il est divisé en modules indépendants (classes).
- **Facilité de mise à jour** : Grâce à l'encapsulation et à l'abstraction, les détails d'implémentation peuvent être modifiés sans affecter le reste du code.

---

Ce premier cours vous introduit aux concepts fondamentaux de la POO en Java et prépare les bases pour des cours plus avancés.
