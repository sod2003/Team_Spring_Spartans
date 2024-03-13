import { Component, Input, OnInit } from '@angular/core';
import { DeviceService } from '../../services/device.service';
import { PhonelineService } from '../../services/phoneline.service';
import { Device } from '../../models/device';
import { Phoneline } from '../../models/phoneline';
import { CommonModule } from '@angular/common';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-phone-lines',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './phone-lines.component.html',
  styleUrl: './phone-lines.component.css'
})
export class PhoneLinesComponent implements OnInit {

  @Input() custId: number = 0;
  devicesOfCustRaw: Device[] = [];
  devicesOfCustSubject = new BehaviorSubject<Device[]>([]);
  devicesOfCustObservable = this.devicesOfCustSubject.asObservable();
  phonelines: Phoneline[] = [];

  constructor(
    private deviceService: DeviceService,
    private phonelineService: PhonelineService
  ) { }

  ngOnInit(): void {
    this.getDevicesOfCust();
    this.phonelineService.allPhonelines.subscribe((data) => {
      this.phonelines = data;
    });
  }

  getDevicesOfCust() {
    for (let phoneline of this.phonelines) {
      this.devicesOfCustRaw.push(this.deviceService.getDeviceById(phoneline.deviceId));
    }
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

