import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeoIspitaComponent } from './deo-ispita.component';

describe('DeoIspitaComponent', () => {
  let component: DeoIspitaComponent;
  let fixture: ComponentFixture<DeoIspitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeoIspitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeoIspitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
