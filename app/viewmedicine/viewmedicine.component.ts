import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';


@Component({
  selector: 'app-viewmedicine',
  templateUrl: './viewmedicine.component.html',
  styleUrls: ['./viewmedicine.component.scss']
})
export class ViewmedicineComponent implements OnInit {

  medicines: Admin[];
  medicine = new Admin();
  medicineId: number;
  searchString: string;
  message:string;
  constructor(private _router:Router, private _adminService: AdminServiceService) { }

  ngOnInit() {
    this.getAllMedicines();
  }

  /********** HEADERS ***************/
  back():void{
    this._router.navigate(['admindashboard']);
  }
  logout():void{
    this._router.navigate(['']);
  }
  addmed():void{
    this._router.navigate(['addmed']);
  }
  viewAll():void{
    this.getAllMedicines();
  }
  edit(medId:number):void{
    console.log(medId);
    this._router.navigate(['addmed/'+medId]);
  }

  getAllMedicines():void{
    this.message = undefined;
    this._adminService.getAllMedicines()
    .subscribe((medicineData) =>{
      this.medicines = medicineData;
      console.log(medicineData);
    }, (error) =>{
      console.log(error);
    });
  }

  searchMedicines(searchString:string){
    console.log(searchString);
    this._adminService.searchMedicine(searchString)
      .subscribe((response)=>{
        if(searchString!=null)
        {
          console.log(response);
          if(response.length == 0)
          {
            this.message = "Not Found";
            console.log(this.message);
            //this.searchString = undefined;
          }
          else
          {
            this.medicines = response
            console.log(this.medicines);
            this.searchString = undefined;
            this.message = undefined;
          }
        }
        else
        {
          console.log("hits");
          this.getAllMedicines();
        }
    }
      , (error)=>{
        console.log(error);
        this.message = "Please use Id or Name"
        this.searchString = undefined;
      });
  }

  disableMedicine(medId:number):void{
    console.log(medId);
    this._adminService.disableMedicine(medId)
    .subscribe((response)=>{
      //console.log(response);
      this.medicine = response
      console.log(this.medicine);
      this.getAllMedicines();
    }, (error)=>{
      console.log(error);
    });
  }
}
