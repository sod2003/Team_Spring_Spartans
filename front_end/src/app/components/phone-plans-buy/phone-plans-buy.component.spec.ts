import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhonePlansBuyComponent } from './phone-plans-buy.component';

describe('PhonePlansBuyComponent', () => {
  let component: PhonePlansBuyComponent;
  let fixture: ComponentFixture<PhonePlansBuyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PhonePlansBuyComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PhonePlansBuyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
