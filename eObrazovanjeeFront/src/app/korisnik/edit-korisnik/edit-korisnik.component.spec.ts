import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditKorisnikComponent } from './edit-korisnik.component';

describe('EditKorisnikComponent', () => {
  let component: EditKorisnikComponent;
  let fixture: ComponentFixture<EditKorisnikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditKorisnikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditKorisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
