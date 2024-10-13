import { CommonModule } from '@angular/common';
import { Component,OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Observable } from 'rxjs';
import { Client } from '../../../models/models/client.model';
import { ClientService } from '../../../services/services/client.service';
import { AuthService } from '../../../services/services/auth-service.service';

 
@Component({
  selector: 'app-profil-utilisateur',
  templateUrl: './profiluser-display.component.html',
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterModule],
  standalone: true
})
export class ProfilUserDisplayComponent implements OnInit {
constructor(
    private $client: ClientService,
    private $auth: AuthService,
  ) {}
   
  client$!: Observable<Client>;

  ngOnInit(): void {
    this.client$ = this.$client.getCurrentClient(this.$auth.connectedUserID);
  }
  
}