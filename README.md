## Hibernate Exo 01 (Magasin)
 
#### Contexte :
Un magasin souhaite développer une application pour ses clients, ses ventes et son inventaire. 
L'application doit permettre aux employés de suivre les stocks des articles, de gérer les ventes et de tenir à jour les informations des clients.
 
#### Fonctionnalités attendues :
1. **Gestion de l'inventaire :**
   - Permettre d'ajouter, de modifier, de supprimer, de consulter des articles.
   - Chaque article doit avoir un identifiant unique, un nom, une description, un prix, une quantité en stock et une date de restockage.
   - Permettre de restocker des articles (mettre à jour la quantité en stock et actualiser la date de restockage).
   - Les articles peuvent être de différentes natures :
     - Articles de nourriture avec une date de péremption.
     - Articles électroniques avec une durée de batterie.
     - Articles de mode avec une catégorie (homme, femme, enfant) et une taille.
 
2. **Gestion des ventes :**
   - Permettre d'enregistrer des ventes.
   - Chaque vente doit avoir un état (en cours, finalisée, annulée).
   - Permettre de suivre l'état des ventes.
 
3. **Gestion des clients :**
   - Permettre d'ajouter, de modifier, de supprimer, de consulter des clients.
   - Chaque client doit avoir un identifiant unique, un nom, une adresse email et un historique des achats.
 
4. **Rapports et analyses :**
   - Fournir les ventes par article, par client et par période.
