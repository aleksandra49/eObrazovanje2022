import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrijavaIspitComponent } from './prijava-ispit.component';

describe('PrijavaIspitComponent', () => {
  let component: PrijavaIspitComponent;
  let fixture: ComponentFixture<PrijavaIspitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrijavaIspitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrijavaIspitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
