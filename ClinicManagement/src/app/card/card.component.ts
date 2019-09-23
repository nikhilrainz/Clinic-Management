import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  constructor(private _router: Router,private _authservice: AuthService) { }


  ngOnInit() {
  }
  doctor(): void {
    this._router.navigate(['viewdoc']);
  }
  staff(): void {
    this._router.navigate(['viewstaff']);
  }
  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }

  medicine(): void {
    this._router.navigate(['viewmed']);
  }
}