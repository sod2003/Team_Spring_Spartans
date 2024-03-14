import { Component, OnInit } from '@angular/core';
import { Device } from '../../models/device';
import { DeviceService } from '../../services/device.service';
import { CommonModule } from '@angular/common';
import { PhonelineService } from '../../services/phoneline.service';
import { PhoneLinesComponent } from '../phone-lines/phone-lines.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-devices',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './devices.component.html',
  styleUrl: './devices.component.css'
})
export class DevicesComponent implements OnInit {

  devices: Device[] = [];

  constructor(
    private deviceService: DeviceService,
    private phonelineService: PhonelineService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.deviceService.devicesObservable.subscribe((data) => {
      this.devices = data;
    });
  }

  addPhoneline(deviceId: number) {
    this.phonelineService.createPhoneline(this.activatedRoute.snapshot.params["custId"], deviceId);
    location.reload();
  }

}
