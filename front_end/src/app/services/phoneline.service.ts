import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Phoneline } from '../models/phoneline';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';

@Injectable({
  providedIn: 'root'
})
export class PhonelineService {

  localHost: string = 'http://localhost:8080/customers';

  phonelinesRaw: Phoneline[] = [];
  phonelinesSubject = new BehaviorSubject<Phoneline[]>([]);
  allPhonelines = this.phonelinesSubject.asObservable();

  constructor(private http: HttpClient) {}

  getAllPhonelines(custId: string) {
    this.http.get<any>(`${this.localHost}/${custId}/lines`, { observe: 'response' })
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

  createPhoneline(custId: string, phoneline: Phoneline) {
    this.http.post<any>(`${this.localHost}/${custId}/lines`, phoneline, { observe: 'response' })
    .subscribe(data => {
      console.log(data);
    });
  }
  
  getPhonelineById(custId: string, phoneNumber: string) {
    this.http.get<any>(`${this.localHost}/${custId}/lines/${phoneNumber}`, { observe: 'response' })
    .subscribe(data => {
      console.log(data);
    });
  }

  deleteById(custId: string, phoneNumber: string) {
    this.http.delete<any>(`${this.localHost}/${custId}/lines/${phoneNumber}`, { observe: 'response' })
    .subscribe(data => {
      console.log(data);
    });
  }
}
