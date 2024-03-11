import { Injectable } from '@angular/core';
import * as CryptoJS from 'crypto-js';

@Injectable({
  providedIn: 'root'
})
export class CryptoService {

  constructor() { }

  encrypt(value: any, key: any) {
    let encrypted = CryptoJS.AES.encrypt(value, key).toString();
    return encrypted
  }

  decrypt(value: any, key: any) {
    let decrypted = CryptoJS.AES.decrypt(value, key)
    return decrypted.toString(CryptoJS.enc.Utf8);
  }

}