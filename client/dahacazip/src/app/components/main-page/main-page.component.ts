import { Component, OnInit } from '@angular/core';
import { Product } from '../../classes/product';
import { ProductService } from '../../services/product.service';

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

  constructor(public productService: ProductService){}

  ngOnInit(): void {
    this.getProductsMigros();
    this.getProductsA101();
    this.getProductsCarrefour();
    this.getProductsBim();
  }

  getProductsMigros(): void {
    this.productService.getProductsMigros().subscribe(
      
      (data: Product[]) => {
        this.productMigros = data;
      },
      (error) => {
        console.log('Hata oluştu:', error);
      }
    );
    console.log("1");
  }

  getProductsA101(): void {
    this.productService.getProductsA101().subscribe(
      (data: Product[]) => {
        this.productA101 = data;
      },
      (error) => {
        console.log('Hata oluştu:', error);
      }
    );
    console.log("2");
  }

  getProductsCarrefour(): void {
    this.productService.getProductsCarrefour().subscribe(
      (data: Product[]) => {
        this.productCarrefour = data;
      },
      (error) => {
        console.log('Hata oluştu:', error);
      }
    );
    console.log("3");
  }

  getProductsBim(): void {
    this.productService.getProductsBim().subscribe(
      (data: Product[]) => {
        this.productBim = data;
      },
      (error) => {
        console.log('Hata oluştu:', error);
      }
    );
    console.log("4");
  }



}
