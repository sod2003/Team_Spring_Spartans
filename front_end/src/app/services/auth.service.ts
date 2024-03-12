import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.production';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserLogin } from '../models/user-login';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loginUrl = environment.loginUrl;
  userLogin = new UserLogin("", "");

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  // getHeader(): any {
  //   return {
  //     "Content-Type": "application/json",
  //     "Authorization": "Basic " + btoa(`${this.userLogin.getUsername}:${this.userLogin.getPassword}`)  
  //   };
  // }

  getHeader(): HttpHeaders {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa((this.userLogin.getUsername() || '') + ':' + (this.userLogin.getPassword() || ''))
    });
    return headers;
  }

  login(loginForm: any) {
    if (loginForm) {
      this.httpClient.post<any>(this.loginUrl, loginForm.value, { observe: 'response' })
        .subscribe(
          data => {
            this.userLogin.setUsername(loginForm.value.username);
            this.userLogin.setPassword(loginForm.value.password);
            this.router.navigate(["customers/" + data.body.custId]);
          });
    } else {
      console.error("Username is null or empty.");
    }
  }


}
