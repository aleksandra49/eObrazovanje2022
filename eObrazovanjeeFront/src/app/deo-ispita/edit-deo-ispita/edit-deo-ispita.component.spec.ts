import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDeoIspitaComponent } from './edit-deo-ispita.component';

describe('EditDeoIspitaComponent', () => {
  let component: EditDeoIspitaComponent;
  let fixture: ComponentFixture<EditDeoIspitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditDeoIspitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDeoIspitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
