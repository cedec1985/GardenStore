import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AchattermineComponent } from './components/achattermine/achattermine.component';
import { AdminComponent } from './components/admin/admin.component';
import { CartComponent } from './components/cart/cart.component';
import { CategoryComponent } from './components/category/category.component';
import { ConfirmationComponent } from './components/confirmation/confirmation.component';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { AccessoiresComponent } from './components/product/accessoires/accessoires.component';
import { MobilierComponent } from './components/product/mobilier/mobilier.component';
import { OutillageComponent } from './components/product/outillage/outillage.component';
import { PlantesComponent } from './components/product/plantes/plantes.component';
import { ProduitresultComponent } from './components/produitresult/produitresult.component';
import { ProfilUserDisplayComponent } from './components/profiluser/profiluser-display/profiluser-display.component';
import { ProfiluserRoutingModule } from './components/profiluser/profiluser-routing.module';
import { ProfilUserComponent } from './components/profiluser/profiluser.component';
import { RegisterComponent } from './components/register/register.component';
import { StockEpuiseDirective } from './directives/directives/stockEpuise.directive';
import { AuthService } from './services/services/auth-service.service';
import { CategoryService } from './services/services/categorie.service';
import { CategoriesmockService } from './services/services/categoriesmock.service';
import { PanierService } from './services/services/panier.service';
import { OutillagedetailsComponent } from './components/product-details/outillagedetails/outillagedetails.component';
import { MobilierdetailsComponent } from './components/product-details/mobilierdetails/mobilierdetails.component';
import { PlantesdetailsComponent } from './components/product-details/plantesdetails/plantesdetails.component';
import { AccessoiresdetailsComponent } from './components/product-details/accessoiresdetails/accessoiresdetails.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ContactComponent } from './components/contact/contact.component';
import { HttpClient} from '@angular/common/http';

@NgModule({
  declarations: [],
  imports: [ RegisterComponent,ConnexionComponent,CartComponent,AdminComponent,OutillageComponent,MobilierComponent,PlantesComponent,AccessoiresComponent,
    AchattermineComponent,ConfirmationComponent,ProduitresultComponent,CategoryComponent, StockEpuiseDirective,
  CommonModule,AppComponent,NavbarComponent, HomeComponent,CommonModule, ProfiluserRoutingModule, FormsModule,ReactiveFormsModule, RouterModule, BrowserAnimationsModule,ProfilUserComponent,
  ProductDetailsComponent,OutillagedetailsComponent,MobilierdetailsComponent,PlantesdetailsComponent,AccessoiresdetailsComponent,ContactComponent,ProfilUserDisplayComponent],
  exports: [
    RegisterComponent,ConnexionComponent,CartComponent,AdminComponent,OutillageComponent,MobilierComponent,PlantesComponent,AccessoiresComponent,StockEpuiseDirective,
    AchattermineComponent,ConfirmationComponent,ProduitresultComponent,CategoryComponent, ProfilUserComponent,NavbarComponent,
    ProductDetailsComponent,OutillagedetailsComponent,MobilierdetailsComponent,PlantesdetailsComponent,AccessoiresdetailsComponent,ContactComponent,ProfilUserDisplayComponent, HomeComponent],
    
  providers: [AuthService,PanierService,CategoriesmockService,CategoryService,HttpClient],
  bootstrap: []
})

export class ProductModule { }
