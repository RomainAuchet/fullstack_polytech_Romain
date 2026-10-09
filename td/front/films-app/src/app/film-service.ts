import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Film } from './film.model';
import { catchError, Observable, throwError } from 'rxjs';

@Service()
export class FilmService {
    private http = inject(HttpClient);
    private url = '/api/films';
    getAll() { return this.http.get<Film[]>(this.url); }
    getById(id: number) {
    return this.http.get<Film>(`${this.url}/${id}`);
    }
    creer(f: Partial<Film>) {
    return this.http.post<Film>(this.url, f);
    }
    modifier(id: number, f: Film) {
    return this.http.put<Film>(`${this.url}/${id}`, f);
    }
    supprimer(id: number) {
    return this.http.delete<void>(`${this.url}/${id}`);
    }

    associerActeur(filmId: number, acteurId: number): Observable<void> {
        return this.http.post<void>(`${this.url}/${filmId}/acteurs/${acteurId}`, {});
    }

    dissocierActeur(filmId: number, acteurId: number): Observable<void> {
        return this.http.delete<void>(`${this.url}/${filmId}/acteurs/${acteurId}`);
    }

}
