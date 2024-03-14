import { Component, OnInit } from '@angular/core';
import { PhonePlanService } from '../../services/phone-plan.service';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PhonePlan } from '../../models/phone-plan';

@Component({
  selector: 'app-phone-plans-buy',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './phone-plans-buy.component.html',
  styleUrl: './phone-plans-buy.component.css'
})
export class PhonePlansBuyComponent implements OnInit {

  phonePlans: PhonePlan[] = [];

  constructor(
    private phonePlanService: PhonePlanService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
      this.phonePlanService.phonePlansObservable.subscribe((data) => {
        this.phonePlans = data;
      });
  }

  purchasePlan(phonePlanId: number) {
    this.phonePlanService.createPhonePlan(this.activatedRoute.snapshot.params["custId"], phonePlanId);
    location.reload();
  }

  checkAdded(phonePlanId:number): boolean {
    for (let phonePlan of this.phonePlans) {
      if (phonePlan.phonePlanId === phonePlanId) {
        return false;
      }
    }
    return true;
  }


}
