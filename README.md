## Test technique JAVA

# Sujet
La société climax souhaite développer une application dans le but d’effectuer des rapports statistiques sur ses clients. Les données prises en compte sont l’identité, le niveau de revenu et la profession.
Ces données sont mises à disposition par les partenaires via des fichiers texte, csv, xml ou json. L’application souhaitée doit pouvoir intégrer tous ces formats de fichiers et éventuellement ceux non cités ici.

#### Proposer une solution répondant à ce besoin. Cette solution doit pouvoir lire tous types de fichiers. Elle doit être robuste et évolutive.
#### On souhaite calculer la moyenne des salaires par type de profession.

#### Donnees
Zous, Adrien, 25, informaticien, 35 ;
Ducroc, Mathilde, 32, informaticien,38 ;
Joy, Bruno, 29, comptable, 33 ;
Basr, Julien, 43, policier, 24 ;
Bouaz, Teff, 52, boulanger,45 ;
Leroy, Ben,48, comptable, 26 ;
Beroy, Celine, 28, comptable, 37 ;

## Structuration
### Division en Classe

# Client
La classe client sert a contenir toutes les informations sur les clients.

# FileReaders
Celle-ci permet de creer une liste de nouveaux client a partir d'un fichier json, csv, txt ou xml...

# Statistics
Elle permet de calculer la moyenne des salaires sur la base d'une liste de client

