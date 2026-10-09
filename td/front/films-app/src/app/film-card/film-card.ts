import { Component, input, output } from '@angular/core';
import { Film } from '../film.model';
import { RouterLink } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  imports: [DatePipe,RouterLink],
  selector: 'app-film-card',
  styleUrl: './film-card.css',
  templateUrl: './film-card.html',
})
export class FilmCard {
  film = input.required<Film>();
  supprimer = output<Film>();

  estAncien(f: Film): boolean {
    return new Date(f.dateSortie).getFullYear() < 2000;
  }

  onSupprimer() {
    this.supprimer.emit(this.film());
  }
}
