import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FrontofficeService } from '../frontoffice.service';
import { FrontOffice } from '../frontoffice';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-addpatients',
  templateUrl: './addpatients.component.html',
  styleUrls: ['./addpatients.component.scss']
})
export class AddpatientsComponent implements OnInit {

  patients: FrontOffice[];
  patient = new FrontOffice();
  regId: number;

  constructor(private route: ActivatedRoute, private _router: Router, private _authservice: AuthService, private _frontoffice: FrontofficeService) { }


  ngOnInit() {
    this.route.params.subscribe(params => this.getPatientById(params['regId']));
  }

  getPatientById(regId: number) {
    console.log(" patient ID" + regId);
    this._frontoffice.getPatientById(regId)
      .subscribe((patientData) => {
        this.patient = patientData;
        console.log(patientData);
      }, (error) => {
        console.log(error);
      });

  }

  back(): void {
    this._router.navigate(['viewpat']);
  }
  
  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }

  addPatient(): void {
    console.log(this.patient);
    this._frontoffice.addPatient(this.patient).subscribe((response) => {
      console.log(response);
      this._router.navigate(['viewpat']);
      //this.getAllPatients;
    }, (error) => {
      console.log(error);
    });

  }

  updatePatient(): void {
    console.log(this.patient);
    this._frontoffice.addPatient(this.patient).subscribe((response) => {
      console.log(response);
      this._router.navigate(['viewpat']);
      //this.getAllPatients;
    }, (error) => {
      console.log(error);
    });

  }
}
