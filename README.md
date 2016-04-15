# Java-Project

Projet Java
*Sujet:
La société STRI souhaite mettre en place un service de discussion (chat) entre collaborateurs. Ce service permet à un collaborateur d’écrire dans un salon en fonction des droits qu’il possède. Un outil de management des droits permet à l’administrateur de créer et régler les autorisations pour un collaborateur. On veut pouvoir créer et donner une description au salon.

Exemple d’utilisation :
  • L’administrateur veut créer un salon et affecter certains collaborateurs avec un collaborateur qui a le droit d’écrire.
  • On voudrait mémoriser les vieux messages d’un salon.
  • On veut pouvoir lorsqu’on est sur un salon savoir qui est connecté dans le même salon
  • On veut pouvoir se déclarer absent sur le salon.
  • On peut vouloir envoyer un message privé à un autre collaborateur.
  
Travail demandé :

Ce document décrit les étapes proposées pour développer le logiciel demandé.
Le travail demandé nécessite quatre personnes, minimum trois. Il demande une intégration de nombreux concepts vus dans divers cours.

Les séances proposées pour développer ce projet ne vous dispensent pas de travailler chez vous.
Une évaluation aura lieu avant la fin du semestre (date à préciser)
Phase préliminaire : A faire obligatoirement en première séance :
Création d’un projet sur github (cf Travail Collaboratif), utilisation et vérification du fonctionnement.
Elaboration d’un projet maven (cf Travail Collaboratif).

Phase modélisation :
Il vous faudra modéliser les besoins (classes, cas d’utilisation) et sélectionner les diagrammes UML pertinents. Les modèles devront être publiés sur votre projet github.
Le stockage des données doit être fait à l’aide d’une base de données, préparer les schémas et publier les dans votre projet github.

Phase de réalisation :
Vous devez créer des interfaces utilisateurs permettant une utilisation conviviale de votre système.
Votre code devra être commenté, javadoc obligatoire. Les auteurs des classes devront être dans la javadoc. La javadoc devra être activée dans le projet maven.
Vous devez regarder comment utiliser une base de données en java (mysql ou postgres) afin de stocker les informations sur les droits des collaborateurs et également les messages sur les salons.
Il convient de générer des classes utilitaires permettant de créer les tables, un jeu de données dans la base de données, ou d’effacer les données pour faciliter les tests.

Phase de rédaction :

Le rapport devra être publié dans le projet github.
Le rapport comprendra:
  • Un paragraphe qui reformule les besoins.
  • L’organisation de travail, c’est-à-dire la répartition des tâches au sein des groupes.
  • La modélisation UML des besoins.
  • Un mini manuel utilisateur, permettant à un novice de prendre en main votre logiciel.
Travail collaboratif :
Afin de réaliser un travail collaboratif de qualité vous allez utiliser un système de gestion de version de code. Ces systèmes permettent à plusieurs personnes de contribuer à un même projet.
Dans le cadre du projet vous devrez créer ou utiliser un compte github (https://github.com/) dans le but de créer un projet. Github est également un réseau social, il convient de rester prudent dans son utilisation.
Afin de faciliter la maintenance de votre code il est préférable d’organiser les fichiers sources selon une organisation standard, en java une des plus communes est maven. (https://maven.apache.org)
Maven permet de générer un site contenant la javadoc et les résultats des tests unitaires (si configuré).
