import { Component } from '@angular/core';
import { Phoneline } from '../../models/phoneline';
import { PhonelineService } from '../../services/phoneline.service';
import { Device } from '../../models/device';

@Component({
  selector: 'app-testphoneline',
  standalone: true,
  imports: [],
  templateUrl: './testphoneline.component.html',
  styleUrl: './testphoneline.component.css'
})
export class TestphonelineComponent {

  phonelines: Phoneline[] = [];

  constructor(private phonelineService: PhonelineService) {
    this.phonelineService.getAllPhonelines('1');
    this.phonelineService.allPhonelines.subscribe(data => {
      this.phonelines = data;
      console.log(data);
    });
    this.phonelineService.createPhoneline("1", new Phoneline("404-455-5555", new Device(3, "", "", 0)));
    this.phonelineService.getPhonelineById("1", "404-455-4555");
    this.phonelineService.deleteById("1", "404-455-4555");
  }
}
