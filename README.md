# Gestion des Étudiants avec JDBC

Ce projet est une application de gestion d'étudiants développée en Java avec une base de données MySQL. Il démontre l'utilisation de JDBC pour les opérations CRUD (Create, Read, Update, Delete) sur une base de données relationnelle.

## 📋 Prérequis

- Java JDK 11 ou supérieur
- MySQL Server 8.0 ou supérieur
- MySQL Connector/J (inclus dans le projet)
- Maven (pour la gestion des dépendances)

## 🛠 Configuration de la base de données

1. Créez une base de données MySQL nommée `testDB` :
   ```sql
   CREATE DATABASE testDB;
   ```

2. Créez la table `test` avec la structure suivante :
   ```sql
   USE testDB;
   CREATE TABLE test (
       id INT PRIMARY KEY,
       nom VARCHAR(100) NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL,
       moyenne DECIMAL(4,2) CHECK (moyenne >= 0 AND moyenne <= 20)
   );
   ```

## 🏗 Structure du projet

```
src/
├── main/
│   └── java/
│       └── tp/
│           ├── app/
│           │   ├── AppEtudiants.java    # Application console principale
│           │   ├── Test.java
│           │   └── TestCollections.java
│           ├── dao/
│           │   ├── ConnexionBD.java     # Gestion de la connexion à la base de données
│           │   ├── Etudiantdao.java     # DAO pour les opérations CRUD
│           │   └── TestDao.java
│           └── model/
│               ├── Etudiant.java        # Classe métier Étudiant
│               └── TriParMoyenne.java   # Comparateur pour le tri par moyenne
```

## 🚀 Compilation et exécution

1. Compilation :
   ```bash
   javac -d out/production/Collections-JDBC -cp ".:./lib/mysql-connector-j-8.0.33.jar" src/tp/app/AppEtudiants.java
   ```

2. Exécution :
   ```bash
   java -cp "out/production/Collections-JDBC:./lib/mysql-connector-j-8.0.33.jar" tp.app.AppEtudiants
   ```

## ✨ Fonctionnalités

- 📋 Lister tous les étudiants
- 🔍 Rechercher un étudiant par ID
- 📊 Filtrer les étudiants par moyenne minimale
- ➕ Ajouter un nouvel étudiant
- ✏️ Modifier la moyenne d'un étudiant

## 🎯 Utilisation

1. **Lister tous les étudiants** : Affiche la liste complète des étudiants
2. **Rechercher un étudiant** : Trouve un étudiant par son ID
3. **Filtrer par moyenne** : Affiche les étudiants ayant une moyenne supérieure ou égale à la valeur saisie
4. **Ajouter un étudiant** : Ajoute un nouvel étudiant à la base de données
5. **Modifier une moyenne** : Met à jour la moyenne d'un étudiant existant
0. **Quitter** : Ferme l'application

## 📦 Dépendances

- MySQL Connector/J 8.0.33
- Java SE 11+

## 👨‍💻 Auteur

- **Anounou Imrane**
- Email: imraneanounou37@gmail.com

## 📝 Encadree par
M.ERRAJI
