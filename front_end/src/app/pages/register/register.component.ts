import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment.production';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {

  registerUrl = environment.registerUrl;

  constructor(
    private formBuilder: FormBuilder,
    private httpClient: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {

  }

  registerForm: FormGroup = this.formBuilder.group({
    fullName: ['', Validators.compose([
      Validators.required,
      Validators.minLength(5)
    ])],
    email: ['', Validators.compose([
      Validators.required,
      Validators.minLength(5),
      Validators.email
    ])],
    address: ['', Validators.compose([
      Validators.required,
      Validators.minLength(5)
    ])],
    username: ['', Validators.compose([
      Validators.required,
      Validators.minLength(5),
      Validators.maxLength(20)
    ])],
    password: ['', Validators.compose([
      Validators.required,
      Validators.minLength(5),
      Validators.maxLength(20)
    ])]
  });

  get fullName() {
    return this.registerForm.get("fullName");
  }

  get email() {
    return this.registerForm.get("email");
  }
  
  get address() {
    return this.registerForm.get("address");
  }

  get username() {
    return this.registerForm.get("username");
  }

  get password() {
    return this.registerForm.get("password");
  }

  register() {
    this.httpClient.post<any>(this.registerUrl, this.registerForm.value, { observe: 'response' })
      .subscribe({
        error: (response) => {
          if (response.status === 201) {
            this.router.navigate(["/login"]);
          }
          if (response.status === 418) {
            this.registerForm.get('username')?.setErrors({ taken: true });
          }
        },
        complete: () => {
          console.log('Registration request completed.');
        }
      });
      
  }


}
