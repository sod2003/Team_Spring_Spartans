import { Component, OnInit } from '@angular/core';
import { PhonePlan } from '../../models/phone-plan';
import { PhonePlanService } from '../../services/phone-plan.service';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-phone-plans',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './phone-plans.component.html',
  styleUrl: './phone-plans.component.css'
})
export class PhonePlansComponent implements OnInit {

  phonePlans: PhonePlan[] = [];

  constructor(
    private phonePlanService: PhonePlanService,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.phonePlanService.phonePlansObservable.subscribe((data) => {
      this.phonePlans = data;
    });
  }

  removePhonePlan(phonePlan: PhonePlan, index: number) {
    this.phonePlans.splice(index, 1);
    // This will call the endpoint to delete this phone plan from the customer account.
    this.phonePlanService.deleteDevicePhonePlan(this.activatedRoute.snapshot.params["custId"], phonePlan.phonePlanId);
    location.reload();
  }

}
