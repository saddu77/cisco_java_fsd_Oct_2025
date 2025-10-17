import { Routes } from '@angular/router';
import { Home } from './home/home';
import { Login } from './login/login';
import { Sigup } from './sigup/sigup';

export const routes: Routes = [
    {path:'',       component:Login},
    {path:'login',  component:Login},
    {path:'signup', component:Sigup},
    {path:'home',   component:Home}
];
