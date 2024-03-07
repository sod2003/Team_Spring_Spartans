import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestphonePlanComponent } from './testphone-plan.component';

describe('TestphonePlanComponent', () => {
  let component: TestphonePlanComponent;
  let fixture: ComponentFixture<TestphonePlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TestphonePlanComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TestphonePlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
