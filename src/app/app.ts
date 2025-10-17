import { CommonModule } from '@angular/common';
import { Component, NgModule, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Home } from './home/home';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,Home,CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  // protected readonly title = signal('hello-app');
  title = "helloApp";
  name = "Alex";
  age = 21;
  

}
