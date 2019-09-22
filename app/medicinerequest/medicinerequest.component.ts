import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorserviceService } from '../doctorservice.service';
import { Doctor } from '../doctor';
import { Location } from '@angular/common';
@Component({
  selector: 'app-medicinerequest',
  templateUrl: './medicinerequest.component.html',
  styleUrls: ['./medicinerequest.component.scss']
})
export class MedicinerequestComponent implements OnInit {

 // medicines: Doctor[];
 // medicine = new Doctor();
  medicineId: number;
  details:Doctor[];
 
  dId : number;
  regId : number;
  prescDets :Doctor[];
  prescrib =new Doctor();
 

  medicines:Doctor[];
  medicine=new Doctor();
 
 
  constructor(private route:ActivatedRoute,private location: Location,private _router:Router, private _doctorService: DoctorserviceService) { }


  ngOnInit() {
    this.route.params.subscribe( params => this.getIds(params['dId'],params['regId']));
    this.getAllMedicines();
    this.route.params.subscribe( params => this.patientDetails(params['regId']));
  }
  getIds(dId:number,regId:number){
    this.dId=dId;
    this.regId=regId;
    console.log(dId);
  }
  getAllMedicines():void{
    this._doctorService.getAllMedicines()
    .subscribe((medicineData) =>{
      this.medicines = medicineData;
      console.log(medicineData);
    }, (error) =>{
      console.log(error);
    });
  }
 
  
  
  patientDetails(regId:number):void{

    this. _doctorService.getpatientDetails(regId).subscribe((histlist3) =>
    {this.details= histlist3,
      console.log(histlist3);
    },(error) => {console.log(error)});
  }

  getAllPres():void{
    this._doctorService.getAllPrescription(this.regId,this.dId)
    .subscribe((presdata) =>{
      this.prescDets=presdata,
      console.log(presdata);
    }, (error) => {
      console.log(error)
    })
  }
  private reset(){
    this.medicine.medName = null;
    this.medicine.medDays = null;
    this.medicine.medFreq = null;
  }


  savepres():void{
    this.medicine.regId=this.regId;
    this.medicine.dId=this.dId;
    console.log(this.medicine);
    this._doctorService.insertDoctorPrescription(this.medicine)
    .subscribe((response)=>{
    console.log(response);
     this.reset();
     console.log("getAllPrescription");
     this.getAllPres(); 
     
    }, (error)=>{
      console.log(error);
      
    });

    // this.router.navigate(['/viewPatHistory'])
  }
  //cancel() {
    //this.location.back(); // <-- go back to previous location on cancel
  //}
  
}
