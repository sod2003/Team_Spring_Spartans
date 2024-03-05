import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  constructor(private http: HttpClient) {
    this.getAllCustomers();
  }

  getAllCustomers() {
    this.http.get<any>("http://localhost:8080/customers", { observe: 'response' })
    .subscribe(data => {
      // for (let customer of data.body) {
      //   console.log(customer);
      // }
      console.log(data);
    });
  }
}
