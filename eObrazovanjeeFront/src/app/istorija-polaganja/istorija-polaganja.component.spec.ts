import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IstorijaPolaganjaComponent } from './istorija-polaganja.component';

describe('IstorijaPolaganjaComponent', () => {
  let component: IstorijaPolaganjaComponent;
  let fixture: ComponentFixture<IstorijaPolaganjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IstorijaPolaganjaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IstorijaPolaganjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
