import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPolaganjeIspitaComponent } from './add-polaganje-ispita.component';

describe('AddPolaganjeIspitaComponent', () => {
  let component: AddPolaganjeIspitaComponent;
  let fixture: ComponentFixture<AddPolaganjeIspitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPolaganjeIspitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPolaganjeIspitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
