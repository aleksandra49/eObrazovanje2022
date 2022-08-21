import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditIspitComponent } from './edit-ispit.component';

describe('EditIspitComponent', () => {
  let component: EditIspitComponent;
  let fixture: ComponentFixture<EditIspitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditIspitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditIspitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
