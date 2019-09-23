import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {


  constructor(private _httpService: HttpClient) { }

  savedoctor(doctor:Admin)
  {
    let body = JSON.stringify(doctor);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    if(doctor.sId)
    {
      return this._httpService.put(environment.APIUrl+'/saveDoctor',body,options);
    }
    else
    {  
      return this._httpService.post(environment.APIUrl+'/saveDoctor',body,options);
    }
  }
  addStaffServ(staff:Admin)
  {
    let body=JSON.stringify(staff);
    console.log(body);
    let headers=new HttpHeaders({'Content-Type':'application/json'});
    let options={headers:headers}
    console.log(options);
    if(staff.sId)
    {
      return this._httpService.put(environment.APIUrl+'/insertStaff',body,options);
    }
    else
    {  
      return this._httpService.post(environment.APIUrl+'/insertStaff',body,options);
    }
    
  }

  getAllRoles(): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl+'/roles');
}
  
  getAllDoctors(): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl +'/doctor');
  }

  getAllStaffs(): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl + '/staff');
  }

  getAllMedicines(): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl + '/medicine');
  }

  addMedicine(medicine: Admin){
    console.log("Service: " +medicine);
    let body = JSON.stringify(medicine);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }

    if(medicine.medId)
    {
      return this._httpService.put(environment.APIUrl +'/insertmedicine', body, options);
    }
    else
    {
      return this._httpService.post(environment.APIUrl +'/insertmedicine', body, options);
    }
  }

  searchMedicine(searchString: string): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl +'/medicine/'+ searchString);
  }

  getMedicineById(medId: string): Observable<Admin>{
    return this._httpService.get<Admin>(environment.APIUrl +'/searchmedicine/'+ medId);
  }

  disableMedicine(medId:number): Observable<Admin>{
    let body = JSON.stringify(medId);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpService.put<Admin>(environment.APIUrl +'/disablemedicine/'+ medId,body,options);
  }

  searchStaffs(searchString: string): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl +'/staff/'+ searchString);
  }

  searchDoctors(searchString: string): Observable<Admin[]>{
    return this._httpService.get<Admin[]>(environment.APIUrl +'/doctor/'+ searchString);
  }

  disableDoctor(dId:number): Observable<Admin>{
    let body = JSON.stringify(dId);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpService.put<Admin>(environment.APIUrl +'/disabledoctor/'+ dId,body,options);
  }

  disableStaff(sId:number): Observable<Admin>{
    let body = JSON.stringify(sId);
    let headers = new HttpHeaders({'Content-Type': 'application/json'});
    let options = { headers: headers }
    return this._httpService.put<Admin>(environment.APIUrl +'/disablestaff/'+ sId,body,options);
  }

  getStaffById(sId: number): Observable<Admin>{
    return this._httpService.get<Admin>(environment.APIUrl +'/editStaffDetail/'+ sId);
  }

  getDoctorById(sId: number): Observable<Admin>{
    return this._httpService.get<Admin>(environment.APIUrl +'/editDoctorDetail/'+ sId);
  }

}
