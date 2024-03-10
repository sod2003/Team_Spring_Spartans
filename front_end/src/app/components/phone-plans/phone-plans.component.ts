import { Component, OnInit } from '@angular/core';
import { PhonePlan } from '../../models/phone-plan';
import { PhonePlanService } from '../../services/phone-plan.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-phone-plans',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './phone-plans.component.html',
  styleUrl: './phone-plans.component.css'
})
export class PhonePlansComponent implements OnInit{

  phonePlans: PhonePlan[] = [];

  constructor(private phonePlanService: PhonePlanService) {}

  ngOnInit(): void {
      this.phonePlanService.phonePlansObservable.subscribe((data) => {
        this.phonePlans = data;
      });
  }

}
