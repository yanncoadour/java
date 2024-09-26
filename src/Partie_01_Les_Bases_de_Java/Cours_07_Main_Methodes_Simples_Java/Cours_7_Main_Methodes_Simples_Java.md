
# Cours 7 : Méthode main() et méthodes simples en Java

## Objectifs :
- Comprendre le rôle de la méthode `main()` en Java
- Apprendre à créer et utiliser des méthodes simples
- Savoir comment passer des paramètres à une méthode et récupérer une valeur

---

## 1. La méthode `main()`
La méthode `main()` est le point d'entrée de tout programme Java. C'est la première méthode qui est exécutée lorsque vous lancez un programme.

### Syntaxe :
```java
public static void main(String[] args) {
    // Code à exécuter
}
```

### Explication :
- **public** : La méthode est accessible de partout.
- **static** : La méthode appartient à la classe et non à une instance de la classe.
- **void** : La méthode ne retourne aucune valeur.
- **String[] args** : Paramètre qui permet de passer des arguments au programme.

### Exemple de méthode `main()` :
```java
public class MonProgramme {
    public static void main(String[] args) {
        System.out.println("Bonjour, monde !");
    }
}
```

---

## 2. Créer des méthodes simples
Une méthode est un bloc de code qui peut être appelé à partir d'autres parties du programme. Les méthodes permettent de structurer le code en le rendant plus lisible et réutilisable.

### Syntaxe pour créer une méthode :
```java
typeRetour nomDeLaMethode(paramètres) {
    // Code à exécuter
    return valeurDeRetour;
}
```

- **typeRetour** : Le type de donnée que la méthode retourne. Si elle ne retourne rien, utilisez `void`.
- **nomDeLaMethode** : Le nom de la méthode.
- **paramètres** : Les valeurs que vous pouvez passer à la méthode. Ce n'est pas obligatoire.
- **return** : Utilisé pour retourner une valeur si la méthode n'est pas `void`.

---

## 3. Exemple de méthode simple (sans paramètre et sans retour)
```java
public class Exemple {
    public static void direBonjour() {
        System.out.println("Bonjour !");
    }

    public static void main(String[] args) {
        direBonjour();  // Appel de la méthode
    }
}
```

---

## 4. Exemple de méthode avec paramètres
Les méthodes peuvent accepter des paramètres, qui sont des valeurs que l'on passe à la méthode lorsqu'on l'appelle.

### Exemple :
```java
public class Exemple {
    public static void afficherNom(String nom) {
        System.out.println("Bonjour, " + nom);
    }

    public static void main(String[] args) {
        afficherNom("Alice");  // Appel de la méthode avec un paramètre
    }
}
```

---

## 5. Exemple de méthode avec retour de valeur
Une méthode peut aussi retourner une valeur qui peut être utilisée dans d'autres parties du programme.

### Exemple :
```java
public class Exemple {
    public static int additionner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int somme = additionner(5, 3);
        System.out.println("La somme est : " + somme);
    }
}
```

---

## 6. L'importance des méthodes
Les méthodes permettent de diviser un programme en petits blocs réutilisables. Cela permet d'améliorer la lisibilité, la maintenabilité et la modularité du code.

---

## Exercices Pratiques

### Exercice 1 : Méthode simple sans paramètre
1. Créez un programme nommé `Salutation.java`.
2. Déclarez une méthode `saluer()` qui affiche un message de bienvenue.
3. Appelez cette méthode depuis la méthode `main()`.

### Exercice 2 : Méthode avec paramètres
1. Créez un programme nommé `Presentation.java`.
2. Déclarez une méthode `presenter(String nom, int age)` qui affiche un message avec le nom et l'âge de la personne.
3. Appelez cette méthode en passant un nom et un âge depuis la méthode `main()`.

### Exercice 3 : Méthode avec retour de valeur
1. Créez un programme nommé `Calcul.java`.
2. Déclarez une méthode `multiplier(int a, int b)` qui retourne le produit de deux nombres.
3. Affichez le résultat de cette méthode dans la méthode `main()`.

---

Ce cours vous a présenté la méthode `main()` ainsi que les méthodes simples en Java. Vous avez appris à créer des méthodes avec ou sans paramètres et à retourner des valeurs depuis une méthode. Les exercices vous aideront à mettre en pratique ces concepts.
