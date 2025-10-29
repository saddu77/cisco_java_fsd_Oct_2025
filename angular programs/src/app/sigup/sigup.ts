import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { User } from '../user';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-sigup',
  imports: [RouterModule,CommonModule,ReactiveFormsModule],
  templateUrl: './sigup.html',
  styleUrl: './sigup.css'
})
export class Sigup {
  signupForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private userService: User) {
    this.signupForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }

  onSubmit(): void {
    if (this.signupForm.valid) {
      this.userService.signup(this.signupForm.value).subscribe({
        next: (response) => {
          this.successMessage = 'Signup successful!';
          this.errorMessage = '';
          console.log('Response:', response);
          this.signupForm.reset();
        },
        error: (err) => {
          this.errorMessage = 'Signup failed. Please try again.';
          this.successMessage = '';
          console.error(err);
        },
      });
    }
  }
}
