import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Observable } from 'rxjs';
import { PanierService } from '../../services/services/panier.service';
import { Article } from '../../models/models/article';
import { Categorie } from '../../models/models/categorie';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-produitresult',
  templateUrl: './produitresult.component.html',
  styleUrls: ['./produitresult.component.css'],
  imports: [CommonModule, RouterModule],
  standalone: true
})
export class ProduitresultComponent{
	outillage = 'OUTILLAGE';
	mobilier = 'MOBILIER';
	plantes = 'PLANTES';
	accessoires = 'ACCESSOIRES';
	categorieName!:any;

  constructor(private panier: PanierService) {
  }
articles: any[] = [];
article: any;
 
public apiUrl = 'http://localhost:8080/produit';
article$!: Observable<Article>;

  @Input()
  public result: Categorie | any;
  @Output()
  sendRequestData = new EventEmitter();

  getRoute(productId: number){
    const catNameLower = this.result.nom.toLowerCase()
    return ['/product', catNameLower, productId]
  }
  
  getCategoryName(catName:any) {
  	console.log("categorie nom cote fils : "+catName);
  	this.sendRequestData.emit(catName);
  }
  sendEvent(){
  	this.sendRequestData.emit(this.categorieName);
  }
  handelAddToCart = (product: { id: any; name: any; price: any; quantity: any; reference: any; avis: any; url: any; }) => {
    this.panier.addItemsToCart(product);
  }

}

