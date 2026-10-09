import { Component, inject, input, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActeurService } from '../acteur-service';
import { Router } from '@angular/router';
import { Acteur } from '../acteur.model';

@Component({
  imports: [FormsModule],
  selector: 'app-acteur-form',
  styleUrl: './acteur-form.css',
  templateUrl: './acteur-form.html',
})
export class ActeurForm {
  id = input<string>();
  private service = inject(ActeurService);
  private router = inject(Router);

  acteur: Partial<Acteur> = { nom: '', prenom: '' };
  message = signal("");

  ngOnInit() {
    if (this.id()) {
      this.service.getById(Number(this.id())).subscribe({
        next: (f) => this.acteur= f
      });
    }
  }

  enregistrer() {
    if (this.id()) {
      this.service.modifier(Number(this.id()), this.acteur as Acteur).subscribe({
        next: () => this.router.navigate(["/acteurs"]),
        error: (e) => this.message.set("Échec : " + e.message)
      });
    } else {
      this.service.creer(this.acteur).subscribe({
        next: () => this.router.navigate(["/acteurs"]),
        error: (e) => this.message.set("Échec : " + e.message)
      });
    }
  }
}