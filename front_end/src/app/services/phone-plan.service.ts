import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PhonePlanService {

  localHost: string = 'http://localhost:8080/customers';

  constructor(private http: HttpClient) { }

  createPhonePlan(custId: number, phonePlanId: number) {
    this.http.post<any>(`${this.localHost}/${custId}/phone_plans/${phonePlanId}`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

  getAllPhonePlansByCustId(custId: number) {
    this.http.get<any>(`${this.localHost}/${custId}/phone_plans`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

  getPhonePlanById(custId: number, phonePlanId: number) {
    this.http.get<any>(`${this.localHost}/${custId}/phone_plans/${phonePlanId}`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

  /*
  * The update method is obsolete because the phone plans are produced by Spartan Wireless,
  * and we are not providing custom phone plans at this moment in time.
  * The only updates made can be either creating or deleting a plan. 
  updateDevice(deviceId: number, device: Device) {
    device.setDeviceId(deviceId);
    this.http.put<any>(`${this.localHost}/${custId}/phone_plans/${phonePlanId}`, device, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }
  */

  deleteDevicePhonePlan(custId: number, phonePlanId: number) {
    this.http.delete<any>(`${this.localHost}/${custId}/phone_plans/${phonePlanId}`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      })
  }

}
