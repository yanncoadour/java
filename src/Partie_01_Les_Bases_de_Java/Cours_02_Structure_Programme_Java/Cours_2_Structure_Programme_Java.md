
# Cours 2 : Structure d'un programme Java

## Objectifs :
- Comprendre la structure d'un programme Java
- Apprendre les bases de la syntaxe Java
- Découvrir le rôle de la méthode `main()`
- Apprendre à utiliser la méthode `System.out.println()` pour afficher des informations
- Apprendre à ajouter des commentaires dans le code

---

## 1. Structure d'un programme Java
Un programme Java est composé de **classes**, **méthodes**, et parfois d'attributs. La structure de base d'un programme Java est la suivante :

```java
public class NomDeClasse {
    public static void main(String[] args) {
        // Code à exécuter
    }
}
```

- **Classe** : En Java, tout le code doit être écrit dans une classe. Le nom de la classe doit correspondre au nom du fichier avec l'extension `.java`. Par exemple, si votre classe s'appelle `MonProgramme`, le fichier devra s'appeler `MonProgramme.java`.
  
- **Méthode main()** : C'est la méthode principale où l'exécution du programme commence. La méthode `main` est écrite comme suit :
  
  ```java
  public static void main(String[] args) {
      // Code à exécuter
  }
  ```

  - `public` : Cette méthode doit être accessible depuis l'extérieur de la classe.
  - `static` : La méthode appartient à la classe et non à une instance de la classe.
  - `void` : La méthode ne retourne pas de valeur.
  - `main` : C'est le point d'entrée du programme.
  - `String[] args` : Ce sont les arguments que l'on peut passer au programme lors de son exécution.

---

## 2. Affichage avec `System.out.println()`
Pour afficher des informations dans la console, Java utilise la méthode `System.out.println()`. Elle permet d'afficher du texte ou des données et passe automatiquement à la ligne suivante après chaque affichage.

### Exemple :
```java
public class MonProgramme {
    public static void main(String[] args) {
        System.out.println("Bonjour, bienvenue dans le monde Java !");
    }
}
```

Ce programme affichera :
```
Bonjour, bienvenue dans le monde Java !
```

---

## 3. Commentaires dans le code
Les commentaires sont des éléments du code que le programme ignore lorsqu'il s'exécute. Ils permettent aux développeurs d'ajouter des explications dans le code.

- **Commentaire sur une seule ligne** : Utilisez `//` pour ajouter un commentaire sur une ligne.

  ```java
  // Ceci est un commentaire sur une seule ligne
  ```

- **Commentaire sur plusieurs lignes** : Utilisez `/* ... */` pour des commentaires sur plusieurs lignes.

  ```java
  /*
   * Ceci est un commentaire sur
   * plusieurs lignes.
   */
  ```

---

## Exercices Pratiques

### Exercice 1 : Créer un programme simple
1. Créez un fichier Java nommé `Bonjour.java`.
2. Dans ce fichier, écrivez un programme qui affiche `Bonjour, tout le monde !` dans la console.
3. Ajoutez un commentaire sur une ligne pour décrire ce que fait le programme.

### Exercice 2 : Utiliser `System.out.println()`
1. Créez un programme nommé `Affichage.java`.
2. Écrivez un programme qui affiche :
   - Votre nom
   - Votre âge
   - Votre ville
3. Utilisez `System.out.println()` pour chaque information.

### Exercice 3 : Créer un programme avec des commentaires
1. Créez un programme nommé `MaPresentation.java`.
2. Ce programme doit afficher votre présentation personnelle (nom, âge, profession) en utilisant plusieurs lignes `System.out.println()`.
3. Ajoutez des commentaires pour expliquer chaque partie du programme.

---

Ce cours vous a présenté la structure de base d'un programme Java, la méthode `main()` qui est le point d'entrée du programme, et la façon d'afficher des informations à l'aide de `System.out.println()`. Les exercices vous aideront à mettre en pratique ces notions pour mieux comprendre la syntaxe Java.

