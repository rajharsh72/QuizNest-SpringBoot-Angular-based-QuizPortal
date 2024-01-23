import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

  registerationForm = new FormGroup({
    'email': new FormControl('', [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]),
    'firstName': new FormControl('',[Validators.required, Validators.pattern('[a-zA-Z ]*')]),
    'lastName':new FormControl('', Validators.pattern('[a-zA-Z ]*')),
    'phoneNo': new FormControl('', [Validators.required, Validators.pattern('[0-9]{10}')]),
    'gender': new FormControl('', Validators.required),
    'password':new FormControl('', Validators.required)
  })


  registerUser(){
    if(this.registerationForm.valid){
      this._registerationService.registerUser(this.registerationForm.value).subscribe((res)=>{
        console.log("user registered successfully")
        Swal.fire({
          title: "Kudos" + ' '+ this.registerationForm.value['firstName'],
          text: "Registeration Successfull",
          icon: "success"
        });
        this._dialogRef.close();
      },
      (err)=>{
        this._snackBar.open("something went wrong... !!!", 'OK',{
          duration: 5000
        });
      });
    }
    else{
      this._snackBar.open("Invalid or missing details. Kindly check again",'OK',{
        duration:5000
      });
    }
      
  }
}
