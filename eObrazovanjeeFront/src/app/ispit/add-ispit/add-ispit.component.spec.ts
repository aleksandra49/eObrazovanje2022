import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIspitComponent } from './add-ispit.component';

describe('AddIspitComponent', () => {
  let component: AddIspitComponent;
  let fixture: ComponentFixture<AddIspitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddIspitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIspitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
