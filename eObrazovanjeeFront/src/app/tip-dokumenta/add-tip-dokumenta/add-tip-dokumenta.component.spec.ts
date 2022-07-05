import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTipDokumentaComponent } from './add-tip-dokumenta.component';

describe('AddTipDokumentaComponent', () => {
  let component: AddTipDokumentaComponent;
  let fixture: ComponentFixture<AddTipDokumentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTipDokumentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTipDokumentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
