import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../classes/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl = 'http://localhost:8080'; 

  constructor(private http: HttpClient) { }

  getDiscountProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/discount/get-discount-products`);
  }


}