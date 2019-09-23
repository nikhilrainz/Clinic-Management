import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DoctorserviceService } from '../doctorservice.service';
import { Doctor } from '../doctor';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-view-doctors-appointments',
  templateUrl: './view-doctors-appointments.component.html',
  styleUrls: ['./view-doctors-appointments.component.scss']
})
export class ViewDoctorsAppointmentsComponent implements OnInit {

  appoinments: Doctor[];
  appoinment = new Doctor();
  dId: number;
  message:string;
  searchString: string;

  constructor(private route: ActivatedRoute, private _router: Router, private _authservice: AuthService, private _doctorService: DoctorserviceService) { }

  ngOnInit() {
    this.route.params.subscribe(params => this.getAppointment(params['dId']));
    this.route.params.subscribe(params => this.getIds(params['dId']));
  }

  getIds(dId: number) {
    this.dId = dId;
    console.log(dId);
  }

  getAppointment(dId: number): void {
    console.log(dId);
    this._doctorService.getDoctorsApponintment(dId)
      .subscribe((appoinmentData) => {
        this.appoinments = appoinmentData,
          console.log(appoinmentData);
      }, (error) => {
        console.log(error);
      });
  }

  searchTodaysAppoinment(searchString: string) {
    this._doctorService.searchTodaysAppoinment(searchString).subscribe((response) => {
      this.appoinments = response
      if (searchString != null) 
        {
          console.log(this.appoinments);
          if (response.length == 0) 
          {
            this.message = "Not Found";
            this.searchString = undefined;
          }
          else 
          {
            this.appoinments = response
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

  refresh(): void {
    window.location.reload();
  }

  viewAll(): void {
    this.message = undefined;
    console.log(this.dId);
    this.refresh();
    this._router.navigate(['viewdocapp/' + this.dId]);

  }

  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }

  viewHistory(regId: string, dId: number): void {
    this._router.navigate(['pathis/' + dId + '/' + regId]);
  }
}
