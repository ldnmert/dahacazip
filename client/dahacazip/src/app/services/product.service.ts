import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl = 'http://localhost:8080/api'; // Backend'inizdeki API'nin URL'si

  constructor(private http: HttpClient) { }

  getProductsMigros(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/discount-products-migros`);
  }

  getProductsA101(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/discount-products-a101`);
  }

  getProductsCarrefour(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/discount-products-carrefour`);
  }

  getProductsBim(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/discount-products-bim`);
  }
}