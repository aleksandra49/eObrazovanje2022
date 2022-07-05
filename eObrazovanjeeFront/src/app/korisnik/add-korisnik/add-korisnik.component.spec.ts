import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddKorisnikComponent } from './add-korisnik.component';

describe('AddKorisnikComponent', () => {
  let component: AddKorisnikComponent;
  let fixture: ComponentFixture<AddKorisnikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddKorisnikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddKorisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
