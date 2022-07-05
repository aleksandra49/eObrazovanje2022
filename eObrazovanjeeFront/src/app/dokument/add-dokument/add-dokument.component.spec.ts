import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDokumentComponent } from './add-dokument.component';

describe('AddDokumentComponent', () => {
  let component: AddDokumentComponent;
  let fixture: ComponentFixture<AddDokumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDokumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDokumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
