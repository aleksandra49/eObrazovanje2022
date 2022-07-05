import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIspitniRokComponent } from './add-ispitni-rok.component';

describe('AddIspitniRokComponent', () => {
  let component: AddIspitniRokComponent;
  let fixture: ComponentFixture<AddIspitniRokComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddIspitniRokComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIspitniRokComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
