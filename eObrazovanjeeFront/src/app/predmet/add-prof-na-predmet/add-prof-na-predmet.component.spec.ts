import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProfNaPredmetComponent } from './add-prof-na-predmet.component';

describe('AddProfNaPredmetComponent', () => {
  let component: AddProfNaPredmetComponent;
  let fixture: ComponentFixture<AddProfNaPredmetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddProfNaPredmetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProfNaPredmetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
