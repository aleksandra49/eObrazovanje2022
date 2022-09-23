import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStudnetNaPredmetComponent } from './add-studnet-na-predmet.component';

describe('AddStudnetNaPredmetComponent', () => {
  let component: AddStudnetNaPredmetComponent;
  let fixture: ComponentFixture<AddStudnetNaPredmetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStudnetNaPredmetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddStudnetNaPredmetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
