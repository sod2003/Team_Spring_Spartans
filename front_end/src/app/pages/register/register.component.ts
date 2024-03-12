import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment.production';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
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
      Validators.required
    ])],
    email: ['', Validators.compose([
      Validators.required,
      Validators.email
    ])],
    address: ['', Validators.compose([
      Validators.required
    ])],
    username: ['', Validators.compose([
      Validators.required
    ])],
    password: ['', Validators.compose([
      Validators.required
    ])]
  });

  register() {
    this.httpClient.post<any>(this.registerUrl, this.registerForm.value, { observe: 'response' })
      .subscribe({
        next: () => {
        },
        error: err => {
          console.log(err);
          this.router.navigate(["/login"]);
        },
        complete: () => {
          console.log('Registered Successfully!');
          this.router.navigate(["/login"]);
        }
      });
  }


}
