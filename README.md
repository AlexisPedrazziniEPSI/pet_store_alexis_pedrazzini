# Projet PetStore

Ce projet est un exemple d'application Java utilisant JPA (Java Persistence API) avec Hibernate pour gérer une base de données de animaleries (PetStore).

## Structure du projet

Le projet est structuré comme suit :

- `src/main/java/entities`: Contient les classes d'entités JPA qui sont mappées aux tables de la base de données.
    - `Animal.java`: Classe de base pour les animaux.
    - `Cat.java`: Entité pour les chats, hérite de `Animal`.
    - `Fish.java`: Entité pour les poissons, hérite de `Animal`.
    - `PetStore.java`: Entité pour les animaleries.
    - `Product.java`: Entité pour les produits vendus dans les animaleries.
    - `Address.java`: Entité pour les adresses des animaleries.
    - `enums`: Contient les énumérations pour les types de produits et l'environnement de vie des poissons.

- `src/main/java/functions`: Contient la classe principale pour exécuter l'application.
    - `Main.java`: Contient la logique pour insérer des données de test et exécuter une requête.

- `src/main/resources/META-INF`: Contient le fichier de configuration de la persistance.
    - `persistence.xml`: Fichier de configuration pour JPA et Hibernate, y compris les informations de connexion à la base de données.

## Comment exécuter le projet

1.  **Configurer la base de données**: Assurez-vous d'avoir une base de données MariaDB en cours d'exécution. Les informations de connexion se trouvent dans `src/main/resources/META-INF/persistence.xml`. Vous pouvez les modifier si nécessaire.

    ```xml
    <property name="javax.persistence.jdbc.url" value="jdbc:mariadb://localhost:3306/petstore" />
    <property name="javax.persistence.jdbc.user" value="root" />
    <property name="javax.persistence.jdbc.password" value="" />
    ```

2.  **Exécuter la classe Main**: Exécutez la méthode `main` dans la classe `functions.Main`. Cela va :
    - Créer les tables de la base de données (si elles n'existent pas).
    - Insérer des données de test pour les produits, les animaleries et les animaux.
    - Exécuter une requête pour trouver tous les animaux d'une animalerie spécifique et afficher les résultats dans la console.
