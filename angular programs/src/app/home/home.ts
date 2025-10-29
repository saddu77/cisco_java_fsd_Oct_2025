import { CommonModule, NgSwitch,NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Parent } from '../parent/parent';

@Component({
  selector: 'app-home',
  imports: [CommonModule,Parent,RouterModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
    name = "Alex";
    age = 21;
    isLoggedIn = true;
    names = ["Alex","Bob","Clare","Daniel","Emily"];
    status = "pending";

    
    today = new Date();
    amount = 1234.56;
    score = 0.75;
    students_ = ['Alice', 'Bob', 'Charlie', 'David'];
    user = { name: 'Kiran', age: 22, city: 'Hyderabad' };
  

    changeStatus(newStatus:string){
      this.status = newStatus;
    }
} 
