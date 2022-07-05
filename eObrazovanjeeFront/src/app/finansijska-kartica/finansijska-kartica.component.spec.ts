import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinansijskaKarticaComponent } from './finansijska-kartica.component';

describe('FinansijskaKarticaComponent', () => {
  let component: FinansijskaKarticaComponent;
  let fixture: ComponentFixture<FinansijskaKarticaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FinansijskaKarticaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FinansijskaKarticaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
