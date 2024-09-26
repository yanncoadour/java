
# Cours 4 : Variables et constantes en Java

## Objectifs :
- Comprendre la différence entre variables et constantes
- Apprendre à déclarer et utiliser des variables en Java
- Découvrir comment définir des constantes

---

## 1. Qu'est-ce qu'une variable ?
Une **variable** est un espace mémoire où l'on peut stocker des données qui peuvent changer au cours de l'exécution du programme. En Java, chaque variable a un type qui détermine quel genre de valeur elle peut stocker.

### Syntaxe de déclaration :
```java
type nomDeVariable = valeurInitiale;
```

### Exemple :
```java
int age = 30;
double prix = 19.99;
```

---

## 2. Types de variables

### a) Variables locales
Les **variables locales** sont déclarées à l'intérieur d'une méthode et ne peuvent être utilisées que dans cette méthode.

### Exemple :
```java
public class Main {
    public static void main(String[] args) {
        int nombre = 5;  // Variable locale
        System.out.println(nombre);
    }
}
```

### b) Variables d'instance
Les **variables d'instance** sont déclarées à l'intérieur d'une classe mais en dehors des méthodes. Elles appartiennent à une instance de la classe et chaque objet a sa propre copie de ces variables.

### Exemple :
```java
public class Voiture {
    String marque;  // Variable d'instance
    String modele;

    public Voiture(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
    }
}
```

### c) Variables de classe (ou variables statiques)
Les **variables de classe** (ou variables statiques) sont partagées par toutes les instances d'une classe. Elles sont déclarées avec le mot-clé `static`.

### Exemple :
```java
public class Voiture {
    static int nombreDeVoitures;  // Variable de classe

    public Voiture() {
        nombreDeVoitures++;
    }
}
```

---

## 3. Qu'est-ce qu'une constante ?
Une **constante** est une variable dont la valeur ne change jamais après avoir été initialisée. En Java, on utilise le mot-clé `final` pour déclarer une constante.

### Syntaxe de déclaration :
```java
final type NOM_CONSTANTE = valeur;
```

### Exemple :
```java
final double PI = 3.14159;
```

Les constantes sont généralement déclarées en majuscules pour les différencier des variables.

---

## 4. Différences entre variables et constantes
- Une **variable** peut changer au cours de l'exécution du programme, tandis qu'une **constante** reste immuable après son initialisation.
- Les variables peuvent être locales, d'instance ou de classe, mais les constantes sont toujours immuables.

---

## Exercices Pratiques

### Exercice 1 : Déclaration de variables
1. Créez un fichier Java nommé `VariablesEtConstantes.java`.
2. Déclarez plusieurs variables locales de différents types (int, double, char, etc.).
3. Modifiez certaines de ces variables et affichez leurs valeurs à différentes étapes du programme.

### Exercice 2 : Utilisation de constantes
1. Dans le fichier `VariablesEtConstantes.java`, déclarez une constante pour le taux de TVA (par exemple, `final double TVA = 0.20`).
2. Utilisez cette constante dans un calcul pour déterminer le prix total d'un produit après application de la TVA.
3. Affichez le résultat.

---

Ce cours vous a présenté les concepts de variables et de constantes en Java, ainsi que leur déclaration et utilisation. Les exercices vous permettront de pratiquer ces notions et de comprendre leurs différences.
