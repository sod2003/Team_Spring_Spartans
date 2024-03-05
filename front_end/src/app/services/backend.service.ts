import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  localHost: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {
    this.getAllCustomers();
  }

  getAllCustomers() {
    this.http.get<any>(this.localHost + "/customers", { observe: 'response' })
    .subscribe(data => {
      // for (let customer of data.body) {
      //   console.log(customer);
      // }
      console.log(data);
    });
  }

  getCustomer(id: string) {
    this.http.get<any>(this.localHost + "/customers/" + id, { observe: 'response'})
    .subscribe(data => {
      console.log(data);
    })
  }

  getDevices() {
    this.http.get<any>(this.localHost + "/devices", { observe: 'response'})
    .subscribe(data => {
      console.log(data);
    })
  }
}
