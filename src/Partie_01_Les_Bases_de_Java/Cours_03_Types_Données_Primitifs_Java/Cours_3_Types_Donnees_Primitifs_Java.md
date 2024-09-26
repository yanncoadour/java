
# Cours 3 : Types de données primitifs en Java

## Objectifs :
- Comprendre les types de données primitifs en Java
- Découvrir les différences entre les types de données
- Apprendre à déclarer et utiliser des variables primitives

---

## 1. Qu'est-ce qu'un type de donnée primitif ?
En Java, les types de données primitifs sont des types de base qui représentent des valeurs simples. Ils ne sont pas des objets et n'ont pas de méthodes associées. Java définit 8 types de données primitifs.

---

## 2. Les différents types primitifs

### a) `int` (entier)
- **Description** : Représente un nombre entier.
- **Taille** : 32 bits
- **Plage** : -2<sup>31</sup> à 2<sup>31</sup>-1
- **Exemple** :
  ```java
  int nombre = 42;
  ```

### b) `double` (nombre à virgule flottante)
- **Description** : Représente un nombre à virgule flottante en double précision.
- **Taille** : 64 bits
- **Plage** : ±4.9e-324 à ±1.7e+308
- **Exemple** :
  ```java
  double prix = 19.99;
  ```

### c) `char` (caractère)
- **Description** : Représente un caractère unique.
- **Taille** : 16 bits
- **Plage** : Caractères Unicode (valeurs de 0 à 65 535)
- **Exemple** :
  ```java
  char lettre = 'A';
  ```

### d) `boolean` (booléen)
- **Description** : Représente une valeur logique (vrai ou faux).
- **Taille** : 1 bit
- **Valeurs possibles** : `true` ou `false`
- **Exemple** :
  ```java
  boolean estVrai = true;
  ```

### e) `byte` (entier court)
- **Description** : Représente un petit entier.
- **Taille** : 8 bits
- **Plage** : -128 à 127
- **Exemple** :
  ```java
  byte petitNombre = 100;
  ```

### f) `short` (entier court)
- **Description** : Représente un entier plus court qu'un `int`.
- **Taille** : 16 bits
- **Plage** : -32 768 à 32 767
- **Exemple** :
  ```java
  short nombreCourt = 30000;
  ```

### g) `long` (entier long)
- **Description** : Représente un entier plus grand qu'un `int`.
- **Taille** : 64 bits
- **Plage** : -2<sup>63</sup> à 2<sup>63</sup>-1
- **Exemple** :
  ```java
  long grandNombre = 10000000000L;
  ```

### h) `float` (nombre à virgule flottante en simple précision)
- **Description** : Représente un nombre à virgule flottante en simple précision.
- **Taille** : 32 bits
- **Plage** : ±1.4e-45 à ±3.4e+38
- **Exemple** :
  ```java
  float temperature = 36.6f;
  ```

---

## 3. Déclaration et utilisation des variables primitives
Pour déclarer une variable en Java, vous devez spécifier le type de donnée suivi du nom de la variable.

### Exemple de déclaration et d'initialisation :
```java
int age = 25;
double salaire = 3500.75;
char initiale = 'J';
boolean estEmploye = true;
```

---

## 4. Conversion entre types primitifs
Java permet de convertir certains types primitifs entre eux. Il y a deux types de conversion :
- **Conversion implicite (widening)** : Conversion automatique vers un type plus large.
  ```java
  int entier = 100;
  double nombre = entier;  // Conversion implicite
  ```
- **Conversion explicite (narrowing)** : Conversion manuelle vers un type plus petit.
  ```java
  double grandNombre = 100.99;
  int petitNombre = (int) grandNombre;  // Conversion explicite
  ```

---

## Exercices Pratiques

### Exercice 1 : Déclaration et utilisation de types primitifs
1. Créez un programme nommé `VariablesPrimitives.java`.
2. Déclarez des variables pour chaque type primitif (`int`, `double`, `char`, `boolean`).
3. Initialisez ces variables avec des valeurs de votre choix.
4. Affichez chaque variable avec `System.out.println()`.

### Exercice 2 : Conversion de types primitifs
1. Créez un programme nommé `Conversions.java`.
2. Déclarez un `int` et un `double`.
3. Effectuez une conversion implicite de l'`int` vers un `double`.
4. Effectuez une conversion explicite d'un `double` vers un `int`.
5. Affichez les résultats avant et après la conversion.

---

Ce cours vous a présenté les types de données primitifs en Java, ainsi que leur déclaration, initialisation et utilisation. Vous avez également appris à effectuer des conversions entre ces types.

