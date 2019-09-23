import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { DoctorserviceService } from '../doctorservice.service';
import { Doctor } from '../doctor';
import { error } from '@angular/compiler/src/util';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-patienthistory',
  templateUrl: './patienthistory.component.html',
  styleUrls: ['./patienthistory.component.scss']
})
export class PatienthistoryComponent implements OnInit {
  history: Doctor[];
  labhistory: Doctor[];
  obshistory: Doctor[];
  details: Doctor[];
  ObserNotes = new Doctor();
  dId: number;
  regId: number;

  constructor(private route: ActivatedRoute, private _authservice: AuthService, private _router: Router, private _doctorService: DoctorserviceService) { }

  ngOnInit() {

    this.route.params.subscribe(params => this.getIds(params['dId'], params['regId']));
    this.route.params.subscribe(params => this.patientMedicineHistory(params['regId']));
    // this.patientMedicineHistory();

    this.route.params.subscribe(params => this.patientLabHistory(params['regId']));

    // this.patientLabHistory();
    //this.route.params.subscribe( params => this.patientLabHistory(params['regId']));
    this.route.params.subscribe(params => this.patientObsHistory(params['regId']));
    this.route.params.subscribe(params => this.patientDetails(params['regId']));


  }
  refresh(): void {
    window.location.reload();
  }
  back(): void {
    this._router.navigate(['viewdocapp/' + this.dId]);
  }
  
  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }


  getIds(dId: number, regId: number) {
    this.dId = dId;
    this.regId = regId;
  }

  addNotes(): void {

    if (this.ObserNotes.obsNotes != null) {
      this.ObserNotes.regId = this.regId;
      this.ObserNotes.dId = this.dId;

      this._doctorService.addObsNotes(this.ObserNotes).subscribe((response) => {
        console.log(response)
        this.ObserNotes.obsNotes = undefined;
        this.refresh();
      }, (error) => {
        console.log(error);
      });
    }
  }
  addpresc(): void {
    this._router.navigate(['addpresc/' + this.dId + '/' + this.regId]);
  }

  addlab(): void {
    this._router.navigate(['addlab/' + this.dId + '/' + this.regId]);
  }

  patientMedicineHistory(regId: number): void {

    this._doctorService.getpatientMedicineHistory(regId)
      .subscribe((histlist) => {

        this.history = histlist,
          console.log("History: " + histlist);
      }, (error) => { console.log(error) });
  }

  patientLabHistory(regId: number): void {

    this._doctorService.getpatientLabHistory(regId).subscribe((histlist1) => {
    this.labhistory = histlist1,
      console.log(histlist1);
    }, (error) => { console.log(error) });
  }

  patientObsHistory(regId: number): void {

    this._doctorService.getpatientObsHistory(regId).subscribe((histlist2) => {
    this.obshistory = histlist2,
      console.log(histlist2);
    }, (error) => { console.log(error) });
  }
  patientDetails(regId: number): void {

    this._doctorService.getpatientDetails(regId).subscribe((histlist3) => {
    this.details = histlist3,
      console.log(histlist3);
    }, (error) => { console.log(error) });
  }

  save(): void {
    this._router.navigate(['viewdocapp/' + this.dId])
  }

}