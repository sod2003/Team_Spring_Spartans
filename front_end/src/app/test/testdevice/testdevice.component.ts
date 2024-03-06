import { Component, OnInit } from '@angular/core';
import { DeviceService } from '../../services/device.service';
import { Device } from '../../models/device';

@Component({
  selector: 'app-testdevice',
  standalone: true,
  imports: [],
  templateUrl: './testdevice.component.html',
  styleUrl: './testdevice.component.css'
})
export class TestDeviceComponent implements OnInit {

  constructor(private deviceService:DeviceService) {}

  ngOnInit(): void {
    this.deviceService.createDevice(new Device(0, "300", "Spartan", 399.99));
    this.deviceService.getAllDevices();
    this.deviceService.getDeviceById(1);
    this.deviceService.updateDevice(10, new Device(0, "900", "Warrior", 699.99));
    this.deviceService.getDeviceById(17);
  }

}
