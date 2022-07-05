import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransakcijaComponent } from './transakcija.component';

describe('TransakcijaComponent', () => {
  let component: TransakcijaComponent;
  let fixture: ComponentFixture<TransakcijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransakcijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransakcijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
