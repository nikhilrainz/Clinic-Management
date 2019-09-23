import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewDoctorsAppointmentsComponent } from './view-doctors-appointments/view-doctors-appointments.component';
import { ViewdoctorComponent } from './viewdoctor/viewdoctor.component';
import { ViewfulltodaysappointmentComponent } from './viewfulltodaysappointment/viewfulltodaysappointment.component';
import { ViewmedicineComponent } from './viewmedicine/viewmedicine.component';
import { ViewpatientsComponent } from './viewpatients/viewpatients.component';
import { ViewstaffComponent } from './viewstaff/viewstaff.component';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
import { AdddoctorComponent } from './adddoctor/adddoctor.component';
import { AddpatientsComponent } from './addpatients/addpatients.component';
import { MedicinerequestComponent } from './medicinerequest/medicinerequest.component';
import { PatienthistoryComponent } from './patienthistory/patienthistory.component';


import { CardComponent } from './card/card.component';
import { LoginComponent } from './login/login.component';
import { ConsultationComponent } from './consultation/consultation.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { LabrequestComponent } from './labrequest/labrequest.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'admindashboard', component: CardComponent, canActivate: [AuthGuard]},
  { path: 'viewdoc', component: ViewdoctorComponent, canActivate: [AuthGuard] },
  { path: 'viewstaff', component: ViewstaffComponent, canActivate: [AuthGuard] },
  { path: 'viewmed', component: ViewmedicineComponent, canActivate: [AuthGuard] },
  { path: 'adddoc', component: AdddoctorComponent, canActivate: [AuthGuard] },
  { path: 'addstaff', component: AddStaffComponent, canActivate: [AuthGuard] },
  { path: 'addmed', component: AddmedicineComponent, canActivate: [AuthGuard] },
  { path: 'viewpat', component: ViewpatientsComponent, canActivate: [AuthGuard] },
  { path: 'addpat', component: AddpatientsComponent, canActivate: [AuthGuard] },

  { path: 'consult/:regId', component: ConsultationComponent, canActivate: [AuthGuard] },
  { path: 'viewtodayapp', component: ViewfulltodaysappointmentComponent, canActivate: [AuthGuard] },
  { path: 'viewdocapp/:dId', component: ViewDoctorsAppointmentsComponent, canActivate: [AuthGuard] },
  { path: 'pathis/:dId/:regId', component: PatienthistoryComponent, canActivate: [AuthGuard] },
  { path: 'addpresc/:dId/:regId', component: MedicinerequestComponent, canActivate: [AuthGuard] },
  { path: 'addlab/:dId/:regId', component: LabrequestComponent,canActivate: [AuthGuard] },
  { path: 'addmed/:medId', component: AddmedicineComponent, canActivate: [AuthGuard] },
  { path: 'addstaff/:sId', component: AddStaffComponent, canActivate: [AuthGuard] },
  { path: 'adddoc/:sId', component: AdddoctorComponent, canActivate: [AuthGuard] },
  { path: 'addpat/:regId', component: AddpatientsComponent, canActivate: [AuthGuard] },
  //  {path:'',component:AdmindashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
