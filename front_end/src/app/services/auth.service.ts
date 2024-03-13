import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.production';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import * as CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loginUrl = environment.loginUrl;
  secretKey = environment.secretKey;

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
    let username = '';
    let password = '';
  
    const encryptedUsername = localStorage.getItem("username");
    if (encryptedUsername) {
      username = CryptoJS.AES.decrypt(encryptedUsername, this.secretKey).toString(CryptoJS.enc.Utf8);
    }
  
    const encryptedPassword = localStorage.getItem("password");
    if (encryptedPassword) {
      password = CryptoJS.AES.decrypt(encryptedPassword, this.secretKey).toString(CryptoJS.enc.Utf8);
    }
  
    const authString = username + ':' + password;
    const encodedAuthString = btoa(authString);
  
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + encodedAuthString
    });
  
    return headers;
  }
  

  login(loginForm: any) {
    if (loginForm) {
      this.httpClient.post<any>(this.loginUrl, loginForm.value, { observe: 'response' })
        .subscribe(
          data => {
            localStorage.setItem("username", CryptoJS.AES.encrypt(loginForm.value.username, this.secretKey).toString());
            localStorage.setItem("password", CryptoJS.AES.encrypt(loginForm.value.password, this.secretKey).toString());
            this.router.navigate(["customers/" + data.body.custId]);
          });
    } else {
      console.error("Username is null or empty.");
    }
  }

  logout() {
    console.clear;
    localStorage.removeItem('username');
    localStorage.removeItem('password');
  }


}
