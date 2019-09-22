import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { FrontofficeService } from '../frontoffice.service';
import { FrontOffice } from '../frontoffice';

@Component({
  selector: 'app-consultation',
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.scss']
})
export class ConsultationComponent implements OnInit {

  consults:FrontOffice[];
  objpat1=new FrontOffice();
  objpat2=new FrontOffice();
  regFee:number;
  sName:string;

  constructor( private route: ActivatedRoute,private _router:Router,private _frontoffice:FrontofficeService) { }


  ngOnInit() {
    this.getAllConsults();
    this.route.params.subscribe( params => this.getPatientById(params['regId']));
    this.sName=undefined;
    this.regFee=0;
  }
  
  

  getPatientById(regId: number){
    console.log("Patient Id " +regId);
    this._frontoffice.getPatientById(regId)
    .subscribe((searchData) =>{
      this.objpat1=searchData;
      console.log(searchData);
    }, (error) =>{
      console.log(error);
    });
  }
 

  getAllConsults():void{
    
    this._frontoffice.getAllapp()
    .subscribe((patientdata)=>{
    this.consults=patientdata,
    console.log(patientdata);
    },(error)=>{console.log(error);
    });
  //  Goback():void{
  //   this.router.navigate(['/viewpatient']);
  //  }

}
 
getDoctor(){
  this._frontoffice.getDocAvail(this.sName)
  .subscribe((consultData)=>{
    this.objpat2=consultData;
  //  console.log(this.objpat2);
  },(error)=>{
    console.log(error);
  });
}
      
addAppoinment():void{
     this.objpat2.regId=this.objpat1.regId;
    this._frontoffice.addDocAppoinment(this.objpat2)
       .subscribe((response)=>{
         console.log(this.objpat2);
         this._router.navigate(['viewtodayapp']);
       //this.viewpatient();
      },(error)=>{
        console.log(error);
       });
     
    }
  ViewPatient(regId:number){

    this._router.navigate(['/editpatdetail/'+regId]); 
  }
           
  
    back():void{
      this._router.navigate(['/viewpat']);
    }
 
  }
