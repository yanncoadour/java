
# Cours 17 : Classes internes et anonymes en Java

## Objectifs :
- Comprendre le concept de classes internes en Java
- Apprendre à utiliser les classes internes pour mieux organiser le code
- Découvrir les classes anonymes et leur utilisation

---

## 1. Qu'est-ce qu'une classe interne ?
Une **classe interne** est une classe définie à l'intérieur d'une autre classe. Elle permet de regrouper logiquement des classes qui ne seront utilisées qu'à l'intérieur de la classe externe. Les classes internes peuvent accéder aux membres de la classe externe, y compris les membres privés.

### Types de classes internes :
1. **Classe interne régulière** : Définie à l'intérieur d'une autre classe.
2. **Classe statique interne** : Définie avec le mot-clé `static`.
3. **Classe locale** : Définie à l'intérieur d'une méthode.
4. **Classe anonyme** : Une classe qui n'a pas de nom et est définie lors de l'instanciation.

---

## 2. Classe interne régulière
Une **classe interne régulière** est une classe définie à l'intérieur d'une autre classe, sans le mot-clé `static`. Elle peut accéder aux attributs et méthodes de la classe externe.

### Exemple :
```java
class Externe {
    private String message = "Bonjour du monde externe !";

    class Interne {
        void afficherMessage() {
            System.out.println(message);  // Accès à l'attribut de la classe externe
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Externe externe = new Externe();
        Externe.Interne interne = externe.new Interne();
        interne.afficherMessage();
    }
}
```

Dans cet exemple, la classe `Interne` est une classe interne régulière de la classe `Externe`. Elle peut accéder à l'attribut privé `message` de la classe `Externe`.

---

## 3. Classe statique interne
Une **classe statique interne** est une classe définie avec le mot-clé `static` à l'intérieur d'une autre classe. Contrairement à une classe interne régulière, elle ne peut pas accéder directement aux membres non statiques de la classe externe.

### Exemple :
```java
class Externe {
    static String message = "Bonjour du monde externe statique !";

    static class InterneStatique {
        void afficherMessage() {
            System.out.println(message);  // Accès aux membres statiques de la classe externe
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Externe.InterneStatique interne = new Externe.InterneStatique();
        interne.afficherMessage();
    }
}
```

Dans cet exemple, la classe `InterneStatique` est une classe interne statique qui peut accéder aux membres statiques de la classe `Externe`.

---

## 4. Classe locale
Une **classe locale** est une classe définie à l'intérieur d'une méthode. Elle n'est accessible que dans la méthode où elle est définie.

### Exemple :
```java
class Externe {
    void methodeExterne() {
        class Locale {
            void afficherMessage() {
                System.out.println("Bonjour de la classe locale !");
            }
        }

        Locale locale = new Locale();
        locale.afficherMessage();
    }
}

public class Main {
    public static void main(String[] args) {
        Externe externe = new Externe();
        externe.methodeExterne();
    }
}
```

Dans cet exemple, la classe `Locale` est définie à l'intérieur de la méthode `methodeExterne()` et ne peut être utilisée que dans cette méthode.

---

## 5. Classe anonyme
Une **classe anonyme** est une classe sans nom qui est définie et instanciée en même temps. Elle est souvent utilisée pour redéfinir des méthodes dans des interfaces ou des classes abstraites sans avoir à créer une classe nommée séparée.

### Exemple :
```java
class Externe {
    void afficherMessage() {
        System.out.println("Message de la classe externe");
    }
}

public class Main {
    public static void main(String[] args) {
        Externe anonyme = new Externe() {
            @Override
            void afficherMessage() {
                System.out.println("Message de la classe anonyme");
            }
        };
        anonyme.afficherMessage();  // Appelle la méthode redéfinie dans la classe anonyme
    }
}
```

Dans cet exemple, une classe anonyme est créée à partir de la classe `Externe`, et elle redéfinit la méthode `afficherMessage()`.

---

## 6. Quand utiliser les classes internes et anonymes ?
- **Classes internes** : Elles sont utiles lorsque vous avez besoin de définir une relation forte entre deux classes. Les classes internes permettent de mieux structurer votre code en regroupant des classes qui ne seront utilisées qu'au sein de la classe externe.
- **Classes anonymes** : Elles sont particulièrement utiles pour les implémentations rapides d'interfaces ou pour redéfinir des méthodes sur place sans avoir à créer une classe dédiée.

---

## Exercices Pratiques

### Exercice 1 : Classe interne régulière
1. Créez une classe `Ordinateur` avec une classe interne `Processeur`.
2. La classe `Processeur` doit avoir une méthode `afficherDetails()` qui affiche les détails du processeur.
3. Dans la méthode `main()`, créez un objet `Processeur` à partir d'un objet `Ordinateur` et appelez la méthode `afficherDetails()`.

### Exercice 2 : Classe statique interne
1. Créez une classe `Universite` avec une classe statique `Departement`.
2. La classe `Departement` doit avoir une méthode pour afficher le nom du département.
3. Dans la méthode `main()`, appelez la méthode de la classe `Departement`.

### Exercice 3 : Classe anonyme
1. Créez une classe `Animal` avec une méthode `faireDuBruit()`.
2. Dans la méthode `main()`, créez une classe anonyme qui redéfinit `faireDuBruit()` pour afficher un son spécifique (par exemple, "Miaou" pour un chat).

---

Ce cours vous a présenté les classes internes et anonymes en Java, leur utilité et leurs différences. Les exercices vous aideront à mettre en pratique ces concepts dans vos propres programmes.
