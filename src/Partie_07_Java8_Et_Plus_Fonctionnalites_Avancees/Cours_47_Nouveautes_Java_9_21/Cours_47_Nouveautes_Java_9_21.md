
# Cours 47 : Nouveautés dans les versions ultérieures de Java (Java 9 à 21)

## Objectifs :
- Découvrir les principales nouveautés apportées aux différentes versions de Java de 9 à 21
- Comprendre comment ces nouvelles fonctionnalités peuvent améliorer vos programmes Java
- Apprendre à utiliser certaines de ces nouvelles fonctionnalités à travers des exemples concrets

---

## 1. Java 9 (2017)

### 1.1 Système de modules (Project Jigsaw)
Java 9 introduit un système de modules qui permet d'organiser le code en modules plutôt qu'en packages uniquement. Cela améliore la modularité et la maintenabilité des applications Java.

```java
module mymodule {
    exports com.mymodule;
}
```

### 1.2 `jshell` - Le REPL Java
Java 9 a introduit **`jshell`**, un REPL (Read-Eval-Print-Loop) qui permet d'exécuter du code Java de manière interactive.

### 1.3 Méthodes privées dans les interfaces
Java 9 permet d'utiliser des méthodes privées dans les interfaces, ce qui améliore l'organisation du code au sein d'une interface.

---

## 2. Java 10 (2018)

### 2.1 `var` - Inférence de type local
Java 10 introduit l'inférence de type local avec le mot-clé **`var`**, ce qui permet de déclarer des variables sans spécifier explicitement leur type.

```java
var message = "Bonjour Java";
System.out.println(message);  // Le type de "message" est inféré comme String
```

### 2.2 Collectors pour `Stream` non modifiables
Java 10 ajoute de nouveaux collecteurs pour créer des collections non modifiables avec l'API Stream.

```java
List<Integer> list = List.of(1, 2, 3).stream().collect(Collectors.toUnmodifiableList());
```

---

## 3. Java 11 (2018)

### 3.1 Nouveaux méthodes pour les chaînes de caractères
Java 11 ajoute de nouvelles méthodes utiles pour les chaînes de caractères, comme `isBlank()`, `lines()`, `strip()`, etc.

```java
String str = "  Java  ";
System.out.println(str.isBlank());  // true
System.out.println(str.strip());    // "Java"
```

### 3.2 `var` dans les paramètres des lambdas
Java 11 permet d'utiliser le mot-clé **`var`** dans les paramètres des expressions lambda.

---

## 4. Java 12 (2019)

### 4.1 `switch` amélioré (aperçu)
Java 12 introduit un nouvel opérateur `switch` plus concis, avec des flèches pour les cases.

```java
int jour = 5;
String typeJour = switch (jour) {
    case 1, 2, 3, 4, 5 -> "Semaine";
    case 6, 7 -> "Weekend";
    default -> "Inconnu";
};
```

### 4.2 Collectors `teeing()`
Le collecteur **`teeing()`** permet de combiner deux résultats de collecte dans un seul résultat.

---

## 5. Java 13 (2019)

### 5.1 Blocs de texte multi-lignes
Java 13 introduit les **blocs de texte** qui permettent d'écrire des chaînes de caractères multi-lignes de manière plus simple et lisible.

```java
String html = """ 
<html>
    <body>
        <p>Hello, Java!</p>
    </body>
</html> 
""";
```

---

## 6. Java 14 (2020)

### 6.1 `switch` amélioré (finalisé)
Le nouveau **`switch`** introduit en mode d'aperçu dans Java 12 est maintenant finalisé dans Java 14.

### 6.2 `instanceof` avec attribution
Java 14 introduit une nouvelle syntaxe pour `instanceof`, qui permet de faire une attribution directe.

```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

---

## 7. Java 15 (2020)

### 7.1 Classes scellées (aperçu)
Les **classes scellées** permettent de restreindre quelles classes peuvent étendre une classe ou implémenter une interface.

```java
public abstract sealed class Shape permits Circle, Square {
}
```

---

## 8. Java 16 (2021)

### 8.1 Classes d'enregistrement (records)
Les **records** en Java permettent de créer des classes immuables avec un minimum de code.

```java
public record Point(int x, int y) {}
```

### 8.2 Collections immuables améliorées
Java 16 améliore la prise en charge des collections immuables avec de nouvelles méthodes pratiques comme `toList()`.

---

## 9. Java 17 (2021 - LTS)

### 9.1 Classes scellées (finalisé)
Les **classes scellées** sont finalisées dans Java 17, permettant de contrôler précisément l'héritage.

### 9.2 `Pattern Matching` pour `switch` (aperçu)
Le pattern matching est étendu au `switch` pour permettre de filtrer et d'assigner des valeurs plus facilement.

```java
switch (obj) {
    case String s -> System.out.println(s.toUpperCase());
    case Integer i -> System.out.println(i * 2);
    default -> System.out.println("Inconnu");
}
```

---

## 10. Java 18 (2022)

### 10.1 Améliorations du réseau
Java 18 introduit de nouvelles API pour améliorer la gestion des sockets et des serveurs HTTP.

### 10.2 Serveur HTTP simple
Un **serveur HTTP minimaliste** est disponible pour les tests, permettant de démarrer un serveur très rapidement pour des scénarios simples.

---

## 11. Java 19 (2022)

### 11.1 Threads virtuels (aperçu)
Java 19 introduit les **threads virtuels** (ou Project Loom), qui permettent de créer des threads légers et plus efficaces pour gérer un grand nombre de tâches concurrentes.

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> System.out.println("Thread virtuel"));
}
```

---

## 12. Java 20 (2023)

### 12.1 Améliorations des threads virtuels
Java 20 continue d'améliorer le support des threads virtuels avec une meilleure intégration dans l'écosystème de Java.

### 12.2 Pattern Matching pour `switch` (finalisé)
Le pattern matching pour `switch` est finalisé, offrant une manière plus puissante et concise de gérer plusieurs types de données dans les `switch`.

---

## 13. Java 21 (2023 - LTS)

### 13.1 Project Loom : Threads virtuels (finalisé)
Les **threads virtuels** sont finalisés dans Java 21, apportant des améliorations majeures pour la gestion de la concurrence à grande échelle.

### 13.2 Améliorations des `Records`
Java 21 continue d'améliorer les **records** en ajoutant plus de fonctionnalités pour les classes immuables.

---

## Exercices Pratiques

### Exercice 1 : Utiliser `var` et les nouveaux blocs de texte
1. Créez une chaîne multi-ligne avec les blocs de texte.
2. Utilisez `var` pour déclarer des variables sans expliciter leur type.

### Exercice 2 : Créer un `record`
1. Créez un `record` pour représenter un point en 2D.
2. Utilisez le `record` dans une méthode pour calculer la distance entre deux points.

---

Ce cours vous a présenté les principales nouveautés des versions de Java 9 à 21. Vous avez découvert des améliorations comme le système de modules, les threads virtuels, et le pattern matching. Les exercices vous permettront de mettre en pratique certaines de ces nouvelles fonctionnalités.
