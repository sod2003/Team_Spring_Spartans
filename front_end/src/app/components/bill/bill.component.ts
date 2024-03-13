import { Component } from '@angular/core';
import { PhonePlan } from '../../models/phone-plan';
import { Device } from '../../models/device';
import { PhonePlanService } from '../../services/phone-plan.service';
import { DeviceService } from '../../services/device.service';
import { CommonModule } from '@angular/common';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../models/customer';
import { PhoneLinesComponent } from '../phone-lines/phone-lines.component';

@Component({
  selector: 'app-bill',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './bill.component.html',
  styleUrl: './bill.component.css'
})
export class BillComponent {

  customer: Customer = new Customer(0, "", "", "");
  phonePlans: PhonePlan[] = [];
  devices: Device[] = [];
  devicesOfCust: Device[] = [];

  constructor(
    private customerService: CustomerService,
    private phonePlanService: PhonePlanService,
    private phoneLinesComponent: PhoneLinesComponent
  ) { }

  ngOnInit(): void {
    this.customerService.customerObservable.subscribe((data) => {
      this.customer = data;
    })
    this.phonePlanService.phonePlansObservable.subscribe((data) => {
      this.phonePlans = data;
    });
    this.phoneLinesComponent.devicesOfCustObservable.subscribe((data) => {
      this.devicesOfCust = data;
    });
  }

  calculateBill(): any {
    let totalPhonePlanCost = 0;
    let totalDevicesCost = 0;
    for (let phonePlan of this.phonePlans) {
      totalPhonePlanCost += phonePlan.cost;
    }
    for (let device of this.devices) {
      totalDevicesCost += device.price;
    }

    return totalPhonePlanCost + totalDevicesCost;
  }

}
