import { Component, inject, input, signal } from '@angular/core';
import { FilmService } from '../film-service';
import { Router } from '@angular/router';
import { Film } from '../film.model';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-film-form',
  styleUrl: './film-form.css',
  templateUrl: './film-form.html',
})
export class FilmForm {
  id = input<string>();
  private service = inject(FilmService);
  private router = inject(Router);

  film: Partial<Film> = { titre: '', realisateur: '', dateSortie: '', genre: '' };
  message = signal("");

  ngOnInit() {
    if (this.id()) {
      this.service.getById(Number(this.id())).subscribe({
        next: (f) => this.film = f
      });
    }
  }

  enregistrer() {
    if (this.id()) {
      this.service.modifier(Number(this.id()), this.film as Film).subscribe({
        next: () => this.router.navigate(["/films"]),
        error: (e) => this.message.set("Échec : " + e.message)
      });
    } else {
      this.service.creer(this.film).subscribe({
        next: () => this.router.navigate(["/films"]),
        error: (e) => this.message.set("Échec : " + e.message)
      });
    }
  }
}
