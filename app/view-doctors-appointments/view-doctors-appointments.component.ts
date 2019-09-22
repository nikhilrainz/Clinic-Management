import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorserviceService } from '../doctorservice.service';
import { Doctor } from '../doctor';

@Component({
  selector: 'app-view-doctors-appointments',
  templateUrl: './view-doctors-appointments.component.html',
  styleUrls: ['./view-doctors-appointments.component.scss']
})
export class ViewDoctorsAppointmentsComponent implements OnInit {
  
  appoinments: Doctor[];
appoinment= new Doctor(); 
  
  constructor(private route: ActivatedRoute,private _router:Router, private _doctorService: DoctorserviceService) { }

  ngOnInit() {
    this.route.params.subscribe( params => this.getAppointment(params['dId']));
  }

  getAppointment(dId:number): void{
    console.log(dId);
    this._doctorService.getDoctorsApponintment(dId)
    .subscribe((appoinmentData)=>{
      this.appoinments=appoinmentData,
      console.log(appoinmentData);
    }, (error) =>{
      console.log(error);
    });
  }

  searchTodaysAppoinment(searchString:string){
    console.log(searchString);
    this._doctorService.searchTodaysAppoinment(searchString).subscribe((response)=>{
      this.appoinments= response
      console.log(this.appoinments);
    },(error)=>{
      console.log(error);
    });
  }

  back():void{
    this._router.navigate(['']);
  }

 logout():void{
    this._router.navigate(['']);
  }

  view(regId:string,dId:number):void{
    this._router.navigate(['pathis/' + dId +'/' + regId]);
  }
}
