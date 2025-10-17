import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Sigup } from './sigup';

describe('Sigup', () => {
  let component: Sigup;
  let fixture: ComponentFixture<Sigup>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Sigup]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Sigup);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
