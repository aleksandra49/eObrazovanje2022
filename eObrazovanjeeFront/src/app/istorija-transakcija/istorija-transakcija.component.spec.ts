import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IstorijaTransakcijaComponent } from './istorija-transakcija.component';

describe('IstorijaTransakcijaComponent', () => {
  let component: IstorijaTransakcijaComponent;
  let fixture: ComponentFixture<IstorijaTransakcijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IstorijaTransakcijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IstorijaTransakcijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
