import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FrontOffice } from './frontoffice';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FrontofficeService {

  constructor(private _httpServce: HttpClient) { }

  getAllPatients(): Observable<FrontOffice[]> {
    return this._httpServce.get<FrontOffice[]>(environment.APIUrl + '/patients');
  }

  addPatient(patient: FrontOffice) {
    console.log("Service:" + patient);
    let body = JSON.stringify(patient);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let options = { headers: headers }
    console.log(patient.regId);
    //return this._httpServce.post(environment.APIUrl +'/insertpatient',body,options);
    if (patient.regId) {
      return this._httpServce.put(environment.APIUrl + '/insertpatient', body, options);
    }
    else {
      return this._httpServce.post(environment.APIUrl + '/insertpatient', body, options)
    }
  }

  getappointments(): Observable<FrontOffice[]> {
    return this._httpServce.get<FrontOffice[]>(environment.APIUrl + '/appointments');
  }

  searchPatient(searchString: string): Observable<FrontOffice[]> {
    return this._httpServce.get<FrontOffice[]>(environment.APIUrl + '/patient/' + searchString);
  }
  searchTodaysAppoinment(searchString: string): Observable<FrontOffice[]> {
    return this._httpServce.get<FrontOffice[]>(environment.APIUrl + '/patientApp/' + searchString);
  }

  getPatientInfo(regId: number): Observable<FrontOffice[]> {
    return this._httpServce.get<FrontOffice[]>(environment.APIUrl + '/patdetail/' + regId);
  }
  // CONSULTATION
  getPatientById(regId: number): Observable<FrontOffice> {
    return this._httpServce.get<FrontOffice>(environment.APIUrl + '/editpatdetail/' + regId);
  }
  getAllapp(): Observable<FrontOffice[]> {
    return this._httpServce.get<FrontOffice[]>(environment.APIUrl + '/getAvailableDoctor');
  }
  getDocAvail(sName: String): Observable<FrontOffice> {
    return this._httpServce.get<FrontOffice>(environment.APIUrl + '/consultdoctor/' + sName);
  }
  addDocAppoinment(consult: FrontOffice) {
    let body = JSON.stringify(consult);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let options = { headers: headers }

    return this._httpServce.post(environment.APIUrl + '/insertAppoinment', body, options);

  }

}