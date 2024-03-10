import { Component, Input } from '@angular/core';
import { Customer } from '../../models/customer';

@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [],
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent {

  @Input() customer: Customer = new Customer(0, "", "", "");

}
