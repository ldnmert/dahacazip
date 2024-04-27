  import { Component, OnInit, Output } from '@angular/core';
  import { Product } from '../../classes/product';
  import { ProductService } from '../../services/product.service';
  import { SearchService } from '../../services/search.service';
import { EventEmitter } from 'node:stream';

  @Component({
    selector: 'app-main-page',
    templateUrl: './main-page.component.html',
    styleUrl: './main-page.component.css'
  })
  export class MainPageComponent implements OnInit{

    productMigros: Product[] = [];
    productA101: Product[] = [];
    productCarrefour: Product[] = [];
    productBim: Product[] = [];
    productSok: Product[] = [];

    constructor(public productService: ProductService, public searchService: SearchService){}

    filters = {
      sort: '' // Başlangıçta sıralama filtresi boş olacak
    };


    ngOnInit(): void {
  
       this.displayDiscountProducts();
      
 
    }



    displayDiscountProducts(): void {
      this.productService.getDiscountProducts().subscribe(
        
        (data: Product[]) => {
          this.productMigros = data.filter(product => product.marketName === "MIGROS");
          this.productCarrefour = data.filter(product => product.marketName === "CARREFOUR");
          

        },
        (error) => {
          console.log('Hata oluştu:', error);
        }
      );
    }

    submitSearch(searchTerm: string): void {
      this.searchService.getWantedProducts(searchTerm, this.filters).subscribe(
        
        (data: Product[]) => {
          console.log("Hayalet sevgili");
          this.productA101 = data.filter(product => product.marketName === "A101");
          this.productMigros = data.filter(product => product.marketName === "MIGROS");
          this.productCarrefour = data.filter(product => product.marketName === "CARREFOUR");
          this.productSok = data.filter(product => product.marketName === "SOK");
        },
        (error) => {
          console.log('Hata oluştu:', error);
        }
      );
    }
  


  


  



}
