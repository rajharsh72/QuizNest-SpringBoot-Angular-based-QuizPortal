import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserRegisterationServiceService {

  constructor(
    private _httpClient:HttpClient
  ) { }

  API_URL = 'http://localhost:9090/api';


  registerUser(user:any){
    return this._httpClient.post(this.API_URL + '/user/register', user);
  }
}
