import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolaganjeIspitaComponent } from './polaganje-ispita.component';

describe('PolaganjeIspitaComponent', () => {
  let component: PolaganjeIspitaComponent;
  let fixture: ComponentFixture<PolaganjeIspitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PolaganjeIspitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PolaganjeIspitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
