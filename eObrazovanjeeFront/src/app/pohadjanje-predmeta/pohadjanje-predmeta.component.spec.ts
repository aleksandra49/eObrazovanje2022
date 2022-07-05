import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PohadjanjePredmetaComponent } from './pohadjanje-predmeta.component';

describe('PohadjanjePredmetaComponent', () => {
  let component: PohadjanjePredmetaComponent;
  let fixture: ComponentFixture<PohadjanjePredmetaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PohadjanjePredmetaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PohadjanjePredmetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
