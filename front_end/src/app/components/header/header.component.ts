import { Component } from '@angular/core';
import { Customer } from '../../models/customer';
import { CustomerService } from '../../services/customer.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  customer: Customer = new Customer(0, "", "", "");

  constructor(
    private customerService: CustomerService
  ) { }

  ngOnInit(): void {
    this.customerService.customerObservable.subscribe((data) => {
      this.customer = data;
    });
  }

}
