import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment.production';
import { UserRegister } from '../../models/user-register';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {

  registerUrl = environment.registerUrl;
  loginUrl = environment.loginUrl;
  private userRegister = new UserRegister("", "", "", "", "");

  constructor(
    private formBuilder: FormBuilder,
    private httpClient: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  registerForm = this.formBuilder.group({
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

  register(userRegister: UserRegister) {
    this.httpClient.post<any>(this.registerUrl, userRegister, { observe: 'response' })
      .subscribe({
        next: data => {
          this.userRegister = new UserRegister(
            this.registerForm.get("fullName")?.value!,
            this.registerForm.get("email")?.value!,
            this.registerForm.get("address")?.value!,
            this.registerForm.get("username")?.value!,
            this.registerForm.get("password")?.value!
            );
          this.router.navigate([this.loginUrl]);
        },
        error: err => console.log(err),
        complete: () => console.log('Registered Successfully!')
      });
  }


}
