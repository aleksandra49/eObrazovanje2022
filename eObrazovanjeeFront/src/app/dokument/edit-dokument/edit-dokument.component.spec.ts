import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDokumentComponent } from './edit-dokument.component';

describe('EditDokumentComponent', () => {
  let component: EditDokumentComponent;
  let fixture: ComponentFixture<EditDokumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditDokumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDokumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
