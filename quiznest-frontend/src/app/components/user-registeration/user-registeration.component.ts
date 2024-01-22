import { Component } from '@angular/core';
import { isEmpty } from 'rxjs';
import { UserRegisterationServiceService } from 'src/app/services/user-registeration-service.service';
interface Gender{
  value: String;
  labe: String;

}

@Component({
  selector: 'app-user-registeration',
  templateUrl: './user-registeration.component.html',
  styleUrls: ['./user-registeration.component.css']
})

export class UserRegisterationComponent {

  constructor(
    private _registerationService:UserRegisterationServiceService
  ){}

  public user = {
    email:'',
    firstName:'',
    lastName:'',
    phoneNo:'',
    gender:'',
    password:''
  };


  registerUser(){
    console.log(this.user);
      this._registerationService.registerUser(this.user).subscribe((res)=>{
        console.log("user registered successfully")
      },
      (err)=>{
        console.log("something went wrong...", err);
      })
  }
}
