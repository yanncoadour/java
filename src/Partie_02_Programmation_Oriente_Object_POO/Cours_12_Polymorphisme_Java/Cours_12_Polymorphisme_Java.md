
# Cours 12 : Polymorphisme en Java

## Objectifs :
- Comprendre le concept de polymorphisme en Java
- Apprendre à utiliser le polymorphisme avec des classes et des interfaces
- Découvrir les avantages du polymorphisme dans la conception de programmes

---

## 1. Qu'est-ce que le polymorphisme ?
Le **polymorphisme** est un principe clé de la programmation orientée objet qui permet à un objet de prendre plusieurs formes. En Java, le polymorphisme permet d'utiliser une méthode ou un objet de manière générique tout en permettant un comportement spécifique selon la classe de l'objet.

Il existe deux types de polymorphisme en Java :
- **Polymorphisme à la compilation** (surcharge de méthodes)
- **Polymorphisme à l'exécution** (héritage et interfaces)

---

## 2. Polymorphisme à la compilation (surcharge de méthodes)
La **surcharge de méthodes** permet d'avoir plusieurs méthodes avec le même nom dans une classe, mais avec des signatures différentes (différents types ou nombres de paramètres).

### Exemple de surcharge de méthodes :
```java
class Calculatrice {
    // Addition de deux entiers
    int additionner(int a, int b) {
        return a + b;
    }

    // Addition de trois entiers
    int additionner(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculatrice calc = new Calculatrice();
        System.out.println(calc.additionner(2, 3));  // Appel de la méthode avec deux paramètres
        System.out.println(calc.additionner(2, 3, 4));  // Appel de la méthode avec trois paramètres
    }
}
```

Dans cet exemple, la méthode `additionner()` est surchargée pour accepter soit deux, soit trois paramètres.

---

## 3. Polymorphisme à l'exécution (héritage)
Le polymorphisme à l'exécution permet d'utiliser une classe parente pour faire référence à un objet de la classe fille. Cela permet de traiter plusieurs types d'objets de manière uniforme tout en ayant un comportement spécifique selon la classe de l'objet.

### Exemple avec héritage :
```java
class Animal {
    void faireDuBruit() {
        System.out.println("L'animal fait du bruit.");
    }
}

class Chien extends Animal {
    @Override
    void faireDuBruit() {
        System.out.println("Le chien aboie.");
    }
}

class Chat extends Animal {
    @Override
    void faireDuBruit() {
        System.out.println("Le chat miaule.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal monAnimal = new Chien();  // Polymorphisme
        monAnimal.faireDuBruit();  // Le chien aboie

        monAnimal = new Chat();  // Polymorphisme
        monAnimal.faireDuBruit();  // Le chat miaule
    }
}
```

Dans cet exemple, bien que l'objet soit traité comme un `Animal`, la méthode spécifique à la classe (`Chien` ou `Chat`) est appelée grâce au polymorphisme.

---

## 4. Polymorphisme avec les interfaces
Le polymorphisme peut également être réalisé à l'aide d'**interfaces**, où une classe peut implémenter plusieurs interfaces différentes et donc être utilisée de plusieurs manières.

### Exemple avec une interface :
```java
interface Volant {
    void voler();
}

class Avion implements Volant {
    public void voler() {
        System.out.println("L'avion vole.");
    }
}

class Oiseau implements Volant {
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}

public class Main {
    public static void main(String[] args) {
        Volant v1 = new Avion();
        v1.voler();  // L'avion vole

        Volant v2 = new Oiseau();
        v2.voler();  // L'oiseau vole
    }
}
```

Dans cet exemple, l'interface `Volant` est utilisée pour traiter différents types d'objets (avion et oiseau) qui implémentent chacun la méthode `voler()`.

---

## 5. Avantages du polymorphisme
- **Réutilisation du code** : Le polymorphisme permet d'écrire du code générique qui peut fonctionner avec différents types d'objets.
- **Extensibilité** : Vous pouvez ajouter de nouveaux types d'objets sans modifier le code existant.
- **Simplification** : Il permet de traiter différents objets de manière uniforme, réduisant ainsi la complexité du code.

---

## Exercices Pratiques

### Exercice 1 : Surcharge de méthodes
1. Créez une classe `Calculatrice` avec deux méthodes `soustraction()`, l'une acceptant deux paramètres et l'autre acceptant trois paramètres.
2. Dans la méthode `main()`, testez la surcharge de méthodes en appelant ces deux versions.

### Exercice 2 : Polymorphisme avec héritage
1. Créez une classe `Animal` avec une méthode `faireDuBruit()`.
2. Créez deux classes filles `Vache` et `Cheval` qui redéfinissent cette méthode.
3. Utilisez le polymorphisme dans la méthode `main()` pour créer des objets `Vache` et `Cheval` et appelez la méthode `faireDuBruit()`.

### Exercice 3 : Polymorphisme avec interfaces
1. Créez une interface `Nageur` avec une méthode `nager()`.
2. Créez deux classes `Poisson` et `Humain` qui implémentent cette interface.
3. Dans la méthode `main()`, utilisez l'interface `Nageur` pour créer des objets `Poisson` et `Humain`, et appelez la méthode `nager()`.

---

Ce cours vous a présenté le polymorphisme en Java, qu'il soit à la compilation ou à l'exécution, ainsi que son utilisation avec les classes et les interfaces. Les exercices vous permettront de pratiquer ces concepts pour les maîtriser.
