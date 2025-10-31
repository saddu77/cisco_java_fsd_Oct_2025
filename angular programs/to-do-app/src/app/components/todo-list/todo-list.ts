import { CommonModule, NgClass } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Todo } from '../../models/todo.model';
import { TodoService } from '../../services/todo';
import { AddTodoComponent } from '../add-todo/add-todo';


@Component({
  selector: 'app-todo-list',
  imports: [NgClass,CommonModule,AddTodoComponent,NgClass],
  templateUrl: './todo-list.html',
  styleUrl: './todo-list.css',
})



export class TodoListComponent implements OnInit {
  todos: Todo[] = [];

  constructor(private todoService: TodoService) {}

  ngOnInit() {
    this.loadTodos();
  }

  loadTodos() {
    this.todoService.getTodos().subscribe((data) => (this.todos = data));
  }

  addTodo(todo: Todo) {
    this.todoService.addTodo(todo).subscribe((newTodo) => this.todos.push(newTodo));
  }

  deleteTodo(id?: number) {
    if (!id) return;
    this.todoService.deleteTodo(id).subscribe(() => {
      this.todos = this.todos.filter((t) => t.id !== id);
    });
  }

  toggleTodo(todo: Todo) {
    this.todoService.toggleCompleted(todo).subscribe((updatedTodo) => {
      //const index = this.todos.findIndex((t) => t.id === updatedTodo.id);
      const index = this.todos.map(t => t.id).indexOf(updatedTodo.id);
      if (index !== -1) {
        this.todos[index] = updatedTodo;
      }
      this.todos[index] = updatedTodo;
    });
  }
}

