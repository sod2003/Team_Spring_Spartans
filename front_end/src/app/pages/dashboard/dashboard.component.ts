import { Component, OnInit } from '@angular/core';
import { BillComponent } from '../../components/bill/bill.component';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from '../../services/customer.service';
import { PhonePlanService } from '../../services/phone-plan.service';
import { Customer } from '../../models/customer';
import { PhonelineService } from '../../services/phoneline.service';
import { PhoneLinesComponent } from '../../components/phone-lines/phone-lines.component';
import { DevicesComponent } from '../../components/devices/devices.component';
import { PhonePlansComponent } from '../../components/phone-plans/phone-plans.component';
import { PhonePlansBuyComponent } from '../../components/phone-plans-buy/phone-plans-buy.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    BillComponent,
    PhoneLinesComponent,
    DevicesComponent,
    PhonePlansComponent,
    PhonePlansBuyComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {

  customer: Customer = new Customer(0, "", "", "");

  constructor(
    private activatedRoute: ActivatedRoute,
    private customerService: CustomerService,
    private phonePlanService: PhonePlanService,
    private phonelineService: PhonelineService
  ) {
  }

  ngOnInit(): void {
    console.log(this.activatedRoute.snapshot.params["custId"])
    this.customerService.getCustomerById(this.activatedRoute.snapshot.params["custId"]);
    this.phonePlanService.getAllPhonePlansByCustId(this.activatedRoute.snapshot.params["custId"]);
    this.phonelineService.getAllPhonelinesOfCust(this.activatedRoute.snapshot.params["custId"]);
    this.phonelineService.getAllPhonelines(this.activatedRoute.snapshot.params["custId"]);

    this.customerService.customerObservable.subscribe((data) => {
      this.customer = data;
      console.log(this.customer);
    })
  }

}
