import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../classes/product';
import { Observable } from 'rxjs';
import { MainPageComponent } from '../components/main-page/main-page.component';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }



  getWantedProducts(searchTerm: string, filters: any = {}): Observable<Product[]> {
    // HTTP isteği için kullanılacak parametreler
    let params = new HttpParams().set('searchTerm', searchTerm).set('limit', 6);

    // Filtreleme seçenekleri varsa, parametrelere ekle
    if (filters) {
      Object.keys(filters).forEach(key => {
        if (filters[key]) { // Boş olmayan filtreler eklenir
          params = params.set(key, filters[key]); 
        }
      });
    }
    console.log("HTTP isteği gönderilecek parametreler:", params.toString());

    // HTTP isteği gönder ve Observable<Product[]> olarak sonucu döndür
    return this.http.get<Product[]>(`${this.apiUrl}/search`, { params });
  }



}
