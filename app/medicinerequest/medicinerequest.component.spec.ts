import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicinerequestComponent } from './medicinerequest.component';

describe('MedicinerequestComponent', () => {
  let component: MedicinerequestComponent;
  let fixture: ComponentFixture<MedicinerequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicinerequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicinerequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
