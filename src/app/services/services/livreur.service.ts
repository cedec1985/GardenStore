import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Livreur } from '../../models/models/livreur';

@Injectable({
  providedIn: 'root'
})
export class LivreurService {

  constructor(private http: HttpClient) { }

  public apiUrl = 'http://localhost:8080/livreur';

  getDeliveredBy(id: number): Observable<Livreur> {
    return this.http.get<Livreur>(`${this.apiUrl}/${id}`);
  }
  get LivreurID(){
    return 1;
  }
  
}
