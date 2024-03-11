import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CryptoService } from '../../services/crypto.service';
import { environment } from '../../../environments/environment.production';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from '../../models/user-login';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  url = "http://localhost:8080/login";
  encodingKey = environment.encodingKey;
  private userLogin = new UserLogin("", "");

  constructor(
    private formBuilder: FormBuilder,
    private cryptoService: CryptoService,
    private httpClient: HttpClient
  ) { }

  ngOnInit(): void {

    let encrypted = this.cryptoService.encrypt(this.loginForm.get("password")?.value!, this.encodingKey);
    let decrypted = this.cryptoService.decrypt(encrypted, this.encodingKey);

    console.log('Encrypted :' + encrypted);
    console.log('Decrypted :' + decrypted);

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
      .subscribe(data => {
        console.log(data);
      });
  }

}
