import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPohadanjePredmetaComponent } from './edit-pohadanje-predmeta.component';

describe('EditPohadanjePredmetaComponent', () => {
  let component: EditPohadanjePredmetaComponent;
  let fixture: ComponentFixture<EditPohadanjePredmetaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPohadanjePredmetaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPohadanjePredmetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
