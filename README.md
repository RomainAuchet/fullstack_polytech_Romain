# Développement Fullstack — Polytech

Bienvenue dans mon projet Fullstack !

Il consiste en une bibliothèque de films où l'on peut ajouter/supprimer/modifier des films ainsi qu'associer ou dissocier des acteurs de leurs films. 

## Structure

    tp/
      back/   
      front/    
    td/
      back/     TD : API REST de la bibliothèque de films
        http/   requêtes HTTP, exécutées avec l'extension VSCode REST Client
      front/    TD : front Angular de la bibliothèque de films

## Prérequis

Il est necessaire d'avoir :

• JDK 26  
• Gradle 9
• PostgreSQL avec cette config :
    ```yaml
    url: jdbc:postgresql://localhost:5432/filmdb
    username: backuser2
    password: password
    ```

• REST Client

## Démarrage

Pour lancer le projet : 

Etape 1 : Démarrer le backend (port 8080)
Depuis la racine du projet : 

  ```bash
  cd td/back
  ./gradlew bootRun
```

Etape 2. Démarrer le front (port 4200) 
Depuis la racine du projet : 

 ```bash
  cd td/front/films-app
  ng serve
```

Vous pouvez ensuite ouvrir le site sur un navigateur via : http://localhost:4200/films
Les appels api sont envoyés au back via `proxy.conf.json`.

## Fonctionnalités et Endpoints :

### Ressource : Films (/api/films)

| Méthode | Endpoint | Description | Code de réponse |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/films` | Liste de tous les films enregistrés dans la db | `200 OK` |
| **GET** | `/api/films/{id}` | Les détails d'un film avec son ID et ses acteurs associés | `200 OK` / `404 Not Found` |
| **POST** | `/api/films` | Crée un nouveau film dans la db | `201 Created` |
| **PUT** | `/api/films/{id}` | Met à jour les informations d'un film déjà existant | `200 OK` / `404 Not Found` |
| **DELETE** | `/api/films/{id}` | Supprime un film avec son ID | `204 No Content` |

---

### Ressource : Acteurs (/api/acteurs)

| Méthode | Endpoint | Description | Code de réponse |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/acteurs` | Récupère la liste de tous les acteurs | `200 OK` |
| **GET** | `/api/acteurs/{id}` | Récupère les détails d'un acteur spécifique | `200 OK` / `404 Not Found` |
| **POST** | `/api/acteurs` | Crée un nouvel acteur | `201 Created` |
| **PUT** | `/api/acteurs/{id}` | Met à jour les informations d'un acteur déjà existant | `200 OK` / `404 Not Found` |
| **DELETE** | `/api/acteurs/{id}` | Supprime un acteur avec son ID | `204 No Content` |
| **GET** | `/api/acteurs/{id}/films` | Récupère la liste des films auxquels un acteur spécifique a participé | `200 OK` / `404 Not Found` |

---

### Relations : Association Film / Acteur

| Méthode | Endpoint | Description | Code de réponse |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/films/{id}/acteurs/{acteurId}` | Associe un acteur existant à un film | `200 OK` / `204 No Content` |
| **DELETE** | `/api/films/{id}/acteurs/{acteurId}` | Dissocie un acteur d'un film | `204 No Content` |

Ces endpoints sont donc tous utilisés en tant que fonctionnalités sur le site.
