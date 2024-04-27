import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SearchService } from '../../services/search.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.css'
})
export class SearchBarComponent {
  

  constructor(private searchService: SearchService) {}


  // submitSearch(searchTerm: string): void {
  //   this.searchService.setSearchTerm(searchTerm);
  // }





}
