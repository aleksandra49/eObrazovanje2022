import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfesorPredajeComponent } from './profesor-predaje.component';

describe('ProfesorPredajeComponent', () => {
  let component: ProfesorPredajeComponent;
  let fixture: ComponentFixture<ProfesorPredajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfesorPredajeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfesorPredajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
