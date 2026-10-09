import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Film } from './film.model';
import { catchError, Observable, throwError } from 'rxjs';

@Service()
export class FilmService {
    private http = inject(HttpClient);
    private url = '/api/films';
    getAll() { return this.http.get<Film[]>(this.url).pipe(catchError(this.handleError));

    }
    getById(id: number) {
    return this.http.get<Film>(`${this.url}/${id}`).pipe(catchError(this.handleError));
    }
    creer(f: Partial<Film>) {
    return this.http.post<Film>(this.url, f).pipe(catchError(this.handleError));
    }
    modifier(id: number, f: Film) {
    return this.http.put<Film>(`${this.url}/${id}`, f).pipe(catchError(this.handleError));
    }
    supprimer(id: number) {
    return this.http.delete<void>(`${this.url}/${id}`).pipe(catchError(this.handleError));
    }

    associerActeur(filmId: number, acteurId: number): Observable<void> {
        return this.http.post<void>(`${this.url}/${filmId}/acteurs/${acteurId}`, {}).pipe(catchError(this.handleError));
    }

    dissocierActeur(filmId: number, acteurId: number): Observable<void> {
        return this.http.delete<void>(`${this.url}/${filmId}/acteurs/${acteurId}`).pipe(catchError(this.handleError));
    }
    private handleError(error: any) {
        console.error('Erreur API', error);
        return throwError(() => new Error(error.error?.detail || 'Erreur serveur'));
    }

}
