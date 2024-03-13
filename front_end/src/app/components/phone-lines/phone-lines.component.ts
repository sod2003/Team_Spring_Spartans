import { Component, Input, OnInit } from '@angular/core';
import { DeviceService } from '../../services/device.service';
import { PhonelineService } from '../../services/phoneline.service';
import { Device } from '../../models/device';
import { Phoneline } from '../../models/phoneline';

@Component({
  selector: 'app-phone-lines',
  standalone: true,
  imports: [],
  templateUrl: './phone-lines.component.html',
  styleUrl: './phone-lines.component.css'
})
export class PhoneLinesComponent implements OnInit {

  @Input() custId: number = 0;
  devices: Device[] = [];
  phonelines: Phoneline[] = [];

  constructor(private deviceService: DeviceService, private phonelineService: PhonelineService) {}

  ngOnInit(): void {
      this.deviceService.devicesObservable.subscribe((data) => {
        this.devices = data;
      });
      this.phonelineService.allPhonelines.subscribe((data) => {
        this.phonelines = data;
      });
  }

  addPhoneline() {
    this.phonelineService.createPhoneline(this.custId, newPhonelineDialogue());
  }

  removePhoneline(phoneline: Phoneline, index: number) {
    console.log(phoneline);
    this.phonelines.splice(index, 1);
    // this.phonelineService.deleteById(custId, phoneline.phoneNumber); // This will call the endpoint to delete this phone line from the customer account.
  }
}

function newPhonelineDialogue(): Phoneline {
  // TODO Implement newPhonelineDialogue
  throw new Error('Function not implemented.');
}

