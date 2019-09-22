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

const routes: Routes = [
          {path:'',component:LoginComponent},
          {path:'admindashboard',component:CardComponent},
          {path:'viewdoc',component:ViewdoctorComponent},
           {path:'viewstaff',component:ViewstaffComponent},
           {path:'viewmed',component:ViewmedicineComponent},
           {path:'adddoc',component:AdddoctorComponent},
           {path:'addstaff',component:AddStaffComponent},
           {path:'addmed',component:AddmedicineComponent},
           {path:'viewpat',component:ViewpatientsComponent},
           {path:'addpat',component:AddpatientsComponent},
           
           {path:'consult/:regId',component:ConsultationComponent},
           {path:'viewtodayapp',component:ViewfulltodaysappointmentComponent},
           {path:'viewdocapp/:dId',component:ViewDoctorsAppointmentsComponent},
           {path:'pathis/:dId/:regId',component:PatienthistoryComponent},
           {path:'addpresc/:dId/:regId',component:MedicinerequestComponent},
           {path:'addlab/:dId/:regId',component:LabrequestComponent},
           {path:'addmed/:medId',component:AddmedicineComponent},
           {path:'addstaff/:sId',component:AddStaffComponent},
           {path:'adddoc/:sId',component:AdddoctorComponent},
           {path:'addpat/:regId',component:AddpatientsComponent},
         //  {path:'',component:AdmindashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
