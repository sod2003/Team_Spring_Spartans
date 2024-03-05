import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [],
  templateUrl: './test.component.html',
  styleUrl: './test.component.css'
})
export class TestComponent {

  constructor(private backend: BackendService) {
    this.backend.getAllCustomers();
    // this.backend.getCustomer('1');
    this.backend.getDevices();
  }

}
