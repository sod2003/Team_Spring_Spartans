import { Component, Input, OnInit } from '@angular/core';
import { DeviceService } from '../../services/device.service';
import { PhonelineService } from '../../services/phoneline.service';
import { Device } from '../../models/device';
import { Phoneline } from '../../models/phoneline';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-phone-lines',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './phone-lines.component.html',
  styleUrl: './phone-lines.component.css'
})
export class PhoneLinesComponent implements OnInit {

  phonelines: Phoneline[] = [];
  devices: Device[] = [];

  constructor(
    private deviceService: DeviceService,
    private phonelineService: PhonelineService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.deviceService.getAllDevices();
    this.phonelineService.phonelinesObservable.subscribe((data) => {
      this.phonelines = data;
    });
    this.deviceService.devicesObservable.subscribe((data) => {
      this.devices = data;
    });

  }

  removePhoneline(phoneline: Phoneline, index: number) {
    console.log(phoneline);
    this.phonelines.splice(index, 1);
    this.phonelineService.deleteById(this.activatedRoute.snapshot.params["custId"], phoneline.phoneNumber); // This will call the endpoint to delete this phone line from the customer account.
  }

  retrieveCustomerDevice(deviceId: number) {
    return this.devices.at(deviceId - 1);
  } 


}
