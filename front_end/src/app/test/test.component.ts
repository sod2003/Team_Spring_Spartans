import { Component } from '@angular/core';
import { Customer } from '../models/customer';
import { CustomerComponent } from '../components/customer/customer.component';
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
    this.customerService.getAllActiveCustomers();
    this.customerService.allCustomers.subscribe(data => {
      this.customers = data;
    });
    this.customerService.getCustomerById('1');
    this.customerService.createCustomer(new Customer("0", "Johnny Ringo", "Tombstone", "seenAghost@duelist.com"));
    this.customerService.updateCustomer(new Customer("1", "Seam", "123 Money Lane", "sean@skillstorm.com"));
    this.customerService.deleteCustomer(new Customer("1", "Seam", "123 Money Lane", "sean@skillstorm.com"));
  }

}
