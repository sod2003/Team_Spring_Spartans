import { Component } from '@angular/core';
import { Customer } from '../models/customer';
import { CustomerComponent } from '../customer/customer.component';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [CustomerComponent],
  templateUrl: './test.component.html',
  styleUrl: './test.component.css'
})
export class TestComponent {

  // local storage
  customers: Customer[] = [];

  constructor(private customerService: CustomerService) {
    this.customerService.allCustomers.subscribe(data => {
      this.customers = data;
    });
    // this.backend.getCustomer('1');
    // this.backend.getDevices();
  }

}
