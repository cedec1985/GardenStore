import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ProfilUserDisplayComponent } from './profiluser-display/profiluser-display.component';
import { ProfilUserComponent } from './profiluser.component';
import { ProfiluserRoutingModule } from './profiluser-routing.module';


@NgModule({
  declarations: [],
  imports: [CommonModule,HttpClient,ProfilUserDisplayComponent,ProfilUserComponent,ProfiluserRoutingModule
  ],
  exports: [ProfilUserComponent]
})
export class ProfiluserModule { }
