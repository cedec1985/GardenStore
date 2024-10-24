import { CommonModule } from '@angular/common';
import { HttpClient} from '@angular/common/http';
import { Component, ElementRef, Input, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, RouterOutlet } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { AdminComponent } from './components/admin/admin.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { ProduitresultComponent } from './components/produitresult/produitresult.component';
import { ProfilUserComponent } from './components/profiluser/profiluser.component';
import { RegisterComponent } from './components/register/register.component';
import { StockEpuiseDirective } from './directives/directives/stockEpuise.directive';
import { AuthService } from './services/services/auth-service.service';
import { PanierService } from './services/services/panier.service';
import { AccessoiresdetailsComponent } from './components/product-details/accessoiresdetails/accessoiresdetails.component';
import { MobilierdetailsComponent } from './components/product-details/mobilierdetails/mobilierdetails.component';
import { OutillagedetailsComponent } from './components/product-details/outillagedetails/outillagedetails.component';
import { PlantesdetailsComponent } from './components/product-details/plantesdetails/plantesdetails.component';
import { ContactComponent } from './components/contact/contact.component';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [AuthService,CookieService,PanierService,HttpClient],
    imports: [CommonModule, RouterOutlet, ReactiveFormsModule,RouterLink, RouterOutlet,FormsModule,
NavbarComponent,AdminComponent,ProduitresultComponent,StockEpuiseDirective,FormsModule,ReactiveFormsModule,
        RegisterComponent,ProfilUserComponent,ProductDetailsComponent,OutillagedetailsComponent,MobilierdetailsComponent,PlantesdetailsComponent,AccessoiresdetailsComponent,ContactComponent]
      })
      

export class AppComponent implements OnInit{
  panier! :any;
  logo!:string;
  @Input() isConnected: boolean = false;
  connected:boolean=false;
  email!:string;
  password!:string;

  constructor(private panierService: PanierService) {
  	this.panier = this.panierService.getCartCount();
  }

  ngOnInit() :void{
setInterval(() => {
      this.panier = this.panierService.getCartCount();
      console.log("nombre produits dans le panier : ",this.panier);
    }, 200);
  
    }

}