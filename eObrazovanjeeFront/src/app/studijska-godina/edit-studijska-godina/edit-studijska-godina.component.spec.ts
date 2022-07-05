import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditStudijskaGodinaComponent } from './edit-studijska-godina.component';

describe('EditStudijskaGodinaComponent', () => {
  let component: EditStudijskaGodinaComponent;
  let fixture: ComponentFixture<EditStudijskaGodinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditStudijskaGodinaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditStudijskaGodinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
