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
    return this.http.get<Acteur[]>(this.url);
    }

    getById(id: number): Observable<Acteur> {
    return this.http.get<Acteur>(`${this.url}/${id}`);
    }

    getFilms(id: number): Observable<Film[]> {
        return this.http.get<Film[]>(`${this.url}/${id}/films`);
    }

    creer(a: Partial<Acteur>) {
    return this.http.post<Acteur>(this.url, a);
    }
    modifier(id: number, a: Acteur) {
    return this.http.put<Acteur>(`${this.url}/${id}`, a);
    }
    supprimer(id: number) {
    return this.http.delete<void>(`${this.url}/${id}`);
    }
}
