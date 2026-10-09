import { Component, computed, inject, input, signal } from '@angular/core';
import { ActeurService } from '../acteur-service';
import { Acteur } from '../acteur.model';
import { Film } from '../film.model';
import { RouterLink } from '@angular/router';

@Component({
  imports: [RouterLink],
  selector: 'app-acteur-detail',
  styleUrl: './acteur-detail.css',
  templateUrl: './acteur-detail.html',
})
export class ActeurDetail {
  id = input.required<string>();
  acteurId = computed(() => Number(this.id()));
  private service = inject(ActeurService);
  
  acteur = signal<Acteur | null>(null);
  films = signal<Film[]>([]);
  erreur = signal('');

  ngOnInit() {
    const idActeur = Number(this.id());
    
    this.service.getById(idActeur).subscribe({
      next: (a) => this.acteur.set(a),
      error: () => this.erreur.set("Acteur introuvable")
    });

    this.service.getFilms(idActeur).subscribe({
      next: (f) => this.films.set(f)
    });
  }
}

