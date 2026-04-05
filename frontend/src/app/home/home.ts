import { Component, inject, ChangeDetectorRef } from '@angular/core';
import { FilmCard } from '../film-card/film-card';
import { Palabra } from '../palabra';
import { PalabraService } from '../palabras';

@Component({
  selector: 'app-home',
  imports: [FilmCard],
  template: `
    <section>
      <form>
        <input type="text" placeholder="Buscar por palabra" #filter />
        <button class="primary" type="button" (click)="filterResults(filter.value)">Buscar</button>
      </form>
    </section>
    <section class="results">
      @for (film of filteredFilmList; track $index) {
        <app-film-card [film]="film" />
      }
    </section>
  `,
  styleUrls: ['./home.css'],
})
export class Home {
  filmList: Palabra[] = [];
  filteredFilmList: Palabra[] = [];
  palabraService: PalabraService = inject(PalabraService);
  cdr: ChangeDetectorRef = inject(ChangeDetectorRef);

  constructor() {
    this.palabraService.getAllPalabras().subscribe((data: Palabra[]) => {
      this.filmList = data;
      this.filteredFilmList = data;
      this.cdr.detectChanges();
    });
  }

  filterResults(text: string) {
    if (!text) {
      this.filteredFilmList = this.filmList;
      return;
    }
    this.filteredFilmList = this.filmList.filter(p =>
      p.palabra.toLowerCase().includes(text.toLowerCase()) ||
      p.fecha.toLowerCase().includes(text.toLowerCase())
    );
  }
}