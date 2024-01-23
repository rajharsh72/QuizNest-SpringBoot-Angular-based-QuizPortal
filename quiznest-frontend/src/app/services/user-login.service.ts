import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  constructor(
    private _httpClient: HttpClient
  ) { }

  API_URL = 'http://localhost:9090/api/user'

  userLogin(data:any){
    return this._httpClient.get(this.API_URL + '/login', data);
  }
}
