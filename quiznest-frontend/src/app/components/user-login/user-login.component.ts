import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserLoginService } from 'src/app/services/user-login.service';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {

  constructor(
    private _loginService:UserLoginService
  ){}

  loginForm = new FormGroup({
    'email':new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
    'password': new FormControl('', Validators.required)
  })

  userLogin(){
    if(this.loginForm.valid){
      this._loginService.userLogin(this.loginForm.value).subscribe((res)=>{

      },
      (err)=>{
      });
    }
    else{

    }
  }

}
