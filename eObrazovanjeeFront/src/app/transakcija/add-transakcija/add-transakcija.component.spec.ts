import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTransakcijaComponent } from './add-transakcija.component';

describe('AddTransakcijaComponent', () => {
  let component: AddTransakcijaComponent;
  let fixture: ComponentFixture<AddTransakcijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTransakcijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTransakcijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
