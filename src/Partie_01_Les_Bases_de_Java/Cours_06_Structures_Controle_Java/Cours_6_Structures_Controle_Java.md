
# Cours 6 : Structures de contrôle en Java (if, else, switch, for, while, do-while)

## Objectifs :
- Comprendre les différentes structures de contrôle en Java
- Apprendre à utiliser les structures conditionnelles `if`, `else`, et `switch`
- Apprendre à utiliser les boucles `for`, `while`, et `do-while`

---

## 1. Structure conditionnelle `if` et `else`
La structure conditionnelle `if` permet d'exécuter un bloc de code si une condition est vraie. Le bloc `else` est exécuté si la condition est fausse.

### Syntaxe :
```java
if (condition) {
    // Code exécuté si la condition est vraie
} else {
    // Code exécuté si la condition est fausse
}
```

### Exemple :
```java
int age = 18;
if (age >= 18) {
    System.out.println("Vous êtes majeur.");
} else {
    System.out.println("Vous êtes mineur.");
}
```

---

## 2. Structure conditionnelle `switch`
La structure `switch` permet de tester une variable contre plusieurs valeurs. Elle est souvent utilisée pour éviter une série de `if` imbriqués.

### Syntaxe :
```java
switch (variable) {
    case valeur1:
        // Code pour valeur1
        break;
    case valeur2:
        // Code pour valeur2
        break;
    default:
        // Code par défaut
}
```

### Exemple :
```java
int jour = 3;
switch (jour) {
    case 1:
        System.out.println("Lundi");
        break;
    case 2:
        System.out.println("Mardi");
        break;
    case 3:
        System.out.println("Mercredi");
        break;
    default:
        System.out.println("Jour inconnu");
}
```

---

## 3. La boucle `for`
La boucle `for` permet de répéter un bloc de code un nombre précis de fois. Elle est composée de trois parties : l'initialisation, la condition, et l'incrémentation.

### Syntaxe :
```java
for (initialisation; condition; incrémentation) {
    // Code à répéter
}
```

### Exemple :
```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

---

## 4. La boucle `while`
La boucle `while` permet de répéter un bloc de code tant qu'une condition est vraie.

### Syntaxe :
```java
while (condition) {
    // Code à répéter tant que la condition est vraie
}
```

### Exemple :
```java
int i = 0;
while (i < 5) {
    System.out.println("i = " + i);
    i++;
}
```

---

## 5. La boucle `do-while`
La boucle `do-while` est similaire à la boucle `while`, mais elle garantit que le bloc de code sera exécuté au moins une fois, car la condition est vérifiée après l'exécution du code.

### Syntaxe :
```java
do {
    // Code à exécuter
} while (condition);
```

### Exemple :
```java
int i = 0;
do {
    System.out.println("i = " + i);
    i++;
} while (i < 5);
```

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `if` et `else`
1. Créez un programme Java nommé `Conditions.java`.
2. Déclarez une variable `age`.
3. Utilisez un `if` pour vérifier si la personne est majeure (âge >= 18) et affichez un message correspondant.

### Exercice 2 : Utilisation de `switch`
1. Créez un programme Java nommé `SwitchJour.java`.
2. Déclarez une variable `jour` (1 pour lundi, 2 pour mardi, etc.).
3. Utilisez un `switch` pour afficher le jour correspondant.

### Exercice 3 : Boucle `for`
1. Créez un programme Java nommé `BoucleFor.java`.
2. Utilisez une boucle `for` pour afficher les nombres de 0 à 9.

### Exercice 4 : Boucle `while`
1. Créez un programme Java nommé `BoucleWhile.java`.
2. Utilisez une boucle `while` pour afficher les nombres de 10 à 1.

### Exercice 5 : Boucle `do-while`
1. Créez un programme Java nommé `BoucleDoWhile.java`.
2. Utilisez une boucle `do-while` pour afficher les nombres de 0 à 5.

---

Ce cours vous a présenté les principales structures de contrôle en Java : les structures conditionnelles `if`, `else`, et `switch`, ainsi que les boucles `for`, `while`, et `do-while`. Les exercices vous permettront de mettre en pratique ces concepts de base.
