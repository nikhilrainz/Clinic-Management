import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FrontofficeService } from '../frontoffice.service';
import { FrontOffice } from '../frontoffice';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-viewpatients',
  templateUrl: './viewpatients.component.html',
  styleUrls: ['./viewpatients.component.scss']
})
export class ViewpatientsComponent implements OnInit {

  patients: FrontOffice[];
  patient = new FrontOffice();
  searchString: String;
  regId: number;
  message: string;

  constructor(private _router: Router, private _authservice: AuthService, private _frontoffice: FrontofficeService) { }


  ngOnInit() {
    this.getAllPatients();
  }

  getAllPatients(): void {
    this._frontoffice.getAllPatients()
      .subscribe((patientData) => {
        this.patients = patientData;
        console.log(patientData);
      }, (error) => {
        console.log(error);
      });

  }

  searchPatient(searchString: string) {
    console.log(searchString);
    this._frontoffice.searchPatient(searchString).subscribe((response) => {
      this.patients = response

      if (searchString != null) {
        console.log(response);
        if (response.length == 0) {
          this.message = "Not Found";
          console.log(this.message);
          this.searchString = undefined;
        }
        else {
          this.patients = response
          console.log(this.patients);
          this.searchString = undefined;
          this.message = undefined;
        }
      }
      else {
        this.getAllPatients();
      }
    }, (error) => {
      console.log(error);
    });
  }

  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }

  viewtodays(): void {
    this._router.navigate(['viewtodayapp']);
  }
  view(): void {
    this.getAllPatients();
    this.searchString = undefined;
    this.message = undefined;
  }
  edit(regId: number): void {
    console.log(regId);
    this._router.navigate(['addpat/' + regId]);
  }
  add(): void {
    this._router.navigate(['addpat']);
  }


  consult(regId: number): void {
    this._router.navigate(['consult/' + regId]);
  }

}

