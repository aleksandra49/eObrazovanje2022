import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TipDokumentaComponent } from './tip-dokumenta.component';

describe('TipDokumentaComponent', () => {
  let component: TipDokumentaComponent;
  let fixture: ComponentFixture<TipDokumentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TipDokumentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TipDokumentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
