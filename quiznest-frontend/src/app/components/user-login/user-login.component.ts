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
      this._loginService.userAuthentication(this.loginForm.value).subscribe((res)=>{
        console.log("Success!!");
        console.log(res.token);
        
        //set jwt token on login token
        this._loginService.setToken(res.token);

        this._loginService.getCurrentUser().subscribe((user:any)=>{
          this._loginService.setUser(user);
          console.log(user);
        })

        
      },
      (err)=>{
        console.log("Error!!");
        console.log(err);
      });
    }
    else{

    }
  }

}
