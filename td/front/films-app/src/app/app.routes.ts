import { Routes } from '@angular/router';

export const routes: Routes = [
{ path: "films", component: FilmList },
{ path: "films/nouveau", component: FilmForm }, { path: "films/:id/modifier", component: FilmForm },
{ path: "films/:id", component: FilmDetail },
{ path: "acteurs", component: ActeurList },
{ path: "acteurs/:id", component: ActeurDetail },
{ path: "", redirectTo: "films", pathMatch: "full" },
{ path: "**", component: NotFound },
// avant films/:id
];