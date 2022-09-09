import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NepolozeniIspitiComponent } from './nepolozeni-ispiti.component';

describe('NepolozeniIspitiComponent', () => {
  let component: NepolozeniIspitiComponent;
  let fixture: ComponentFixture<NepolozeniIspitiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NepolozeniIspitiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NepolozeniIspitiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
