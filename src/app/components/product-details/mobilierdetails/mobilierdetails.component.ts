import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Observable} from 'rxjs';
import { ProduitDTO } from '../../../models/dto/produit.dto';
import { ArticleService } from '../../../services/article.service';


@Component({
  selector: 'app-mobilierdetails',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './mobilierdetails.component.html',
  styleUrl: './mobilierdetails.component.css'
})
export class MobilierdetailsComponent implements OnInit {
  
  apiUrl = 'http://localhost:8080/produit';
  article$!: Observable<ProduitDTO>;
  constructor(
    private article :ArticleService
  ) {}
  ngOnInit(): void { this.article.loadDataMobilier(11);
  }
 // getCurrentArticle(id: number): Observable<ProduitDTO> {
   // return this.http.get<ProduitDTO>(`${this.apiUrl}/${id}`)
 // }
 }