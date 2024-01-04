import { Routes } from '@angular/router';
import { UserRegisterationComponent } from './components/user-registeration/user-registeration.component';

export const routes: Routes = [
    {path:'register', component: UserRegisterationComponent, pathMatch:'full'},
];
