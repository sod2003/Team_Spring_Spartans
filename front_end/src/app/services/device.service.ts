import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Device } from '../models/device';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  localHost: string = 'http://localhost:8080/devices';

  constructor(private http: HttpClient) { }

  createDevice(device: Device) {
    this.http.post<any>(this.localHost, device, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

  getAllDevices() {
    this.http.get<any>(this.localHost, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

  getDeviceById(deviceId: number) {
    this.http.get<any>(`${this.localHost}/${deviceId}`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
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
