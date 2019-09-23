import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FrontOffice } from '../frontoffice';
import { FrontofficeService } from '../frontoffice.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-viewfulltodaysappointment',
  templateUrl: './viewfulltodaysappointment.component.html',
  styleUrls: ['./viewfulltodaysappointment.component.scss']
})
export class ViewfulltodaysappointmentComponent implements OnInit {
  todaysappoinment: FrontOffice[];
  todayappoinment = new FrontOffice();
  patient = new FrontOffice();
  message: string;
  regId: number;
  searchString: string;

  constructor(private _router: Router, private _authservice: AuthService, private _frontoffice: FrontofficeService) { }



  ngOnInit() {
    this.getTodaysAppoinment();
  }


  getTodaysAppoinment(): void {
    this._frontoffice.getappointments()
      .subscribe((appoinmentData) => {
        this.todaysappoinment = appoinmentData,
          console.log(appoinmentData);
      }, (error) => {
        console.log(error);
      });
  }

  searchTodaysAppoinment(searchString: string) {
    console.log(searchString);
    this._frontoffice.searchTodaysAppoinment(searchString).subscribe((response) => {
      this.todaysappoinment = response
      if (searchString != null) {
        console.log(response);
        if (response.length == 0) {
          this.message = "Not Found";
          console.log(this.message);
          //this.searchString = undefined;
        }
        else {
          this.todaysappoinment = response
          console.log(this.todaysappoinment);
          this.message = undefined;
        }
      }
      else {
        this.view();
      }
    }, (error) => {
      console.log(error);
    });
  }

  back(): void {
    this._router.navigate(['viewpat']);
  }
  /********************** LOGOUT *****************************/
  logout() {  
    console.log('logout');  
    this._authservice.logout();  
  }

  edit(regId: number): void {
    console.log(regId);
    this._router.navigate(['addpat/' + regId]);
  }
  view(): void {
    this.getTodaysAppoinment();
    this.message = undefined;
    this.searchString = undefined;
  }
}
