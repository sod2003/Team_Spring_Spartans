import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhoneLinesComponent } from './phone-lines.component';

describe('PhoneLinesComponent', () => {
  let component: PhoneLinesComponent;
  let fixture: ComponentFixture<PhoneLinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PhoneLinesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PhoneLinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
