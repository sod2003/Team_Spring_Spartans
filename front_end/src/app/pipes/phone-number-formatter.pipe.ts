import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phoneNumberFormatter',
  standalone: true
})
export class PhoneNumberFormatterPipe implements PipeTransform {

  transform(value: string, ...args: string[]): string {
    return value.substring(0, 3) + "-" + value.substring(3, 6) + "-" + value.substring(6);
  }

}
