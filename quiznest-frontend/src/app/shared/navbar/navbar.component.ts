import { Component } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { UserLoginComponent } from 'src/app/components/user-login/user-login.component';
import { UserRegisterationComponent } from 'src/app/components/user-registeration/user-registeration.component';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(
    private _dialog: MatDialog
  ){}

  openLoginForm(){
    this._dialog.open(UserLoginComponent)
  }

  openRegisterationForm(){
    this._dialog.open(UserRegisterationComponent)
  }
}