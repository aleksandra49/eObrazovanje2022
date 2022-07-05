import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPohadanjePredmetaComponent } from './add-pohadanje-predmeta.component';

describe('AddPohadanjePredmetaComponent', () => {
  let component: AddPohadanjePredmetaComponent;
  let fixture: ComponentFixture<AddPohadanjePredmetaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPohadanjePredmetaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPohadanjePredmetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
