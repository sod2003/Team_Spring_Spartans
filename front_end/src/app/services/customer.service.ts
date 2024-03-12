import { Injectable } from '@angular/core';
import { Customer } from '../models/customer';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  localHost: string = 'http://localhost:8080/customers';

  customerRaw: Customer = new Customer(0, "", "", "");
  customerSubject = new BehaviorSubject<Customer>(new Customer(0, "", "", ""));
  customerObservable = this.customerSubject.asObservable();

  customersRaw: Customer[] = [];
  customersSubject = new BehaviorSubject<Customer[]>([]);
  allCustomers = this.customersSubject.asObservable();

  constructor(private http: HttpClient) {}

  getAllActiveCustomers() {
    this.http.get<any>(this.localHost, { observe: 'response' })
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

  getCustomerById(custId: number) {
    this.http.get<any>(`${this.localHost}/${custId}`, { observe: 'response' })
      .subscribe(data => {
        let details = data.body;
        this.customerRaw = new Customer(details.custId, details.name, details.address, details.email);
        this.customerSubject.next(this.customerRaw);
      })
  }

  createCustomer(customer: Customer) {
    this.http.post<any>(this.localHost, customer, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      });
  }

  updateCustomer(customer: Customer) {
    this.http.put<any>(`${this.localHost}/${customer.custId}`, customer, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      });
  }

  deleteCustomer(customer: Customer) {
    this.http.delete<any>(`${this.localHost}/${customer.custId}`, { observe: 'response' })
      .subscribe(data => {
        console.log(data);
      });
  }
}