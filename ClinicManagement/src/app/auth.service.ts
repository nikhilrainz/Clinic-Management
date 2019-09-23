import { Injectable } from '@angular/core';
import { Login } from './log';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  formData: Login;

  constructor(private router: Router, private _httpService: HttpClient) { }

  getRole(formData: any): any {
    return this._httpService.get<Login>(environment.APIUrl + '/login/' + formData.username + '/' + formData.password);

  }

  logout() :void 
  {    
    localStorage.setItem('isLoggedIn','false');    
    localStorage.removeItem('token');  
    localStorage.removeItem('tokenRoleId');
    this.router.navigate(['/login']);   
  } 

}
