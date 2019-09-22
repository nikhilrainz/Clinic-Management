import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  constructor(private _router:Router) { }


  ngOnInit() {
  }
  doctor():void{
    this._router.navigate(['viewdoc']);
  }
  staff():void{
    this._router.navigate(['viewstaff']);
  }
  logout():void{
    this._router.navigate(['']);
  }
  
  medicine():void{
    this._router.navigate(['viewmed']);
  }
}