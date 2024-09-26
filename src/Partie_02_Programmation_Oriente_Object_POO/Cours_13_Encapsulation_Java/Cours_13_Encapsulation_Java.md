
# Cours 13 : Encapsulation en Java

## Objectifs :
- Comprendre le concept d'encapsulation en Java
- Apprendre à protéger les données d'une classe en utilisant des modificateurs d'accès
- Découvrir l'utilisation des getters et setters pour accéder aux attributs

---

## 1. Qu'est-ce que l'encapsulation ?
L'**encapsulation** est un principe de la programmation orientée objet qui consiste à protéger les données d'une classe en les rendant inaccessibles depuis l'extérieur de la classe. En Java, l'encapsulation est réalisée en déclarant les attributs d'une classe comme privés et en fournissant des méthodes publiques (getters et setters) pour y accéder.

### Avantages de l'encapsulation :
- **Protection des données** : Les attributs privés ne peuvent pas être modifiés directement depuis l'extérieur de la classe.
- **Contrôle des modifications** : Les méthodes setters permettent de contrôler la manière dont les valeurs des attributs sont modifiées.
- **Maintenabilité** : Le code est plus facile à maintenir, car les attributs sont isolés du reste du programme.

---

## 2. Modificateurs d'accès
Java fournit plusieurs **modificateurs d'accès** qui définissent la portée des attributs et méthodes d'une classe :

- `private` : L'attribut ou la méthode n'est accessible qu'à l'intérieur de la classe.
- `public` : L'attribut ou la méthode est accessible depuis n'importe quelle autre classe.
- `protected` : L'attribut ou la méthode est accessible à la classe et à ses sous-classes.
- (aucun modificateur) : L'attribut ou la méthode est accessible à toutes les classes du même package.

---

## 3. Exemple d'encapsulation
Voici un exemple simple d'encapsulation en Java :

```java
class Personne {
    private String nom;
    private int age;

    // Getter pour l'attribut nom
    public String getNom() {
        return nom;
    }

    // Setter pour l'attribut nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour l'attribut age
    public int getAge() {
        return age;
    }

    // Setter pour l'attribut age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("L'âge doit être positif.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne();
        p.setNom("Alice");
        p.setAge(30);
        
        System.out.println("Nom : " + p.getNom());
        System.out.println("Âge : " + p.getAge());
    }
}
```

Dans cet exemple, les attributs `nom` et `age` sont déclarés `private`, ce qui signifie qu'ils ne peuvent pas être modifiés directement depuis l'extérieur de la classe. Les méthodes `getNom()`, `setNom()`, `getAge()`, et `setAge()` permettent de lire et de modifier ces attributs de manière contrôlée.

---

## 4. Getters et Setters
Les **getters** et **setters** sont des méthodes publiques qui permettent d'accéder aux attributs privés d'une classe. Le getter est utilisé pour lire la valeur d'un attribut, tandis que le setter est utilisé pour la modifier.

### Exemple de getter et setter :
```java
class Voiture {
    private String marque;
    
    // Getter pour marque
    public String getMarque() {
        return marque;
    }

    // Setter pour marque
    public void setMarque(String marque) {
        this.marque = marque;
    }
}
```

Les getters et setters permettent également de contrôler les modifications d'attributs, par exemple en vérifiant la validité des valeurs.

---

## 5. Encapsulation et sécurité
L'encapsulation améliore la **sécurité** des données d'une application. En isolant les données, vous empêchez des modifications non désirées ou incorrectes de celles-ci. Par exemple, vous pouvez vous assurer que l'âge d'une personne ne soit jamais négatif grâce à une validation dans le setter.

---

## Exercices Pratiques

### Exercice 1 : Encapsulation avec getters et setters
1. Créez une classe `Produit` avec deux attributs `nom` et `prix` (tous deux privés).
2. Déclarez des getters et setters pour chaque attribut.
3. Dans la méthode `main()`, créez un objet `Produit`, définissez le nom et le prix via les setters, puis affichez les informations du produit via les getters.

### Exercice 2 : Validation dans un setter
1. Modifiez la classe `Produit` pour ajouter une validation dans le setter de `prix` afin de garantir que le prix ne soit pas négatif.
2. Testez la validation en tentant de définir un prix négatif.

### Exercice 3 : Encapsulation et calcul
1. Créez une classe `Rectangle` avec deux attributs privés `longueur` et `largeur`.
2. Ajoutez des getters et setters pour ces attributs.
3. Ajoutez une méthode `calculerSurface()` qui renvoie la surface du rectangle.
4. Créez un objet `Rectangle` dans la méthode `main()`, définissez la longueur et la largeur, et affichez la surface.

---

Ce cours vous a présenté le concept d'encapsulation en Java, son importance pour protéger les données, et l'utilisation des getters et setters. Les exercices vous permettront de pratiquer ces concepts et de maîtriser l'encapsulation dans vos programmes.
