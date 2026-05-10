# Heme Biotech Analytics

Projet Java réalisé dans le cadre d'une formation OpenClassrooms.

L'objectif du projet est de corriger, nettoyer et réorganiser une application Java existante permettant d'analyser une liste de symptômes.  
Le programme lit un fichier texte contenant des symptômes, compte le nombre d'occurrences de chaque symptôme, puis génère un fichier de sortie trié par ordre alphabétique.

## Contexte du projet

Heme Biotech souhaite améliorer la prédiction des besoins de ses clients, médecins comme vétérinaires, en analysant les tendances observées dans les effets secondaires signalés par les patients.

Une première version du programme avait été commencée, mais elle comportait plusieurs problèmes :

- le décompte des symptômes était incorrect ;
- le résultat généré n'était pas trié alphabétiquement ;
- le code était difficile à maintenir ;
- la logique était concentrée dans une seule classe ;
- certaines ressources n'étaient pas correctement fermées ;
- le code ne respectait pas suffisamment les principes de la programmation orientée objet.

Le but de ce projet est donc de fournir une version fonctionnelle, plus lisible et plus maintenable.

## Fonctionnalités

L'application permet de :

- lire les symptômes depuis un fichier texte ;
- compter automatiquement le nombre d'occurrences de chaque symptôme ;
- trier les symptômes par ordre alphabétique ;
- générer un fichier `result.out` contenant le résultat de l'analyse ;
- séparer les responsabilités entre la lecture, le traitement et l'écriture des données.

## Exemple de résultat attendu

Le fichier généré contient les symptômes triés alphabétiquement avec leur nombre d'occurrences :

```txt
anxiety: 5
arrhythmias: 3
blindness: 1
blurred vision: 5
headache: 3
high blood pressure: 10
rash: 4
```

## Technologies utilisées

- Java
- Programmation orientée objet
- Lecture et écriture de fichiers
- Collections Java :
  - `List`
  - `Map`
  - `HashMap`
  - `TreeMap`

Aucun framework externe n'est nécessaire pour exécuter ce projet.

## Structure du projet

```txt
Project02Eclipse/
├── symptoms.txt
└── src/
    └── com/
        └── hemebiotech/
            └── analytics/
                ├── Main.java
                ├── AnalyticsCounter.java
                ├── ISymptomReader.java
                ├── ReadSymptomDataFromFile.java
                ├── ISymptomWriter.java
                └── WriteSymptomDataToFile.java
```

## Rôle des principales classes

### `Main`

Point d'entrée de l'application.

Cette classe initialise :

- le fichier d'entrée `symptoms.txt` ;
- le fichier de sortie `result.out` ;
- le lecteur de symptômes ;
- le writer chargé d'écrire le résultat ;
- le service principal `AnalyticsCounter`.

### `AnalyticsCounter`

Classe centrale du traitement.

Elle coordonne les différentes étapes :

1. récupération des symptômes ;
2. comptage des occurrences ;
3. tri alphabétique ;
4. écriture du résultat dans le fichier de sortie.

### `ISymptomReader`

Interface qui définit le contrat de lecture des symptômes.

Elle permet de découpler la logique métier de la source de données.  
Aujourd'hui, les symptômes sont lus depuis un fichier texte, mais une autre source pourrait être ajoutée plus tard.

### `ReadSymptomDataFromFile`

Implémentation de `ISymptomReader`.

Cette classe lit le fichier `symptoms.txt` ligne par ligne et retourne une liste de symptômes.

### `ISymptomWriter`

Interface qui définit le contrat d'écriture des résultats.

Elle permet de séparer la logique de traitement de la logique d'écriture.

### `WriteSymptomDataToFile`

Implémentation de `ISymptomWriter`.

Cette classe écrit les symptômes et leurs occurrences dans le fichier `result.out`.

## Fonctionnement global

Le fonctionnement de l'application peut être résumé ainsi :

