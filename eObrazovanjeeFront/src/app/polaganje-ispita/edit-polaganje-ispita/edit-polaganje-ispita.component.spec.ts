import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPolaganjeIspitaComponent } from './edit-polaganje-ispita.component';

describe('EditPolaganjeIspitaComponent', () => {
  let component: EditPolaganjeIspitaComponent;
  let fixture: ComponentFixture<EditPolaganjeIspitaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPolaganjeIspitaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPolaganjeIspitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
