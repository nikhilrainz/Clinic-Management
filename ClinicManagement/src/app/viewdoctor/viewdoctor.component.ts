import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-viewdoctor',
  templateUrl: './viewdoctor.component.html',
  styleUrls: ['./viewdoctor.component.scss']
})
export class ViewdoctorComponent implements OnInit {

  doctors: Admin[];
  doctor = new Admin();
  doctorId: number;
  message: string;
  searchString: string;

  constructor(private _router: Router, private _authservice: AuthService, private _adminService: AdminServiceService) { }

  ngOnInit() {
    this.getAllDoctors();
  }
  /***** DASHBOARD HEADERS ********/
  back(): void {
    this._router.navigate(['admindashboard']);
  }
  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }
  adddoc(): void {
    this._router.navigate(['adddoc']);
  }

  viewall(): void {
    this.getAllDoctors();
  }

  /******** CODING STARTS FROM HERE *************/
  getAllDoctors(): void {
    this.message = undefined;
    this._adminService.getAllDoctors()
      .subscribe((doctorData) => {
        this.doctors = doctorData;
        console.log(doctorData);
      }, (error) => {
        console.log(error);
      });
  }

  searchDoctors(searchString: string) {
    console.log(searchString);
    this._adminService.searchDoctors(searchString)
      .subscribe((response) => {

        if (searchString != null) 
        {
          console.log(response);
          if (response.length == 0) 
          {
            this.message = "Not Found";
            console.log(this.message);
            this.searchString = undefined;
          }
          else 
          {
            this.doctors = response
            console.log(this.doctors);
            this.searchString = undefined
            this.message = undefined;
          }
        }

      }
        , (error) => {
          console.log(error);
          this.message = "Please use Id or Name"
          this.searchString = undefined;
        });
  }

  editDoctor(sId: number) {
    console.log("Doctor SID : " + sId);
    this._router.navigate(['adddoc/' + sId])
  }

  disableDoctor(dId: number): void {
    console.log(dId);
    this._adminService.disableDoctor(dId)
      .subscribe((response) => {
        //console.log(response);
        this.doctor = response
        console.log(this.doctor);
        this.getAllDoctors();
      }, (error) => {
        console.log(error);
      });
  }
}
