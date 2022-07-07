import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProfesorComponent } from './edit-profesor.component';

describe('EditProfesorComponent', () => {
  let component: EditProfesorComponent;
  let fixture: ComponentFixture<EditProfesorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditProfesorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditProfesorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
