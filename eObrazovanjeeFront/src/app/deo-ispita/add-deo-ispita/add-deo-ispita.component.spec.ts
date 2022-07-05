import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDeoIspitaComponent } from './add-deo-ispita.component';

describe('AddDeoIspitaComponent', () => {
  let component: AddDeoIspitaComponent;
  let fixture: ComponentFixture<AddDeoIspitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDeoIspitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDeoIspitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
