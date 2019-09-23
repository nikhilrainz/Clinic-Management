import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Doctor } from './doctor';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorserviceService {

  constructor(private _httpService: HttpClient) { }

  getAllMedicines(): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/doctor/medicine');
  }

  getDid(username: string, password: string): any {
    return this._httpService.get<Doctor>(environment.APIUrl + '/doctordId/' + username + '/' + password);

  }

  getDoctorsApponintment(dId: number): Observable<Doctor[]> {
    console.log("Inside");
    console.log(dId);
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/getdoctorsappointment/' + dId);

  }

  getpatientMedicineHistory(regId: number): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/labtests/' + regId);
  }

  getpatientLabHistory(regId: number): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/labtestshis/' + regId);
  }

  getpatientObsHistory(regId: number): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/Obsshis/' + regId);
  }

  searchTodaysAppoinment(searchString: string): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/doctorApp/' + searchString);
  }

  getpatientDetails(regId: number): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/details/' + regId);
  }

  addObsNotes(ObserNotes: Doctor) {
    let body = JSON.stringify(ObserNotes);
    console.log(body);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let options = { headers: headers }
    console.log(options);
    return this._httpService.post(environment.APIUrl + '/doctor/docObservation', body, options);

  }

  getAllPrescription(regId: number, dId: number): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/allpreslist/' + regId + '/' + dId);
  }
  insertDoctorPrescription(medicine: Doctor) {
    let body = JSON.stringify(medicine);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let options = { headers: headers }
    console.log("Aami");
    return this._httpService.post(environment.APIUrl + '/insertpres', body, options);
  }

  getAllLabTests(): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/doctor/test');
  }

  viewPatInfo(regId: number): Observable<Doctor[]> {
    console.log("service")
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/patientdetails/' + regId);
  }

  getAlllabPrescription(regId: number, dId: number): Observable<Doctor[]> {
    return this._httpService.get<Doctor[]>(environment.APIUrl + '/alllabpreslist/' + regId + '/' + dId);
  }

  insertDoctorlabPrescription(prescrib: Doctor) {
    let body = JSON.stringify(prescrib);
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let options = { headers: headers }
    console.log("Aami");
    return this._httpService.post(environment.APIUrl + '/doctor/insertlab', body, options);
  }

  deleteLab(assignLabId: number) {
    return this._httpService.delete(environment.APIUrl + '/doctor/deletelab/' + assignLabId)
  }

  deletePres(prescId: number) {
    return this._httpService.delete(environment.APIUrl + '/doctor/deletepres/' + prescId)
  }

}


