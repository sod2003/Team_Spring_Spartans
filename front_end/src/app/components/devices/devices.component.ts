import { Component, Input, OnInit } from '@angular/core';
import { Device } from '../../models/device';
import { DeviceService } from '../../services/device.service';
import { CommonModule } from '@angular/common';
import { PhonelineService } from '../../services/phoneline.service';
import { ActivatedRoute } from '@angular/router';
import { PhonePlan } from '../../models/phone-plan';

@Component({
  selector: 'app-devices',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './devices.component.html',
  styleUrl: './devices.component.css'
})
export class DevicesComponent implements OnInit {

  devices: Device[] = [];
  @Input() phonePlans: PhonePlan[] = [];
  lines: number = 0;

  constructor(
    private deviceService: DeviceService,
    private phonelineService: PhonelineService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.deviceService.devicesObservable.subscribe((data) => {
      this.devices = data;
    });
    this.phonelineService.devicesOfCustObservable.subscribe((data) => {
      this.lines = data.length;
    });
  }

  addPhoneline(deviceId: number) {
    this.phonelineService.createPhoneline(this.activatedRoute.snapshot.params["custId"], deviceId);
    location.reload();
  }

  maxLines() {
    let totalLines = 0;
    if (this.phonePlans == null) return false;
    for (let plan of this.phonePlans) {
      totalLines += plan.phoneLines;
    }
    return this.lines < totalLines;
  }
}
