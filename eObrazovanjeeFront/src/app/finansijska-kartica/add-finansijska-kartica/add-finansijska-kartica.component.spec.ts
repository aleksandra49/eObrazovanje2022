import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFinansijskaKarticaComponent } from './add-finansijska-kartica.component';

describe('AddFinansijskaKarticaComponent', () => {
  let component: AddFinansijskaKarticaComponent;
  let fixture: ComponentFixture<AddFinansijskaKarticaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFinansijskaKarticaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFinansijskaKarticaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
