import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.scss']
})
export class AddStaffComponent implements OnInit {

  constructor(private route: ActivatedRoute, private _router:Router,private adminService:AdminServiceService) { }

  staffs:Admin[];
  roles:Admin[];
  staff=new Admin();
  confirmpassword: String;
  errMessage: String

  ngOnInit() {
    this.errMessage=null;
    this.getRoles();
    this.staff.isActiveS = "yes";
    this.route.params.subscribe(params => this.getStaffById(params['sId']));
  }

  private reset()
  {
    this.staff.sName=null;
    this.staff.username=null;
    this.staff.password=null;
    this.staff.sDOB=null;
    this.staff.sGender=null;
    this.staff.sAddr=null;
    this.staff.sPhNo=null;
    this.staff.sEmail=null;
    this.staff.sExp=null;
    this.staff.roleName=null;
  }
  
  getRoles(): void{
    this.adminService.getAllRoles()
    .subscribe((roles)=>{
      this.roles=roles,
      console.log(roles);
    }, (error) =>{
      console.log(error);
    });
  }

  checkPassword():void{
    if(this.staff.password===this.confirmpassword)
    {
      this.addStaffServ();
    }
    else{
      this.errMessage="Password Mismatch";
    }
  }

  
  addStaffServ():void{
    console.log(this.staff);
    this.adminService.addStaffServ(this.staff)
    .subscribe((response)=>{
     console.log(response);
     this._router.navigate(['viewstaff'])
     //this.reset();
    },(error)=>{
      console.log(error);
    });
  }

  updateStaff():void{
     console.log(this.staff);
     this.adminService.addStaffServ(this.staff)
     .subscribe((response)=>{
      console.log(response);
      this._router.navigate(['viewstaff'])
    },(error)=>{
       console.log(error);
     });
   }

  getStaffById(sId: number)
  {
    console.log("sId"+sId);
    this.adminService.getStaffById(sId)
    .subscribe((response)=>{
      console.log(response);
      this.staff= response;
     },(error)=>{
       console.log(error);
     });
   }
  
  back():void{
    this._router.navigate(['viewstaff']);
  }
 logout():void{
    this._router.navigate(['']);
  }
 save():void{
    this._router.navigate(['viewstaff']);
  }

 
}
