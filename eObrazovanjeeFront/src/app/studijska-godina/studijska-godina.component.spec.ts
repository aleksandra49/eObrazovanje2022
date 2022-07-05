import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudijskaGodinaComponent } from './studijska-godina.component';

describe('StudijskaGodinaComponent', () => {
  let component: StudijskaGodinaComponent;
  let fixture: ComponentFixture<StudijskaGodinaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudijskaGodinaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudijskaGodinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
