import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IspitiOcenjivanjeComponent } from './ispiti-ocenjivanje.component';

describe('IspitiOcenjivanjeComponent', () => {
  let component: IspitiOcenjivanjeComponent;
  let fixture: ComponentFixture<IspitiOcenjivanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IspitiOcenjivanjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IspitiOcenjivanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
