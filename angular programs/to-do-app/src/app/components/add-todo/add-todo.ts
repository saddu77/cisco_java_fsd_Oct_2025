import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Todo } from '../../models/todo.model';

@Component({
  selector: 'app-add-todo',
  imports :[CommonModule,ReactiveFormsModule,FormsModule],
  templateUrl: './add-todo.html',
  styleUrls: ['./add-todo.css']
})
export class AddTodoComponent {
  @Output() addTodoEvent = new EventEmitter<Todo>();
  title: string = '';

  addTodo() {
    if (!this.title.trim()) return;
    const newTodo: Todo = { title: this.title, completed: false };
    this.addTodoEvent.emit(newTodo);
    this.title = '';
  }
}

