import { Component, computed, inject, input, NgModule, signal } from '@angular/core';
import { FilmService } from '../film-service';
import { ActeurService } from '../acteur-service';
import { Film } from '../film.model';
import { Acteur } from '../acteur.model';
import { RouterLink } from '@angular/router';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
  imports: [RouterLink,FormsModule],
  selector: 'app-film-detail',
  styleUrl: './film-detail.css',
  templateUrl: './film-detail.html',
})
export class FilmDetail {
  id = input.required<string>(); 
  private filmService = inject(FilmService);
  private acteurService = inject(ActeurService);
  
  film = signal<Film | null>(null);
  tousLesActeurs = signal<Acteur[]>([]);
  acteurSelection = signal<number | null>(null);
  erreur = signal('');

  acteursDisponibles = computed(() => {
    const dejaAssocies = this.film()?.acteurs || [];
    return this.tousLesActeurs().filter(a => !dejaAssocies.some(da => da.id === a.id));
  });

  ngOnInit() {
    this.recharger();
    this.acteurService.getAll().subscribe({
      next: (acteurs) => this.tousLesActeurs.set(acteurs)
    });
  }

  recharger() {
    this.filmService.getById(Number(this.id())).subscribe({
      next: (f) => this.film.set(f),
      error: (e) => this.erreur.set("Erreur de chargement")
    });
  }

  associer() {
    const acteurId = this.acteurSelection();
    if (!acteurId) return;
    this.filmService.associerActeur(Number(this.id()), acteurId).subscribe({
      next: () => this.recharger(),
      error: () => this.erreur.set("Erreur d'association")
    });
  }

  dissocier(acteurId: number) {
    this.filmService.dissocierActeur(Number(this.id()), acteurId).subscribe({
      next: () => this.recharger(),
      error: () => this.erreur.set("Erreur de dissociation")
    });
  }
}
