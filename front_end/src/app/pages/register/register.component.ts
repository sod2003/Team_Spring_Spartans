import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment.production';
import { CryptoService } from '../../services/crypto.service';
import { UserRegister } from '../../models/user-register';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {

  baseUrl = "http://localhost:8080";
  url = "http://localhost:8080/register";
  encodingKey = environment.encodingKey;
  private userRegister = new UserRegister("", "", "", "", "");

  constructor(
    private formBuilder: FormBuilder,
    private cryptoService: CryptoService,
    private httpClient: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void {

    let encrypted = this.cryptoService.encrypt(this.registerForm.get("password")?.value!, this.encodingKey);
    let decrypted = this.cryptoService.decrypt(encrypted, this.encodingKey);

    console.log('Encrypted :' + encrypted);
    console.log('Decrypted :' + decrypted);

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
    this.httpClient.post<any>(this.url, userRegister, { observe: 'response' })
      .subscribe({
        next: data => {
          this.userRegister = new UserRegister(
            this.registerForm.get("fullName")?.value!,
            this.registerForm.get("email")?.value!,
            this.registerForm.get("address")?.value!,
            this.registerForm.get("username")?.value!,
            this.registerForm.get("password")?.value!
            );
          this.router.navigate([this.baseUrl + data.body.custId]);
        },
        error: err => console.log(err),
        complete: () => console.log('Registered Successfully!')
      });
  }


}
