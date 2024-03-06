import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestphonelineComponent } from './testphoneline.component';

describe('TestphonelineComponent', () => {
  let component: TestphonelineComponent;
  let fixture: ComponentFixture<TestphonelineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TestphonelineComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TestphonelineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
