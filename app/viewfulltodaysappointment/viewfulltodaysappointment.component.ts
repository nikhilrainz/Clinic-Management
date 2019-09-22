import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { FrontOffice } from '../frontoffice';
import { FrontofficeService } from '../frontoffice.service';

@Component({
  selector: 'app-viewfulltodaysappointment',
  templateUrl: './viewfulltodaysappointment.component.html',
  styleUrls: ['./viewfulltodaysappointment.component.scss']
})
export class ViewfulltodaysappointmentComponent implements OnInit {
  todaysappoinment: FrontOffice[];
  todayappoinment= new FrontOffice();
  patient =new FrontOffice();
  //patients: FrontOffice[];
  
  regId:number;
  
  constructor(private _router:Router,private _frontoffice:FrontofficeService) { }



  ngOnInit() {
    this.getTodaysAppoinment();
   }


  getTodaysAppoinment(): void{
    this._frontoffice.getappointments()
    .subscribe((appoinmentData)=>{
      this.todaysappoinment=appoinmentData,
      console.log(appoinmentData);
    }, (error) =>{
      console.log(error);
    });
  }

  searchTodaysAppoinment(searchString:string){
    console.log(searchString);
    this._frontoffice.searchTodaysAppoinment(searchString).subscribe((response)=>{
      this.todaysappoinment= response
      console.log(this.todaysappoinment);
    },(error)=>{
      console.log(error);
  

    });
  }
  
  back():void{
    this._router.navigate(['viewpat']);
  }
 logout():void{
    this._router.navigate(['']);
  }
  
  edit(regId:number):void{
    console.log(regId);
    this._router.navigate(['addpat/'+regId]);
  }
  view():void{
    this.getTodaysAppoinment();
  }
}
