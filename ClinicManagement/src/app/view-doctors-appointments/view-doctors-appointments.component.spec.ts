import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDoctorsAppointmentsComponent } from './view-doctors-appointments.component';

describe('ViewDoctorsAppointmentsComponent', () => {
  let component: ViewDoctorsAppointmentsComponent;
  let fixture: ComponentFixture<ViewDoctorsAppointmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDoctorsAppointmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDoctorsAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
