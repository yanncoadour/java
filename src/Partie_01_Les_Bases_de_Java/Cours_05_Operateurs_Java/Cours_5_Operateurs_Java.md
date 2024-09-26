
# Cours 5 : Opérateurs en Java (arithmétiques, de comparaison, logiques)

## Objectifs :
- Comprendre les opérateurs arithmétiques en Java
- Découvrir les opérateurs de comparaison
- Apprendre à utiliser les opérateurs logiques

---

## 1. Les opérateurs arithmétiques
Les **opérateurs arithmétiques** permettent d'effectuer des calculs mathématiques simples tels que l'addition, la soustraction, la multiplication, etc.

| Opérateur | Description         | Exemple    |
|-----------|---------------------|------------|
| `+`       | Addition             | `a + b`    |
| `-`       | Soustraction         | `a - b`    |
| `*`       | Multiplication       | `a * b`    |
| `/`       | Division             | `a / b`    |
| `%`       | Modulo (reste)       | `a % b`    |

### Exemple d'utilisation :
```java
int a = 10;
int b = 5;
int somme = a + b;  // Addition
int produit = a * b;  // Multiplication
```

---

## 2. Les opérateurs de comparaison
Les **opérateurs de comparaison** sont utilisés pour comparer deux valeurs. Ils retournent une valeur booléenne (`true` ou `false`).

| Opérateur | Description                | Exemple    |
|-----------|----------------------------|------------|
| `==`      | Égal à                     | `a == b`   |
| `!=`      | Différent de               | `a != b`   |
| `>`       | Supérieur à                | `a > b`    |
| `<`       | Inférieur à                | `a < b`    |
| `>=`      | Supérieur ou égal à        | `a >= b`   |
| `<=`      | Inférieur ou égal à        | `a <= b`   |

### Exemple d'utilisation :
```java
int a = 10;
int b = 5;
boolean estEgal = (a == b);  // Faux
boolean estSuperieur = (a > b);  // Vrai
```

---

## 3. Les opérateurs logiques
Les **opérateurs logiques** permettent de combiner des expressions booléennes.

| Opérateur | Description                | Exemple        |
|-----------|----------------------------|----------------|
| `&&`      | ET logique (AND)            | `a && b`       |
| `||`      | OU logique (OR)             | `a || b`       |
| `!`       | NON logique (NOT)           | `!a`           |

### Exemple d'utilisation :
```java
boolean a = true;
boolean b = false;
boolean resultatEt = (a && b);  // Faux
boolean resultatOu = (a || b);  // Vrai
boolean resultatNon = !a;  // Faux
```

---

## 4. Priorité des opérateurs
Les opérateurs en Java sont évalués dans un certain ordre de priorité. Voici un aperçu des priorités courantes (de la plus haute à la plus basse) :
1. `!` (Non logique)
2. `*`, `/`, `%` (Multiplication, Division, Modulo)
3. `+`, `-` (Addition, Soustraction)
4. `>`, `<`, `>=`, `<=` (Comparaison)
5. `==`, `!=` (Égalité, Différence)
6. `&&` (ET logique)
7. `||` (OU logique)

---

## Exercices Pratiques

### Exercice 1 : Opérations arithmétiques
1. Créez un programme Java nommé `OperationsArithmetiques.java`.
2. Déclarez deux variables `a` et `b`.
3. Effectuez et affichez les résultats des opérations suivantes : addition, soustraction, multiplication, division, et modulo.

### Exercice 2 : Comparaison de valeurs
1. Créez un programme Java nommé `Comparaison.java`.
2. Déclarez deux variables `x` et `y` avec des valeurs différentes.
3. Comparez `x` et `y` en utilisant chaque opérateur de comparaison et affichez les résultats.

### Exercice 3 : Opérations logiques
1. Créez un programme Java nommé `Logique.java`.
2. Déclarez deux variables booléennes `a` et `b` avec des valeurs `true` et `false`.
3. Utilisez les opérateurs logiques `&&`, `||`, et `!` pour combiner les expressions et afficher les résultats.

---

Ce cours vous a présenté les différents opérateurs en Java, ainsi que leur utilisation dans des expressions arithmétiques, de comparaison, et logiques. Les exercices vous aideront à mettre en pratique ces concepts.
