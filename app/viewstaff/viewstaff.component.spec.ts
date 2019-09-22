import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewstaffComponent } from './viewstaff.component';

describe('ViewstaffComponent', () => {
  let component: ViewstaffComponent;
  let fixture: ComponentFixture<ViewstaffComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewstaffComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewstaffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
