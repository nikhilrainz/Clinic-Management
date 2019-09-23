import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewDoctorsAppointmentsComponent } from './view-doctors-appointments/view-doctors-appointments.component';
import { ViewdoctorComponent } from './viewdoctor/viewdoctor.component';
import { ViewstaffComponent } from './viewstaff/viewstaff.component';
import { ViewpatientsComponent } from './viewpatients/viewpatients.component';
import { ViewfulltodaysappointmentComponent } from './viewfulltodaysappointment/viewfulltodaysappointment.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
import { ViewmedicineComponent } from './viewmedicine/viewmedicine.component';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { AdddoctorComponent } from './adddoctor/adddoctor.component';
import { AddpatientsComponent } from './addpatients/addpatients.component';
import { HeaderComponent } from './components/header/header.component';
import { MedicinerequestComponent } from './medicinerequest/medicinerequest.component';
import { PatienthistoryComponent } from './patienthistory/patienthistory.component';
import { NgxPaginationModule } from 'ngx-pagination';

import { HttpClientModule } from '@angular/common/http';
import { CardComponent } from './card/card.component';
import { TrialComponent } from './trial/trial.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { LoginComponent } from './login/login.component';
import { ConsultationComponent } from './consultation/consultation.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { LabrequestComponent } from './labrequest/labrequest.component';


@NgModule({
  declarations: [
    AppComponent,
    ViewdoctorComponent,
    ViewstaffComponent,
    ViewDoctorsAppointmentsComponent,
    ViewpatientsComponent,
    ViewfulltodaysappointmentComponent,
    AddStaffComponent,
    ViewmedicineComponent,
    AddmedicineComponent,
    AdddoctorComponent,
    AddpatientsComponent,
    HeaderComponent,
    MedicinerequestComponent,
    PatienthistoryComponent,
    CardComponent,
    LoginComponent,
    ConsultationComponent,
    AdmindashboardComponent,
    LabrequestComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FontAwesomeModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
