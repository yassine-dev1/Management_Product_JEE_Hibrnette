<h1>Desktop Project Using Hibernate</h1>
Application desktop de gestion complète d'un magasin (produits, clients, fournisseurs, commandes et stocks) développée en **Java**, **Hibernate** et **Java Swing**.

## 📖 Description

Ce projet est une application desktop robuste dédiée à la gestion d'un magasin. Elle permet de piloter l'activité commerciale en gérant les clients, les produits, les fournisseurs et les commandes. L'application est construite en Java avec une architecture multicouche pour garantir la maintenabilité et l'évolutivité du code.
Elle permet de :

- Gérer le catalogue produits 
- Administrer les fournisseurs
- Suivre les clients
- Enregistrer et suivre les commandes clients
- Maintenir une traçabilité complète des opérations

L’application adopte une **architecture multicouche propre** et maintenable.

## 🏗️ Architecture

- **Modèle** : Entités métier (JPA/Hibernate)
- **Vue** : Interface graphique réalisée avec **Java Swing**
- **Contrôleur** : Logique métier et coordination Vue ↔ Modèle
- **DAO** : Couche d’accès aux données (Data Access Object) avec Hibernate
- **DTO** : Objets de transfert pour découpler les couches et éviter d’exposer les entités persistantes

## 🚀 Technologies utilisées

| Technologie           | Version / Rôle                                 |
|-----------------------|------------------------------------------------|
| Java                  | version 17           
| Hibernate             | ORM – persistance JPA                          |
| MySQL                 | Base de données relationnelle (version 8.0.33) |
| Java Swing            | Interface graphique utilisateur                |
| Maven                 | Gestion des dépendances                        |
                              
## ⚙️ Installation et Configuration
Base de données :

Créez une base de données MySQL nommée mydb.

Configuration Hibernate :

Modifiez le fichier dans le dossier configuration/hibernate.cfg.xml avec vos identifiants MySQL :

Exécution :

Lancez l'application via la classe principale : src/main/java/view/Form_Main.java.

## 🛠️ Fonctionnalités clés
Gestion des Stocks : Ajout, modification et suppression de produits et fournisseurs.

Suivi et gestion des  Clients : Base de données centralisée des clients ainsi la  gestion < ajout , modification , suppression >.

Passage de Commandes : Processus complet de création de commandes liées aux clients et produits.

Persistance des données : Sauvegarde automatique et cohérente grâce à Hibernate.

## ✨ Prochaines étapes suggérées

[ ] Migration vers JavaFX pour une interface plus moderne.

[ ] Ajout d'un tableau de bord (Dashboard) avec statistiques de ventes.
