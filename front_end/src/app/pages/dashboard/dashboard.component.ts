import { Component } from '@angular/core';
import { BillComponent } from '../../components/bill/bill.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [BillComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

}
