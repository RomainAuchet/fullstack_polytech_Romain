import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Acteur } from './acteur.model';
import { catchError, Observable, throwError } from 'rxjs';
import { Film } from './film.model';

@Service()
export class ActeurService {
    private http = inject(HttpClient);
    private url = '/api/acteurs';

    getAll(): Observable<Acteur[]> {
    return this.http.get<Acteur[]>(this.url).pipe(catchError(this.handleError));
    }

    getById(id: number): Observable<Acteur> {
    return this.http.get<Acteur>(`${this.url}/${id}`).pipe(catchError(this.handleError));
    }

    getFilms(id: number): Observable<Film[]> {
        return this.http.get<Film[]>(`${this.url}/${id}/films`).pipe(catchError(this.handleError));
    }

    creer(a: Partial<Acteur>) {
    return this.http.post<Acteur>(this.url, a).pipe(catchError(this.handleError));
    }
    modifier(id: number, a: Acteur) {
    return this.http.put<Acteur>(`${this.url}/${id}`, a).pipe(catchError(this.handleError));
    }
    supprimer(id: number) {
    return this.http.delete<void>(`${this.url}/${id}`).pipe(catchError(this.handleError));
    }
    private handleError(error: any) {
        console.error('Erreur API', error);
        return throwError(() => new Error(error.error?.detail || 'Erreur serveur'));
    }
}
