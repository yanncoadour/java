
# Cours 26 : Créer et utiliser des exceptions personnalisées en Java

## Objectifs :
- Comprendre comment créer des exceptions personnalisées en Java
- Apprendre à utiliser les exceptions personnalisées pour gérer des erreurs spécifiques à votre application
- Découvrir les bonnes pratiques pour la création et l'utilisation d'exceptions personnalisées

---

## 1. Pourquoi créer des exceptions personnalisées ?
Les **exceptions personnalisées** permettent de mieux gérer les erreurs spécifiques à votre application ou domaine d'activité. Plutôt que de se limiter aux exceptions génériques comme `IOException` ou `NullPointerException`, les exceptions personnalisées offrent une manière plus claire de signaler des conditions d'erreur particulières.

---

## 2. Créer une exception personnalisée
Pour créer une exception personnalisée en Java, vous devez créer une nouvelle classe qui étend la classe `Exception` (pour une exception vérifiée) ou `RuntimeException` (pour une exception non vérifiée).

### Exemple d'une exception vérifiée personnalisée :
```java
class SoldeInsuffisantException extends Exception {
    public SoldeInsuffisantException(String message) {
        super(message);
    }
}
```

Dans cet exemple, nous avons créé une exception personnalisée `SoldeInsuffisantException` qui est une exception vérifiée.

### Exemple d'une exception non vérifiée personnalisée :
```java
class DonneeInvalideException extends RuntimeException {
    public DonneeInvalideException(String message) {
        super(message);
    }
}
```

Ici, `DonneeInvalideException` est une exception non vérifiée, car elle étend `RuntimeException`.

---

## 3. Utiliser une exception personnalisée
Une fois que vous avez créé une exception personnalisée, vous pouvez l'utiliser de la même manière que n'importe quelle autre exception.

### Exemple d'utilisation d'une exception personnalisée :
```java
class CompteBancaire {
    private double solde;

    public CompteBancaire(double solde) {
        this.solde = solde;
    }

    public void retirer(double montant) throws SoldeInsuffisantException {
        if (montant > solde) {
            throw new SoldeInsuffisantException("Solde insuffisant pour retirer " + montant);
        }
        solde -= montant;
    }

    public double getSolde() {
        return solde;
    }
}

public class Main {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire(100);

        try {
            compte.retirer(150);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Solde actuel : " + compte.getSolde());
    }
}
```

Dans cet exemple, la méthode `retirer()` jette une exception personnalisée `SoldeInsuffisantException` si le montant à retirer est supérieur au solde du compte.

---

## 4. Exceptions vérifiées vs non vérifiées pour les exceptions personnalisées
Lorsque vous créez des exceptions personnalisées, vous pouvez choisir d'étendre `Exception` (exception vérifiée) ou `RuntimeException` (exception non vérifiée), selon le type d'erreur que vous voulez signaler.

- **Exceptions vérifiées** : Utilisées pour signaler des erreurs que le programme peut gérer ou anticiper, et qui nécessitent un traitement explicite.
- **Exceptions non vérifiées** : Utilisées pour signaler des erreurs de programmation, comme des données invalides ou des erreurs logiques.

### Quand utiliser les exceptions vérifiées :
- Lorsque l'erreur fait partie du flux normal de l'application et qu'elle doit être anticipée (exemple : `SoldeInsuffisantException`).

### Quand utiliser les exceptions non vérifiées :
- Lorsque l'erreur est due à une mauvaise utilisation ou à des erreurs logiques qui ne devraient pas se produire dans des conditions normales (exemple : `DonneeInvalideException`).

---

## 5. Bonnes pratiques pour les exceptions personnalisées

1. **Hériter de la bonne classe** : Si vous voulez une exception vérifiée, héritez de `Exception`. Si vous voulez une exception non vérifiée, héritez de `RuntimeException`.
2. **Fournir des messages clairs** : Utilisez des messages d'erreur clairs et significatifs pour faciliter le débogage.
3. **Ne pas abuser des exceptions personnalisées** : Utilisez les exceptions personnalisées uniquement lorsque les exceptions Java standard ne conviennent pas à votre besoin.
4. **Ne pas utiliser les exceptions pour le flux de contrôle** : Les exceptions doivent être utilisées pour gérer des erreurs, et non comme mécanisme de flux de contrôle dans votre programme.

---

## Exercices Pratiques

### Exercice 1 : Créer une exception personnalisée vérifiée
1. Créez une exception `ProduitIndisponibleException` qui est une exception vérifiée.
2. Dans une classe `Magasin`, créez une méthode `acheterProduit()` qui jette cette exception lorsque le produit n'est pas disponible.

### Exercice 2 : Créer une exception non vérifiée
1. Créez une exception `DonneeInvalideException` qui est une exception non vérifiée.
2. Utilisez cette exception dans une méthode qui valide des données utilisateur.

---

Ce cours vous a montré comment créer et utiliser des exceptions personnalisées en Java. Vous avez appris à les utiliser pour gérer des erreurs spécifiques à vos applications, ainsi que les bonnes pratiques pour les implémenter efficacement. Les exercices vous permettront de pratiquer et de mieux comprendre ces concepts.
