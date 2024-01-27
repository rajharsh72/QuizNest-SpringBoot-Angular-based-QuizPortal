import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  constructor(
    private _httpClient: HttpClient
  ) { }

  API_URL = 'http://localhost:9090/api'

  userAuthentication(data:any): Observable<any>{
    return this._httpClient.post(this.API_URL + '/auth', data);
  }

  setToken(token:string){
    localStorage.setItem('token', token);
    return true;
  }

  getToken():string{
    let token = localStorage.getItem('token')!;
    return token;
  }

  setUser(user: string){
    localStorage.setItem('user', JSON.stringify(user));
  }

  getUser(){
    let user = localStorage.getItem('user');
    if(user!=null){
      return JSON.parse(user);
    }else{
      this.logout();
      return null;
    }
  }

  isLoggedIn(){
    let token = this.getToken();
    if(token == undefined || token == '' || token == null){
      return false;
    } else{
      return true;
    }
  }

  logout(){
    localStorage.removeItem('token');
    return true;
  }
}
