import { Component, OnInit } from '@angular/core';
import { Device } from '../../models/device';
import { DeviceService } from '../../services/device.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-devices',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './devices.component.html',
  styleUrl: './devices.component.css'
})
export class DevicesComponent implements OnInit {

  devices: Device[] = [];

  constructor(private deviceService: DeviceService) {}

  ngOnInit(): void {
      this.deviceService.devicesObservable.subscribe((data) => {
        this.devices = data;
      });
  }

}
