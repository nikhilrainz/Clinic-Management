import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../login';
import { AuthService } from '../auth.service';
import { Doctor } from '../doctor';
import { DoctorserviceService } from '../doctorservice.service';

@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.scss']
})
export class AdmindashboardComponent implements OnInit {
  login=new Login();
  roleid: number;
  message: string;
  sessionTokenUserName:string;
  sessionTokenRoleID:string;
  doctorId = new Doctor();

  constructor(private router:Router, private _authservice : AuthService,private _doctorService :DoctorserviceService) { }

  ngOnInit() {

    this.resetForm()
    this.sessionTokenUserName=localStorage.getItem('token');
    console.log(this.sessionTokenUserName=localStorage.getItem('token'));
    this.sessionTokenRoleID=localStorage.getItem('tokenRoleId');
    console.log(this.sessionTokenRoleID=localStorage.getItem('tokenRoleId'));
  }
  resetForm(form?: NgForm){
    if(form!=null)
    form.resetForm();
    this._authservice.formData={
      
      sId: null,
    roleId: null,
    sName: '',
    sDOB: null,
    sGender: '',
    sAddr: '',
    sExp: '',
    sPhNo:'',
    sEmail:'',
    username: '',
    password: '',
    isActiveS: '',
    createdDateS: null,
    }
   }
   OnSubmit(form:NgForm)
  {
    console.log("My form : " +form);
    this.loginUser(form);
  }

  loginUser(form:NgForm) {
    //if((this.sessionTokenUserName==null) && (this.sessionTokenRoleID==null))
    //{
      console.log(form.value);
      this._authservice.getRole(form.value).subscribe((userData) =>{
        this.login = userData;
        console.log(this.login);
        var username = this.login.username;
        var password = this.login.password;
        //localStorage.setItem('isLoggedIn', "true");
        //localStorage.setItem('token', userData.uname);
        //localStorage.setItem('tokenRoleId', userData.roleId);
        this.roleid = userData.roleId;
        console.log(userData.roleId);
        if(this.roleid == 1)
        {
          console.log("success");
          this.router.navigate(['/admindashboard']);
        }
        else if(this.roleid == 2)
        {
          console.log("success");
          this.router.navigate(['/viewpat']);
        }
        else if(this.roleid == 3)
        {
          console.log("success");
          this._doctorService.getDid(username,password).subscribe((dId) =>{
            console.log(dId);
          this.doctorId = dId;
          console.log(this.doctorId.dId);
          this.router.navigate(['/viewdocapp/'+this.doctorId.dId]);
          }, (error) => {
            console.log(error);
          });
        }
        else if(this.roleid == 4)
        {
          this.router.navigate(['/accountant']);
        }
        else if(this.roleid == 5)
        {
          this.router.navigate(['/member']);
        }
        else
        {
          this.message = "Invalid username or password";
          this.router.navigate(['']);
        }
      }, (error) => {
        console.log(error);
      });
    } 
  }




