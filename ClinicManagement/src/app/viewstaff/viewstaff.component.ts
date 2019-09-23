import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-viewstaff',
  templateUrl: './viewstaff.component.html',
  styleUrls: ['./viewstaff.component.scss']
})
export class ViewstaffComponent implements OnInit {

  staffs: Admin[];
  staff = new Admin();
  staffId: number;
  searchString: string;
  message: string;

  constructor(private _router: Router, private _authservice: AuthService, private _adminService: AdminServiceService) { }

  ngOnInit() {
    this.getAllStaffs();
  }

  /*********** HEADERS ***************/
  back(): void {
    this._router.navigate(['admindashboard']);
  }
  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }
  addstaff(): void {
    this._router.navigate(['addstaff']);
  }
  viewall(): void {
    this.getAllStaffs();
  }
  edit(sId: number): void {
    this._router.navigate(['addstaff/' + sId]);
    //this._router.navigate(['addstaff']);
  }

  getAllStaffs(): void {
    this.message = undefined;
    this._adminService.getAllStaffs()
      .subscribe((staffData) => {
        this.staffs = staffData;
        console.log(staffData);
      }, (error) => {
        console.log(error);
      });
  }

  searchStaffs(searchString: string) {
    console.log(searchString);
    this._adminService.searchStaffs(searchString)
      .subscribe((response) => {
        this.staffs = response;

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
            this.staffs = response
            console.log(this.staffs);
            this.searchString = undefined;
            this.message = undefined;
          }
        }
      }, (error) => {
        console.log(error);
        this.message = "Please use Id or Name"
        this.searchString = undefined;
      });
  }

  disableStaff(sId: number): void {
    console.log(sId);
    this._adminService.disableStaff(sId)
      .subscribe((disableData) => {
        //console.log(response);
        this.staff = disableData
        console.log(this.staff);
        this.getAllStaffs();
      }, (error) => {
        console.log(error);
      });
  }

}
