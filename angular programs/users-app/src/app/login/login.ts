import { JsonPipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [RouterModule,FormsModule,JsonPipe],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  user = {
    email: '',
    password: ''
  };

  constructor(private router:Router){}

  onSubmit() {
    console.log('Form Submitted!', this.user);
    // validating user by API Call
    if(this.user.email == "admin@gmail.com" && this.user.password == "admin123"){
      alert("Valid User");
      this.router.navigate(['/home']);
    }else {
      alert("InValid User");
    }
  }

}
