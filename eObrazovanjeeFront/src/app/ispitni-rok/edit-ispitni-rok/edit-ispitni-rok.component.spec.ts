import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditIspitniRokComponent } from './edit-ispitni-rok.component';

describe('EditIspitniRokComponent', () => {
  let component: EditIspitniRokComponent;
  let fixture: ComponentFixture<EditIspitniRokComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditIspitniRokComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditIspitniRokComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
