import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Phoneline } from '../models/phoneline';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { Device } from '../models/device';
import { AuthService } from './auth.service';
import { ActivatedRoute } from '@angular/router';
import { DashboardComponent } from '../pages/dashboard/dashboard.component';
import { CustomerService } from './customer.service';

@Injectable({
  providedIn: 'root'
})
export class PhonelineService {

  localHost: string = 'http://localhost:8080/customers';

  phonelinesRaw: Phoneline[] = [];
  phonelinesSubject = new BehaviorSubject<Phoneline[]>([]);
  phonelinesObservable = this.phonelinesSubject.asObservable();

  devicesOfCustRaw: Device[] = [];
  devicesOfCustSubject = new BehaviorSubject<Device[]>([]);
  devicesOfCustObservable = this.devicesOfCustSubject.asObservable();

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) { }

  createPhoneline(custId: number, phoneline: Phoneline) {
    const headers = this.authService.getHeader();
    this.http.post<any>(`${this.localHost}/${custId}/lines`, phoneline, { headers, observe: 'response' })
      .subscribe(data => {
        console.log(data);
      });
  }

  getAllPhonelines(custId: number) {
    const headers = this.authService.getHeader();
    this.http.get<any>(`${this.localHost}/${custId}/lines`, { headers, observe: 'response' })
      .subscribe(data => {

        this.phonelinesRaw = [];
        console.log(data);
        for (let phoneline of data.body) {
          this.phonelinesRaw.push(new Phoneline(
            phoneline.phoneNumber,
            phoneline.deviceResponseDto.deviceId
          ));
        }
        this.phonelinesSubject.next(this.phonelinesRaw);
      });
  }

  getAllPhonelinesOfCust(custId: number) {
    const headers = this.authService.getHeader();
    this.http.get<any>(`${this.localHost}/${custId}/lines`,  { headers, observe: 'response' })
      .subscribe(data => {

        this.devicesOfCustRaw = [];
        for (let phoneline of data.body) {
          this.devicesOfCustRaw.push(new Device(
            phoneline.deviceResponseDto.deviceId,
            phoneline.deviceResponseDto.name,
            phoneline.deviceResponseDto.brand,
            phoneline.deviceResponseDto.price
          ));
        }
        this.devicesOfCustSubject.next(this.devicesOfCustRaw);
      });
  }

  getPhonelineById(custId: number, phoneNumber: string) {
    this.http.get<any>(`${this.localHost}/${custId}/lines/${phoneNumber}`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      });
  }

  deleteById(custId: number, phoneNumber: string) {
    const headers = this.authService.getHeader();
    this.http.delete<any>(`${this.localHost}/${custId}/lines/${phoneNumber}`, { headers, observe: 'response' })
      .subscribe(data => {
        console.log(data);
      });
  }


  addPhoneline(custId: number, deviceId: number) {
    this.createPhoneline(custId, this.newPhonelineDialogue(deviceId));
  }

  newPhonelineDialogue(deviceId: number): Phoneline {
    let last4 = Number.parseInt(this.phonelinesRaw.at(-1)!.phoneNumber.slice(8)) + 1;
    let number = "404-433-" + last4;
    // This is where I'd assign a device, but we don't have a device purchase dialogue.
    let phone: Phoneline = new Phoneline(number, deviceId);
    return phone;
  }

}
