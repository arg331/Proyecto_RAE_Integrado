import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Palabra } from './palabra';

@Injectable({
  providedIn: 'root',
})
export class PalabraService {
  private apiUrl = 'http://localhost:8080/api/palabras';

  constructor(private http: HttpClient) {}

  getAllPalabras(): Observable<Palabra[]> {
    return this.http.get<Palabra[]>(this.apiUrl);
  }
}