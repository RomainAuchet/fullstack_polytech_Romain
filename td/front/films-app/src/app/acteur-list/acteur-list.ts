import { Component, inject } from '@angular/core';
import { ActeurService } from '../acteur-service';
import { toSignal } from '@angular/core/rxjs-interop';
import { RouterLink } from '@angular/router';

@Component({
  imports: [RouterLink],
  selector: 'app-acteur-list',
  styleUrl: './acteur-list.css',
  templateUrl: './acteur-list.html',
})
export class ActeurList {
  private service = inject(ActeurService);
  acteurs = toSignal(this.service.getAll(), { initialValue: [] });
}
