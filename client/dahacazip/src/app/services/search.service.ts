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

    let params = new HttpParams().set('searchTerm', searchTerm).set('limit', 6);

 
    if (filters) {
      Object.keys(filters).forEach(key => {
        if (filters[key]) { 
          params = params.set(key, filters[key]); 
        }
      });
    }
    console.log("HTTP isteği gönderilecek parametreler:", params.toString());


    return this.http.get<Product[]>(`${this.apiUrl}/search`, { params });
  }



}
