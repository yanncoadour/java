
# Cours 48 : Modèle de mémoire Java (Heap, Stack, Mémoire Permanente)

## Objectifs :
- Comprendre comment la mémoire est gérée en Java
- Apprendre la différence entre la mémoire **Heap** et **Stack**
- Découvrir la mémoire permanente (Metaspace) et son rôle dans la gestion de la JVM

---

## 1. Introduction au modèle de mémoire Java

Java est un langage de programmation qui utilise la **JVM (Java Virtual Machine)** pour gérer l'exécution des programmes. Une partie essentielle de la JVM est la gestion de la mémoire, qui est divisée en plusieurs régions principales :
- **Heap** : Pour les objets.
- **Stack** : Pour les variables locales et les appels de méthode.
- **Metaspace** (anciennement PermGen) : Pour les métadonnées des classes.

Comprendre comment la mémoire est allouée et gérée dans ces zones est crucial pour écrire des applications performantes.

---

## 2. La mémoire Stack

### 2.1 Qu'est-ce que la Stack ?
La **Stack** est une région de mémoire qui stocke les **variables locales** des méthodes, ainsi que les informations liées aux appels de méthodes (comme les adresses de retour). Chaque thread en Java a sa propre stack, ce qui signifie que la mémoire de la stack est thread-safe.

### 2.2 Caractéristiques de la Stack
- **Taille fixe** : La taille de la stack est généralement fixe et définie au lancement de la JVM.
- **Mémoire rapide** : Les opérations sur la stack sont rapides car elles suivent un modèle LIFO (Last In, First Out).
- **Libération automatique** : La mémoire de la stack est automatiquement libérée lorsque l'exécution sort de la méthode.

### 2.3 Exemples d'utilisation de la Stack
Chaque fois qu'une méthode est appelée, les variables locales de cette méthode sont stockées dans la stack.

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;  // x est stocké dans la stack
        int y = 20;  // y est aussi stocké dans la stack
        int somme = addition(x, y);
    }

    public static int addition(int a, int b) {
        return a + b;  // a et b sont dans la stack pendant l'exécution de la méthode
    }
}
```

---

## 3. La mémoire Heap

### 3.1 Qu'est-ce que la Heap ?
La **Heap** est une région de mémoire qui stocke tous les **objets** créés dynamiquement en Java à l'aide de `new`. Contrairement à la stack, la heap est partagée entre tous les threads de l'application.

### 3.2 Caractéristiques de la Heap
- **Taille dynamique** : La heap peut grandir et rétrécir dynamiquement pendant l'exécution de l'application en fonction des besoins.
- **Accès plus lent** : L'accès à la mémoire de la heap est plus lent que celui de la stack, car elle est partagée et nécessite une gestion plus complexe.
- **Gestion par le garbage collector** : Les objets dans la heap sont gérés par le **garbage collector**, qui libère la mémoire occupée par les objets inutilisés.

### 3.3 Exemples d'utilisation de la Heap
Les objets créés avec le mot-clé `new` sont stockés dans la heap.

```java
public class Main {
    public static void main(String[] args) {
        Personne p = new Personne("Alice");  // L'objet p est stocké dans la heap
    }
}

class Personne {
    String nom;

    public Personne(String nom) {
        this.nom = nom;
    }
}
```

---

## 4. Mémoire Permanente (PermGen) et Metaspace

### 4.1 PermGen (avant Java 8)
Avant Java 8, la **PermGen (Permanent Generation)** était une zone de la mémoire utilisée pour stocker les **métadonnées** des classes, ainsi que les instances de classes et méthodes statiques. Sa taille était fixe, et elle causait souvent des **OutOfMemoryErrors** lorsque la mémoire PermGen se remplissait, en particulier dans les applications utilisant beaucoup de classes dynamiques (comme les frameworks Java EE).

### 4.2 Metaspace (depuis Java 8)
Avec Java 8, la **PermGen** a été remplacée par **Metaspace**, qui gère également les métadonnées des classes, mais de manière plus flexible. Contrairement à PermGen, Metaspace utilise la **mémoire native** (mémoire en dehors de la JVM) et peut croître dynamiquement, réduisant ainsi les problèmes de mémoire.

```java
// Java 8+
Metaspace contient les métadonnées des classes
```

### 4.3 Gestion de la Metaspace
Vous pouvez contrôler la taille de la Metaspace en utilisant les options JVM comme `-XX:MaxMetaspaceSize` pour éviter qu'elle ne croisse de manière incontrôlée.

---

## 5. Différences entre Stack, Heap et Metaspace

| **Caractéristique**     | **Stack**                          | **Heap**                               | **Metaspace**                            |
|-------------------------|------------------------------------|----------------------------------------|------------------------------------------|
| **Utilisation**          | Variables locales, appels de méthode | Objets créés avec `new`                | Métadonnées de classes et méthodes       |
| **Taille**              | Taille fixe par thread             | Dynamique, partagée entre threads      | Dynamique (mémoire native)               |
| **Vitesse d'accès**      | Très rapide                       | Plus lente                            | N/A (stocke uniquement des métadonnées)  |
| **Gestion de la mémoire**| Automatique à la fin des méthodes  | Gérée par le garbage collector         | Gérée par la JVM                        |

---

## 6. Garbage Collection et mémoire

Le **garbage collector (GC)** en Java est responsable de la libération de la mémoire occupée par les objets dans la heap qui ne sont plus référencés. Il existe plusieurs algorithmes de garbage collection, et vous pouvez configurer la JVM pour choisir l'algorithme le plus adapté à votre application (G1, ZGC, Shenandoah, etc.).

---

## Exercices Pratiques

### Exercice 1 : Comprendre la stack et la heap
1. Créez une classe simple avec des méthodes et des objets. Tracez quels éléments sont stockés dans la stack et quels éléments sont stockés dans la heap.

### Exercice 2 : Gérer la taille de la Metaspace
1. Exécutez une application Java avec une grande quantité de classes dynamiques et ajustez la taille de la Metaspace en utilisant les options JVM.

---

Ce cours vous a présenté le modèle de mémoire Java, couvrant les différences entre la stack, la heap, et la Metaspace. Vous avez découvert comment la JVM gère la mémoire et comment les objets sont stockés dans la heap et la stack. Les exercices vous permettront de mieux comprendre comment la mémoire est utilisée dans une application Java.
