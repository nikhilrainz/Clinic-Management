import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewfulltodaysappointmentComponent } from './viewfulltodaysappointment.component';

describe('ViewfulltodaysappointmentComponent', () => {
  let component: ViewfulltodaysappointmentComponent;
  let fixture: ComponentFixture<ViewfulltodaysappointmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewfulltodaysappointmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewfulltodaysappointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
