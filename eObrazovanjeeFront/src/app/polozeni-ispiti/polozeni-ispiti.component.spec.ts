import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolozeniIspitiComponent } from './polozeni-ispiti.component';

describe('PolozeniIspitiComponent', () => {
  let component: PolozeniIspitiComponent;
  let fixture: ComponentFixture<PolozeniIspitiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PolozeniIspitiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PolozeniIspitiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
