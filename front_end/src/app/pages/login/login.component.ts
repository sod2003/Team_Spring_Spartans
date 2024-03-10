import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private formBuilder: FormBuilder) { }

  getFormGroup = this.formBuilder.group({
    username: ['', Validators.compose([
      Validators.required
    ])],
    password: ['', Validators.compose([
      Validators.required
    ])]
  });

}
