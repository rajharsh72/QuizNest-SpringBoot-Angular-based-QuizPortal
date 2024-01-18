import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { UserRegisterationComponent } from './components/user-registeration/user-registeration.component';

const routes: Routes = [
  {path: '', component:HomeComponent, pathMatch:'full'},
  {path: 'home', component:HomeComponent, pathMatch: 'full'},
  {path: 'register', component:UserRegisterationComponent, pathMatch:'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
