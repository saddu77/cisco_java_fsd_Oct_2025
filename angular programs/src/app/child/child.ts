import { Component,EventEmitter,Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  imports: [],
  templateUrl: './child.html',
  styleUrl: './child.css'
})
export class Child {
  @Input() name!: string;   

  @Output() msgEvent = new EventEmitter<string>();
  sendMessage(){
    this.msgEvent.emit('Hello from Child Component');
  }
}
