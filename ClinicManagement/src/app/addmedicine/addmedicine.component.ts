import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-addmedicine',
  templateUrl: './addmedicine.component.html',
  styleUrls: ['./addmedicine.component.scss']
})
export class AddmedicineComponent implements OnInit {

  medicines: Admin[];
  medicine = new Admin();
  medicineId: number;

  constructor(private route: ActivatedRoute, private _router: Router, private _authservice: AuthService, private _adminService: AdminServiceService) { }


  ngOnInit() {
    this.route.params.subscribe(params => this.getMedicineById(params['medId']));
  }

  getMedicineById(medId: string) {
    console.log("Medicine Id " + medId);
    this._adminService.getMedicineById(medId)
      .subscribe((searchData) => {
        this.medicine = searchData;
        console.log(searchData);
      }, (error) => {
        console.log(error);
      });
  }

  /******* HEADERS ****************/
  back(): void {
    this._router.navigate(['viewmed']);
  }
  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }

  save(): void {
    console.log(this.medicine);
    this._adminService.addMedicine(this.medicine)
      .subscribe((response) => {
        console.log(response);
        this._router.navigate(['viewmed']);
      }, (error) => {
        console.log(error);
      });
  }
}