```txt
symptoms.txt
    ↓
ReadSymptomDataFromFile
    ↓
AnalyticsCounter
    ↓
Comptage avec HashMap
    ↓
Tri alphabétique avec TreeMap
    ↓
WriteSymptomDataToFile
    ↓
result.out
```

## Lancer le projet

### Depuis un IDE

Le projet peut être importé dans un IDE Java comme IntelliJ IDEA ou Eclipse.

Il suffit ensuite d'exécuter la classe :

```txt
com.hemebiotech.analytics.Main
```

Le programme lit le fichier :

```txt
Project02Eclipse/symptoms.txt
```

Puis génère le fichier :

```txt
result.out
```

à la racine du projet.

### Depuis le terminal

Depuis la racine du dépôt, compiler les fichiers Java :

```bash
javac -d out Project02Eclipse/src/com/hemebiotech/analytics/*.java
```

Puis lancer l'application :

```bash
java -cp out com.hemebiotech.analytics.Main
```

Après l'exécution, le fichier `result.out` est généré à la racine du projet.

## Exemple de fichier d'entrée

Le fichier `symptoms.txt` contient un symptôme par ligne :

```txt
headache
rash
headache
high blood pressure
rash
headache
```

## Exemple de fichier de sortie

Après traitement, le fichier `result.out` contient les symptômes triés par ordre alphabétique :

```txt
headache: 3
high blood pressure: 1
rash: 2
```

## Corrections et améliorations apportées

Le code initial a été corrigé et réorganisé afin de répondre aux besoins du projet.

Les principales améliorations sont :

- correction du calcul des occurrences ;
- suppression de la logique trop rigide basée sur une liste fixe de symptômes ;
- utilisation d'une `Map` pour gérer dynamiquement les symptômes rencontrés ;
- utilisation d'un `TreeMap` pour trier automatiquement les résultats par ordre alphabétique ;
- séparation des responsabilités entre lecture, traitement et écriture ;
- ajout d'une interface pour la lecture des données ;
- ajout d'une interface pour l'écriture des résultats ;
- amélioration de la lisibilité du code ;
- ajout de commentaires Javadoc ;
- nettoyage des commentaires inutiles ;
- meilleure organisation orientée objet.

## Choix techniques

### Utilisation de `HashMap`

Une `HashMap` est utilisée pour compter les occurrences des symptômes.

Chaque symptôme est utilisé comme clé, et le nombre d'occurrences est stocké comme valeur.

Exemple :

```txt
headache -> 3
rash -> 4
high blood pressure -> 10
```

Cette approche permet de gérer automatiquement tous les symptômes présents dans le fichier, sans avoir besoin de connaître leur nom à l'avance.

### Utilisation de `TreeMap`

Une `TreeMap` est utilisée pour trier les symptômes par ordre alphabétique avant l'écriture du fichier de sortie.

Cela permet de respecter le besoin fonctionnel demandé pour le fichier `result.out`.

### Séparation des responsabilités

Le projet a été découpé en plusieurs classes afin d'éviter d'avoir toute la logique dans une seule méthode.

Cette organisation rend le code :

- plus simple à lire ;
- plus facile à maintenir ;
- plus facile à faire évoluer ;
- plus conforme aux principes de la programmation orientée objet.

## Améliorations possibles

Quelques améliorations pourraient être ajoutées par la suite :

- permettre de choisir le fichier d'entrée via les arguments de la ligne de commande ;
- permettre de choisir le fichier de sortie via les arguments de la ligne de commande ;
- ajouter des tests unitaires ;
- améliorer la gestion des erreurs avec des messages plus explicites ;
- ignorer les lignes vides du fichier d'entrée ;
- normaliser les symptômes pour éviter les doublons liés aux majuscules ou aux espaces ;
- transformer le projet en projet Maven ou Gradle pour faciliter la compilation.

## Auteur

Projet réalisé par Guillaume S. dans le cadre d'une formation OpenClassrooms.
