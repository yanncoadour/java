
# Cours 44 : Optionals en Java

## Objectifs :
- Comprendre ce qu'est un `Optional` en Java
- Apprendre à utiliser les `Optionals` pour éviter les erreurs liées aux valeurs nulles
- Découvrir les méthodes courantes d'`Optional` pour manipuler des valeurs potentiellement absentes

---

## 1. Qu'est-ce qu'un `Optional` ?
L'**`Optional`** en Java est une classe introduite avec Java 8 qui représente une valeur potentiellement présente ou absente. Il permet de gérer de manière plus explicite l'absence de valeur, en évitant l'utilisation directe de `null`, ce qui réduit les risques d'erreurs de type `NullPointerException`.

---

## 2. Création d'un `Optional`
Un `Optional` peut être créé de plusieurs manières, en fonction de la présence ou de l'absence de la valeur.

### 2.1 `Optional.of()`
La méthode **`of()`** crée un `Optional` contenant une valeur non nulle. Si la valeur est `null`, une exception est levée.

```java
Optional<String> nom = Optional.of("Alice");
```

### 2.2 `Optional.ofNullable()`
La méthode **`ofNullable()`** crée un `Optional` contenant une valeur si elle n'est pas nulle, sinon un `Optional` vide est créé.

```java
Optional<String> nom = Optional.ofNullable(null);  // Crée un Optional vide
```

### 2.3 `Optional.empty()`
La méthode **`empty()`** crée explicitement un `Optional` vide, sans valeur.

```java
Optional<String> nom = Optional.empty();
```

---

## 3. Vérification de la présence d'une valeur
Une fois qu'un `Optional` est créé, il est possible de vérifier s'il contient une valeur.

### 3.1 `isPresent()`
La méthode **`isPresent()`** retourne `true` si l'`Optional` contient une valeur, sinon `false`.

```java
Optional<String> nom = Optional.of("Alice");
if (nom.isPresent()) {
    System.out.println("Nom : " + nom.get());
}
```

### 3.2 `ifPresent()`
La méthode **`ifPresent()`** exécute une action si l'`Optional` contient une valeur.

```java
Optional<String> nom = Optional.of("Alice");
nom.ifPresent(n -> System.out.println("Nom : " + n));
```

---

## 4. Récupérer la valeur d'un `Optional`
Il existe plusieurs manières de récupérer la valeur contenue dans un `Optional`, avec ou sans valeur par défaut.

### 4.1 `get()`
La méthode **`get()`** retourne la valeur contenue dans l'`Optional` si elle est présente, sinon elle lève une exception `NoSuchElementException`.

```java
Optional<String> nom = Optional.of("Alice");
System.out.println(nom.get());  // Affiche "Alice"
```

> Attention : N'utilisez `get()` que si vous êtes certain que l'`Optional` contient une valeur.

### 4.2 `orElse()`
La méthode **`orElse()`** retourne la valeur contenue dans l'`Optional` si elle est présente, sinon elle retourne une valeur par défaut.

```java
Optional<String> nom = Optional.ofNullable(null);
System.out.println(nom.orElse("Inconnu"));  // Affiche "Inconnu"
```

### 4.3 `orElseGet()`
La méthode **`orElseGet()`** retourne la valeur contenue dans l'`Optional` ou évalue une fonction pour fournir une valeur par défaut si aucune valeur n'est présente.

```java
Optional<String> nom = Optional.ofNullable(null);
System.out.println(nom.orElseGet(() -> "Valeur par défaut"));
```

### 4.4 `orElseThrow()`
La méthode **`orElseThrow()`** lève une exception personnalisée si aucune valeur n'est présente dans l'`Optional`.

```java
Optional<String> nom = Optional.ofNullable(null);
nom.orElseThrow(() -> new IllegalArgumentException("Valeur manquante"));
```

---

## 5. Transformation et filtrage
Les `Optionals` fournissent des méthodes pour transformer ou filtrer les valeurs contenues.

### 5.1 `map()`
La méthode **`map()`** applique une fonction à la valeur contenue dans l'`Optional` et retourne un nouvel `Optional` avec la valeur transformée.

```java
Optional<String> nom = Optional.of("Alice");
Optional<Integer> longueurNom = nom.map(String::length);
System.out.println("Longueur du nom : " + longueurNom.get());
```

### 5.2 `flatMap()`
La méthode **`flatMap()`** est similaire à `map()`, mais elle retourne directement un `Optional` au lieu d'imbriquer les `Optionals`.

```java
Optional<String> nom = Optional.of("Alice");
Optional<String> majuscules = nom.flatMap(n -> Optional.of(n.toUpperCase()));
System.out.println("Nom en majuscules : " + majuscules.get());
```

### 5.3 `filter()`
La méthode **`filter()`** applique un prédicat à la valeur contenue dans l'`Optional`. Si le prédicat est vrai, l'`Optional` est retourné, sinon un `Optional` vide est retourné.

```java
Optional<String> nom = Optional.of("Alice");
Optional<String> nomFiltre = nom.filter(n -> n.length() > 3);
nomFiltre.ifPresent(n -> System.out.println("Nom filtré : " + n));
```

---

## 6. Bonnes pratiques avec les `Optionals`
1. **Éviter `null`** : Utilisez `Optional` pour exprimer explicitement l'absence de valeur, et non pour manipuler des `null`.
2. **Prudence avec `get()`** : Utilisez `get()` uniquement lorsque vous êtes certain que l'`Optional` contient une valeur. Préférez des méthodes comme `orElse()` ou `orElseThrow()`.
3. **Utiliser `Optional` uniquement pour les retours de méthode** : Il est recommandé d'utiliser `Optional` uniquement pour les valeurs de retour de méthode, et non pour les arguments de méthode ou les attributs de classe.

---

## Exercices Pratiques

### Exercice 1 : Utilisation de `Optional`
1. Créez une méthode qui retourne un `Optional` de type `String`. Utilisez `ofNullable()` pour retourner un `Optional` vide si l'entrée est `null`.
2. Utilisez `orElse()` pour fournir une valeur par défaut lorsque l'`Optional` est vide.

### Exercice 2 : Filtrage avec `Optional`
1. Créez un `Optional` contenant un nom.
2. Utilisez `filter()` pour ne conserver que les noms ayant plus de 5 caractères.

---

Ce cours vous a introduit à l'utilisation des `Optionals` en Java pour gérer les valeurs potentiellement nulles de manière plus explicite et sûre. Vous avez appris à créer, vérifier, transformer et récupérer des valeurs d'`Optional`, tout en évitant les erreurs courantes comme les `NullPointerException`. Les exercices vous permettront de mettre en pratique ces concepts dans des situations réelles.
