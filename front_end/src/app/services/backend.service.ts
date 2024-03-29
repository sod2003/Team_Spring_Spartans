import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../models/customer';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  localHost: string = 'http://localhost:8080';
  
  customersRaw: Customer[] = [];
  customersSubject = new BehaviorSubject<Customer[]>([]);
  allCustomers = this.customersSubject.asObservable();

  constructor(private http: HttpClient) {
    this.getAllCustomers();
  }

  getAllCustomers() {
    this.http.get<any>(this.localHost + "/customers", { observe: 'response' })
    .subscribe(data => {

      this.customersRaw = [];

      for (let customer of data.body) {
        this.customersRaw.push(new Customer(
          customer.custId,
          customer.name,
          customer.address,
          customer.email
        ));
      }
      this.customersSubject.next(this.customersRaw);
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
