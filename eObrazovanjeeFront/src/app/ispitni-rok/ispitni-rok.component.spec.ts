import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IspitniRokComponent } from './ispitni-rok.component';

describe('IspitniRokComponent', () => {
  let component: IspitniRokComponent;
  let fixture: ComponentFixture<IspitniRokComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IspitniRokComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IspitniRokComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
