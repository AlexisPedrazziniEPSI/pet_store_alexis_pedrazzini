# Projet PetStore

Ce projet est un exemple d'application Java utilisant JPA (Java Persistence API) avec Hibernate pour gérer une base de données de animaleries (PetStore).

## Auteurs
*   **Alexis Pedrazzini**

## Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé :
*   **Java JDK 25** (ou une version compatible définie dans le `pom.xml`)
*   **Maven**
*   **MariaDB** (ou un autre serveur de base de données compatible MySQL)

## Dépendances

Le projet utilise les dépendances suivantes (définies dans le `pom.xml`) :

*   **MariaDB Java Client** (`org.mariadb.jdbc:mariadb-java-client:2.7.2`) : Pilote JDBC pour se connecter à la base de données MariaDB.
*   **Hibernate ORM Core** (`org.hibernate.orm:hibernate-core:6.5.2.Final`) : Implémentation de JPA pour la persistance des données.

## Configuration de la Base de Données

1.  Créez une base de données vide nommée `petstore` dans votre serveur MariaDB.
2.  Vérifiez et modifiez si nécessaire les informations de connexion dans le fichier `src/main/resources/META-INF/persistence.xml` :

    ```xml
    <property name="javax.persistence.jdbc.url" value="jdbc:mariadb://localhost:3306/petstore" />
    <property name="javax.persistence.jdbc.user" value="root" />
    <property name="javax.persistence.jdbc.password" value="" />
    ```

## Structure du projet

Le projet est structuré comme suit :

- `src/main/java/entities`: Contient les classes d'entités JPA qui sont mappées aux tables de la base de données.
    - `Animal.java`: Classe de base pour les animaux (Stratégie d'héritage : JOINED).
    - `Cat.java`: Entité pour les chats.
    - `Fish.java`: Entité pour les poissons.
    - `PetStore.java`: Entité pour les animaleries.
    - `Product.java`: Entité pour les produits.
    - `Address.java`: Entité pour les adresses.
    - `enums`: Contient les énumérations (`ProdType`, `FishLivEnv`).

- `src/main/java/functions`: Contient la classe principale.
    - `Main.java`: Exécute la création des tables, l'insertion des données de test et une requête d'exemple.

- `src/main/resources/META-INF`:
    - `persistence.xml`: Configuration de l'unité de persistance "petstore".

## Comment exécuter le projet

1.  **Compiler le projet** avec Maven :
    ```bash
    mvn clean install
    ```

2.  **Lancer l'application** :
    Exécutez la méthode `main` de la classe `functions.Main` depuis votre IDE ou via la ligne de commande.

    L'application va automatiquement :
    - Supprimer et recréer le schéma de base de données (`drop-and-create`).
    - Insérer 3 produits, 3 animaleries et plusieurs animaux.
    - Afficher dans la console la liste des animaux appartenant à la première animalerie ("PetStore Paris").
