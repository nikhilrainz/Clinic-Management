import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorserviceService } from '../doctorservice.service';

@Component({
  selector: 'app-labrequest',
  templateUrl: './labrequest.component.html',
  styleUrls: ['./labrequest.component.scss']
})
export class LabrequestComponent implements OnInit {

  labtest= new Doctor();
  labtests:Doctor[];
  disppatients:Doctor[];
  prescDets:Doctor[];
  regId:number;
  dId:number;

  constructor(private route:ActivatedRoute,private _router:Router, private _doctorService: DoctorserviceService) { }

  ngOnInit() {
    this.route.params.subscribe( params => this.getidP(params['dId'],params['regId']));

    this.route.params.subscribe( params => this.patientDetails(params['regId']));
    this.getlabTests();
  }

  getidP(dId:number,regId:number)
  {
    this.dId=dId;
    this.regId=regId;
    
    console.log("Hello"+dId);
  }

  getlabTests():void{
    this._doctorService.getAllLabTests()
    .subscribe((labdata) =>{
      this.labtests=labdata,
      console.log(labdata);
    }, (error) =>{
      console.log(error);
    });
    }


    getAlllabpresc():void{
      this._doctorService.getAlllabPrescription(this.regId,this.dId)
      .subscribe((presdata) =>{
        this.prescDets=presdata,
        console.log(presdata);
      }, (error) => {
        console.log(error)
      })
    }
  

    patientDetails(regId:number):void{

      this. _doctorService.getpatientDetails(regId).subscribe((patInfo) =>
      {this.disppatients= patInfo,
        console.log(patInfo);
      },(error) => {console.log(error)});
    }
    
    savepres(){

      this.labtest.regId=this.regId;
      this.labtest.dId=this.dId;
      console.log(this.labtest);
      this._doctorService.insertDoctorlabPrescription(this.labtest)
      .subscribe((response)=>{
      console.log(response);
       //this.reset();
      // console.log("getAllPrescription");
       this.getAlllabpresc(); 
       
      }, (error)=>{
        console.log(error);
        
      });
  
}

 deletepres(assignLabId:number){
  this._doctorService.deletePres(assignLabId).subscribe((response)=>{
    console.log(response);
    this.getAlllabpresc();

  }, (error)=>{
     console.log(error);
    
  });
 }
}
