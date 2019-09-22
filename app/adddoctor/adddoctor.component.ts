import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';


@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.scss']
})
export class AdddoctorComponent implements OnInit {

  
  doctors:Admin[];
  doctor=new Admin();
  confirmpassword: String;
  errMessage: String

  constructor(private route: ActivatedRoute,private _router:Router,private adminService:AdminServiceService) { }


  ngOnInit() {
    this.route.params.subscribe( params => this.getDoctorById(params['sId']));
  }

  checkPassword():void{
    if(this.doctor.password===this.confirmpassword)
    {
      this.savedoctor();
    }
    else{
      this.errMessage="Password Mismatch";
    }
  }


  savedoctor(): void{
    this.adminService.savedoctor(this.doctor)
      .subscribe((response)=>{
        console.log(response);
        this._router.navigate(['viewdoc']);
      }, (error)=>{
        console.log(error);
      });
  }

  getDoctorById(sId: number){
    console.log("Doctor Id " +sId);
    this.adminService.getDoctorById(sId)
    .subscribe((searchData) =>{
      this.doctor=searchData;
      console.log(searchData);
    }, (error) =>{
      console.log(error);
    });
  }


  back():void{
    this._router.navigate(['viewdoc']);
  }
 logout():void{
    this._router.navigate(['']);
  }

}
