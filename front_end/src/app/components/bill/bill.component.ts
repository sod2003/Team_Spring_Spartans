import { Component } from '@angular/core';
import { PhonePlan } from '../../models/phone-plan';
import { Device } from '../../models/device';
import { PhonePlanService } from '../../services/phone-plan.service';
import { DeviceService } from '../../services/device.service';

@Component({
  selector: 'app-bill',
  standalone: true,
  imports: [],
  templateUrl: './bill.component.html',
  styleUrl: './bill.component.css'
})
export class BillComponent {

  phonePlan: PhonePlan = new PhonePlan(0, 0, 0, 0);
  devices: Device[] = [];

  constructor(private phonePlanService: PhonePlanService,
    private deviceService: DeviceService) { }

  ngOnInit(): void {
    this.deviceService.devicesObservable.subscribe((data) => {
      this.devices = data;
    });
  }

}
