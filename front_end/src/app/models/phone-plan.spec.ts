import { PhonePlan } from './phone-plan';

describe('PhonePlan', () => {
  it('should create an instance', () => {
    expect(new PhonePlan(0,0,0,0)).toBeTruthy();
  });
});
