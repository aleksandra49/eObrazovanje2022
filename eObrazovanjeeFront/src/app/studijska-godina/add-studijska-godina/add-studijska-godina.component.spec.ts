import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStudijskaGodinaComponent } from './add-studijska-godina.component';

describe('AddStudijskaGodinaComponent', () => {
  let component: AddStudijskaGodinaComponent;
  let fixture: ComponentFixture<AddStudijskaGodinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStudijskaGodinaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddStudijskaGodinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
