import { Component } from '@angular/core';






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

  hide=true;
}
