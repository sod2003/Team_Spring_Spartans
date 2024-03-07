import { Component, OnInit } from '@angular/core';
import { PhonePlanService } from '../../services/phone-plan.service';

@Component({
  selector: 'app-testphone-plan',
  standalone: true,
  imports: [],
  templateUrl: './testphone-plan.component.html',
  styleUrl: './testphone-plan.component.css'
})
export class TestphonePlanComponent implements OnInit {

  constructor(private phonePlanService: PhonePlanService) {}

  ngOnInit(): void {
      this.phonePlanService.createPhonePlan(1, 2);
      this.phonePlanService.getAllPhonePlansByCustId(1);
      this.phonePlanService.getPhonePlanById(1, 1);
      this.phonePlanService.deleteDevicePhonePlan(1, 2);
  }

}
