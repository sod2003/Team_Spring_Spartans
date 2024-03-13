import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Device } from '../models/device';
import { BehaviorSubject, Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  localHost: string = 'http://localhost:8080/devices';

  // All Devices
  devicesRaw: Device[] = [];
  devicesSubject = new BehaviorSubject<Device[]>([]);
  devicesObservable = this.devicesSubject.asObservable();

  // All Devices of Current Customer
  devicesOfCustRaw: Device[] = [];
  devicesOfCustSubject = new BehaviorSubject<Device[]>([]);
  devicesOfCustObservable = this.devicesOfCustSubject.asObservable();

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {
    this.getAllDevices();
  }

  createDevice(device: Device) {
    this.http.post<any>(this.localHost, device, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

  getAllDevices() {
    const headers = this.authService.getHeader();
    this.http.get<any>(this.localHost, { headers, observe: 'response' })
      .subscribe(data => {
        this.devicesRaw = [];
        for (let device of data.body) {
          this.devicesRaw.push(new Device(device.deviceId, device.name, device.brand, device.price));
        }
        this.devicesSubject.next(this.devicesRaw);
      });
  }

  getDeviceById(deviceId: number): any {
    let device: any;
    const headers = this.authService.getHeader();
    this.http.get<any>(`${this.localHost}/${deviceId}`, { headers, observe: 'response' })
    .subscribe(data => {
      this.devicesOfCustRaw = [];
      for (let device of data.body) {
        device = new Device(device.deviceId, device.name, device.brand, device.price)
        this.devicesOfCustRaw.push(device);
      }
      this.devicesOfCustSubject.next(this.devicesOfCustRaw);
    });
    return device
  }

  updateDevice(deviceId: number, device: Device) {
    device.setDeviceId(deviceId);
    this.http.put<any>(`${this.localHost}/${deviceId}`, device, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

  deleteDevice(deviceId: number) {
    this.http.delete<any>(`${this.localHost}/${deviceId}`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

}
