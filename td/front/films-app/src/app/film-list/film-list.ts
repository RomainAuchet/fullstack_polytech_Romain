import { Component, inject, signal } from '@angular/core';
import { Film } from '../film.model';
import { toSignal } from '@angular/core/rxjs-interop';
import { FilmService } from '../film-service';
import { FilmCard } from '../film-card/film-card';

@Component({
  imports: [FilmCard],
  selector: 'app-film-list',
  styleUrl: './film-list.css',
  templateUrl: './film-list.html',
})
export class FilmList {
private service = inject(FilmService);
  films = toSignal(this.service.getAll(), { initialValue: [] });
  erreur = signal('');

  onSupprimer(f: Film) {
    this.service.supprimer(f.id).subscribe({
      next: () => window.location.reload(),
      error: (e) => this.erreur.set("Erreur de suppression : " + e.message)
    });
  }
}
