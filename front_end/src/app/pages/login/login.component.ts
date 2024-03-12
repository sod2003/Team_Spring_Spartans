import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { environment } from '../../../environments/environment.production';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from '../../models/user-login';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  baseUrl = "http://localhost:8080";
  url = "http://localhost:8080/login";
  encodingKey = environment.encodingKey;
  private userLogin = new UserLogin("", "");

  constructor(
    private formBuilder: FormBuilder,
    private httpClient: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {

  }

  loginForm = this.formBuilder.group({
    username: ['', Validators.compose([
      Validators.required
    ])],
    password: ['', Validators.compose([
      Validators.required
    ])]
  });

  setUserLogin() {
    this.userLogin.setPassword(this.loginForm.get("username")?.value!);
    this.userLogin.setPassword(this.loginForm.get("password")?.value!);
  }

  login(userLogin: UserLogin) {
    this.httpClient.post<any>(this.url, userLogin, { observe: 'response' })
      .subscribe({
        next: data => {
          this.router.navigate([this.baseUrl + data.body.custId]);
        },
        error: err => console.log(err),
        complete: () => console.log('POST request complete!')
      });
  }


}
