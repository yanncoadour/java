
# Cours 19 : Enregistrements et immutabilité en Java

## Objectifs :
- Comprendre le concept des enregistrements en Java
- Apprendre à créer des enregistrements (records) pour des données immuables
- Découvrir les avantages de l'immutabilité dans la conception de programmes

---

## 1. Qu'est-ce qu'un enregistrement (record) en Java ?
Introduits dans Java 14 (en avant-première) et devenus stables à partir de Java 16, les **enregistrements** (ou **records**) sont une nouvelle forme de classe conçue pour représenter des données immuables. Ils fournissent une manière simple et concise de définir une classe avec des champs, des constructeurs, des méthodes `equals()`, `hashCode()`, et `toString()` automatiquement générés.

### Caractéristiques des enregistrements :
- **Immutabilité** : Les champs d'un enregistrement sont implicitement `final`, ce qui signifie qu'ils ne peuvent pas être modifiés après l'initialisation.
- **Concision** : Java génère automatiquement les méthodes fondamentales comme `equals()`, `hashCode()`, et `toString()`.

### Syntaxe d'un enregistrement :
```java
public record NomEnregistrement(TypeAttribut1 attribut1, TypeAttribut2 attribut2) {}
```

---

## 2. Exemple de création d'un enregistrement
Voici un exemple simple d'enregistrement en Java qui représente une personne avec un nom et un âge :

```java
public record Personne(String nom, int age) {}
```

Cet enregistrement génère automatiquement :
- Un constructeur pour initialiser `nom` et `age`.
- Les méthodes `equals()`, `hashCode()`, et `toString()`.
- Des méthodes d'accès (`nom()` et `age()`) pour récupérer les valeurs des champs.

### Exemple d'utilisation :
```java
public class Main {
    public static void main(String[] args) {
        Personne p = new Personne("Alice", 25);
        System.out.println(p.nom());  // Affiche "Alice"
        System.out.println(p.age());  // Affiche 25
        System.out.println(p);  // Appelle la méthode toString()
    }
}
```

Dans cet exemple, `Personne` est un enregistrement et ses champs sont automatiquement immuables.

---

## 3. Immutabilité en Java
L'**immutabilité** signifie qu'une fois un objet créé, il ne peut plus être modifié. Les objets immuables sont plus sûrs et moins sujets aux erreurs, car ils évitent les effets secondaires. L'immutabilité permet également de rendre les programmes plus faciles à comprendre et à maintenir.

### Avantages de l'immutabilité :
1. **Simplicité** : Un objet immuable ne change pas, ce qui réduit la complexité du programme.
2. **Sécurité des threads** : Les objets immuables sont naturellement sûrs pour l'utilisation dans des environnements multi-threads.
3. **Fiabilité** : Les objets immuables évitent les problèmes de modification non intentionnelle d'un état.

### Exemples d'objets immuables en Java :
- Les chaînes de caractères (`String`) sont immuables.
- Les enregistrements (`record`) sont immuables par conception.

---

## 4. Personnaliser un enregistrement
Bien que les enregistrements soient concis, vous pouvez personnaliser leur comportement en ajoutant des méthodes, des constructeurs supplémentaires, ou même en validant les paramètres.

### Exemple de validation dans un constructeur :
```java
public record Personne(String nom, int age) {
    public Personne {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge ne peut pas être négatif");
        }
    }
}
```

Dans cet exemple, le constructeur valide que l'âge ne soit pas négatif.

### Ajouter des méthodes dans un enregistrement :
```java
public record Personne(String nom, int age) {
    public String afficherBienvenue() {
        return "Bienvenue, " + nom + "!";
    }
}
```

Vous pouvez ajouter des méthodes supplémentaires pour enrichir la fonctionnalité de l'enregistrement.

---

## 5. Comparaison avec les classes classiques
| **Caractéristique** | **Classe classique** | **Enregistrement (record)** |
|---------------------|----------------------|-----------------------------|
| Immutabilité        | Optionnelle (attributs `final`) | Par défaut (attributs immuables) |
| Concision           | Plus de code pour définir constructeurs, getters, etc. | Très concis (constructeurs et méthodes générées automatiquement) |
| Modifiabilité       | Peut être mutable | Toujours immuable |
| Utilisation         | Lorsque vous avez besoin de plus de flexibilité | Lorsque vous voulez simplement représenter des données |

---

## 6. Limites des enregistrements
Les enregistrements sont conçus pour être simples et immuables. Cependant, ils ne sont pas adaptés si :
- Vous avez besoin d'héritage (les enregistrements ne peuvent pas hériter d'autres classes, sauf `Object`).
- Vous avez besoin de modifier l'état interne d'un objet après sa création.

---

## Exercices Pratiques

### Exercice 1 : Créer un enregistrement
1. Créez un enregistrement `Livre` avec les champs `titre` et `auteur`.
2. Dans la méthode `main()`, créez un objet `Livre` et affichez ses détails à l'aide de la méthode `toString()`.

### Exercice 2 : Validation dans un constructeur d'enregistrement
1. Modifiez l'enregistrement `Livre` pour ajouter une validation dans le constructeur qui empêche le titre d'être vide.
2. Testez cette validation en essayant de créer un livre avec un titre vide.

### Exercice 3 : Enregistrement et méthodes supplémentaires
1. Ajoutez une méthode `afficherDetails()` dans l'enregistrement `Livre` pour afficher un message personnalisé avec le titre et l'auteur.
2. Utilisez cette méthode dans la méthode `main()` pour afficher les détails d'un livre.

---

Ce cours vous a introduit aux enregistrements en Java, à leur immutabilité et aux avantages d'utiliser des objets immuables dans vos programmes. Les exercices vous aideront à pratiquer la création et l'utilisation des enregistrements, ainsi qu'à comprendre leur rôle dans la gestion des données.
