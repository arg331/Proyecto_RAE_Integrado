import { Component, input } from '@angular/core';
import { Palabra } from '../palabra';

@Component({
  selector: 'app-film-card',
  template: `
    <section class="film-card">
      <div class="film-day" [style.color]="getMonthColor(film().fecha)">
        {{ getDay(film().fecha) }}
      </div>
      <h2 class="film-title">{{ film().palabra }}</h2>
      <p class="film-date">📅 {{ film().fecha }}</p>
      <a [href]="film().url_origen" target="_blank">Ver en la RAE</a>
    </section>
  `,
  styleUrls: ['./film-card.css'],
})
export class FilmCard {
  film = input.required<Palabra>();

  getDay(fecha: string): string {
    // fecha viene como "LUNES, 9 DE MARZO DE 2026"
    const partes = fecha.split(',');
    return partes.length > 1 ? partes[1].trim().split(' ')[0] : fecha;
  }

  getMonthColor(fecha: string): string {
    const meses: Record<string, number> = {
      'ENERO': 1, 'FEBRERO': 2, 'MARZO': 3, 'ABRIL': 4,
      'MAYO': 5, 'JUNIO': 6, 'JULIO': 7, 'AGOSTO': 8,
      'SEPTIEMBRE': 9, 'OCTUBRE': 10, 'NOVIEMBRE': 11, 'DICIEMBRE': 12,
    };
    const palabras = fecha.toUpperCase().split(' ');
    const mes = palabras.find(p => meses[p]);
    const month = mes ? meses[mes] : 0;

    const colors: Record<number, string> = {
      1: '#F44336', 2: '#E91E63', 3: '#9C27B0', 4: '#3F51B5',
      5: '#03A9F4', 6: '#009688', 7: '#4CAF50', 8: '#CDDC39',
      9: '#FF9800', 10: '#FF5722', 11: '#795548', 12: '#00BCD4',
    };
    return colors[month] ?? '#BB86FC';
  }
}