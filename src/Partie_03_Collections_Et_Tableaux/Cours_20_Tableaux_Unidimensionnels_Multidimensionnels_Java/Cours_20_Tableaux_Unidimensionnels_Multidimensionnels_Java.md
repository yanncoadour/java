
# Cours 20 : Tableaux unidimensionnels et multidimensionnels en Java

## Objectifs :
- Comprendre le concept de tableaux en Java
- Apprendre à créer et manipuler des tableaux unidimensionnels et multidimensionnels
- Découvrir les opérations courantes sur les tableaux

---

## 1. Qu'est-ce qu'un tableau en Java ?
Un **tableau** est une structure de données qui permet de stocker plusieurs valeurs de même type dans une seule variable. En Java, les tableaux ont une taille fixe, et chaque élément peut être accédé via son index (à partir de 0).

### Syntaxe pour déclarer un tableau :
```java
type[] nomDuTableau = new type[taille];
```

### Exemple :
```java
int[] nombres = new int[5];  // Crée un tableau de 5 entiers
```

---

## 2. Tableaux unidimensionnels
Un **tableau unidimensionnel** est une liste linéaire d'éléments. Chaque élément peut être accédé via son index.

### Exemple de création et d'initialisation d'un tableau :
```java
public class Main {
    public static void main(String[] args) {
        int[] nombres = {10, 20, 30, 40, 50};

        // Accéder à un élément du tableau
        System.out.println(nombres[2]);  // Affiche 30

        // Parcourir le tableau
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Élément à l'index " + i + " : " + nombres[i]);
        }
    }
}
```

Dans cet exemple, un tableau de cinq entiers est créé et parcouru avec une boucle `for`.

### Opérations courantes sur les tableaux unidimensionnels :
1. **Initialisation** : Vous pouvez initialiser un tableau directement lors de sa déclaration, comme dans l'exemple ci-dessus.
2. **Accès** : Chaque élément peut être accédé via son index, comme `nombres[2]`.
3. **Parcours** : Utilisez une boucle pour parcourir tous les éléments du tableau.

---

## 3. Tableaux multidimensionnels
Un **tableau multidimensionnel** est un tableau de tableaux. Le tableau le plus courant est le tableau à deux dimensions, qui peut être vu comme une grille (ou une matrice).

### Syntaxe pour déclarer un tableau à deux dimensions :
```java
type[][] nomDuTableau = new type[ligne][colonne];
```

### Exemple de création et d'initialisation d'un tableau à deux dimensions :
```java
public class Main {
    public static void main(String[] args) {
        int[][] matrice = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Accéder à un élément du tableau
        System.out.println(matrice[1][1]);  // Affiche 5

        // Parcourir le tableau à deux dimensions
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();  // Aller à la ligne après chaque ligne de la matrice
        }
    }
}
```

Dans cet exemple, une matrice de 3x3 est créée, et chaque élément est accédé via deux indices (ligne et colonne).

### Opérations courantes sur les tableaux multidimensionnels :
1. **Initialisation** : Comme pour les tableaux unidimensionnels, vous pouvez initialiser un tableau multidimensionnel lors de sa déclaration.
2. **Accès** : Utilisez deux indices pour accéder à chaque élément (par exemple, `matrice[1][2]`).
3. **Parcours** : Utilisez des boucles imbriquées pour parcourir les tableaux multidimensionnels.

---

## 4. Taille des tableaux
La taille d'un tableau est fixe et ne peut pas être modifiée après sa création. Vous pouvez obtenir la taille d'un tableau en utilisant la propriété `.length`.

### Exemple :
```java
int[] nombres = {10, 20, 30};
System.out.println("Taille du tableau : " + nombres.length);  // Affiche 3
```

Pour les tableaux multidimensionnels, `.length` vous donne la taille de la première dimension (le nombre de lignes), et vous pouvez accéder à la taille des autres dimensions via les indices.

### Exemple :
```java
int[][] matrice = new int[3][4];
System.out.println("Nombre de lignes : " + matrice.length);  // Affiche 3
System.out.println("Nombre de colonnes : " + matrice[0].length);  // Affiche 4
```

---

## 5. Tableaux irréguliers (ou tableaux en escalier)
En Java, les tableaux multidimensionnels peuvent être irréguliers, ce qui signifie que chaque sous-tableau peut avoir une taille différente.

### Exemple :
```java
public class Main {
    public static void main(String[] args) {
        int[][] tableauIrrégulier = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };

        for (int i = 0; i < tableauIrrégulier.length; i++) {
            for (int j = 0; j < tableauIrrégulier[i].length; j++) {
                System.out.print(tableauIrrégulier[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

Dans cet exemple, chaque ligne du tableau a une taille différente, ce qui est permis en Java.

---

## Exercices Pratiques

### Exercice 1 : Création d'un tableau unidimensionnel
1. Créez un tableau `notes` contenant 5 notes d'examen.
2. Affichez chaque note dans la méthode `main()`.

### Exercice 2 : Tableau multidimensionnel
1. Créez un tableau de 3x3 représentant une grille de jeu.
2. Remplissez la grille avec des numéros et affichez-la.

### Exercice 3 : Tableau irrégulier
1. Créez un tableau irrégulier où chaque ligne a une taille différente.
2. Affichez le contenu du tableau irrégulier dans la méthode `main()`.

---

Ce cours vous a introduit aux tableaux unidimensionnels et multidimensionnels en Java, ainsi qu'aux différentes opérations que vous pouvez effectuer sur eux. Les exercices vous aideront à pratiquer et à comprendre comment manipuler ces structures dans vos programmes.
