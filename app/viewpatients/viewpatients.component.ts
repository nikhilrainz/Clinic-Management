import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FrontofficeService } from '../frontoffice.service';
import { FrontOffice } from '../frontoffice';

@Component({
  selector: 'app-viewpatients',
  templateUrl: './viewpatients.component.html',
  styleUrls: ['./viewpatients.component.scss']
})
export class ViewpatientsComponent implements OnInit {

  patients: FrontOffice[];
  patient = new FrontOffice();
  searchString :String;
  regId:number;

  constructor(private _router:Router,private _frontoffice:FrontofficeService) { }


  ngOnInit() {
    this.getAllPatients();
  }
  
  getAllPatients():void{
    this._frontoffice.getAllPatients()
    .subscribe((patientData) =>{
      this.patients =patientData;
      console.log(patientData);
    },(error) =>{
      console.log(error);
    });
    
  }

  searchPatient(searchString:string){
    console.log(searchString);
    this._frontoffice.searchPatient(searchString).subscribe((response)=>{
      this.patients= response
      console.log(this.patients);
    },(error)=>{
      console.log(error);
  

    });
  }
  

  logout():void{
    this._router.navigate(['']);
  }
  viewtodays():void{
    this._router.navigate(['viewtodayapp']);
  }
  view():void{
    this.getAllPatients();
  }
  edit(regId:number):void{
    console.log(regId);
    this._router.navigate(['addpat/'+regId]);
  }
  add():void{
    
    
    this._router.navigate(['addpat']);
  }
    
  
 consult(regId:number):void{
  this._router.navigate(['consult/'+regId]);
  }

}

