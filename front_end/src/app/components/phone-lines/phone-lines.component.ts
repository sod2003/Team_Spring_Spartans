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
  phonelines: Phoneline[] = [];
  devices: Device[] = [];

  constructor(
    private deviceService: DeviceService,
    private phonelineService: PhonelineService
  ) { }

  ngOnInit(): void {
    this.deviceService.getAllDevices();
    this.phonelineService.getAllPhonelines(this.custId);
    this.phonelineService.allPhonelines.subscribe((data) => {
      this.phonelines = data;
    });
    this.deviceService.devicesObservable.subscribe((data) => {
      this.devices = data;
    });
  }

  addPhoneline() {
    this.phonelineService.createPhoneline(this.custId, this.newPhonelineDialogue());
  }

  removePhoneline(phoneline: Phoneline, index: number) {
    console.log(phoneline);
    this.phonelines.splice(index, 1);
    // this.phonelineService.deleteById(custId, phoneline.phoneNumber); // This will call the endpoint to delete this phone line from the customer account.
  }

  retrieveCustomerDevice(deviceId: number) {
    return this.devices.at(deviceId - 1);
  } 

  newPhonelineDialogue(): Phoneline {
    let last4 = Number.parseInt(this.phonelines.at(-1)!.phoneNumber.slice(8)) + 1;
    let number = "404-433-" + last4;
    // This is where I'd assign a device, but we don't have a device purchase dialogue.
    let phone: Phoneline = new Phoneline(number, 1);
    return phone;
  }
}
