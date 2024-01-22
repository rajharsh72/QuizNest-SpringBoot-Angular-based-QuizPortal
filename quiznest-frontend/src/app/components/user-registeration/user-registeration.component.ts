import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserRegisterationServiceService } from 'src/app/services/user-registeration-service.service';
import Swal from 'sweetalert2';

interface Gender{
  value: String;
  label: String;

}

@Component({
  selector: 'app-user-registeration',
  templateUrl: './user-registeration.component.html',
  styleUrls: ['./user-registeration.component.css']
})

export class UserRegisterationComponent {

  constructor(
    private _registerationService:UserRegisterationServiceService,
    private _snackBar: MatSnackBar,
    private _dialogRef: MatDialogRef<UserRegisterationComponent>
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
        Swal.fire({
          title: "Kudos" + ' '+ this.user.firstName,
          text: "Registeration Successfull",
          icon: "success"
        });
        this._dialogRef.close();
      },
      (err)=>{
        this._snackBar.open("something went wrong... !!!", 'OK',{
          duration: 5000
        });
      })
  }
}
