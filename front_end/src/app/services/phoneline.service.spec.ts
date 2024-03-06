import { TestBed } from '@angular/core/testing';

import { PhonelineService } from './phoneline.service';

describe('PhonelineService', () => {
  let service: PhonelineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PhonelineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
