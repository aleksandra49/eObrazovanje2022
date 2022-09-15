import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OdjavaIspitComponent } from './odjava-ispit.component';

describe('OdjavaIspitComponent', () => {
  let component: OdjavaIspitComponent;
  let fixture: ComponentFixture<OdjavaIspitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OdjavaIspitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OdjavaIspitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
