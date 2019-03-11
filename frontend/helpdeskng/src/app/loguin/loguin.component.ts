import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../domain/user';

@Component({
  selector: 'app-loguin',
  templateUrl: './loguin.component.html',
  styleUrls: ['./loguin.component.css']
})
export class LoguinComponent implements OnInit {


  name:String;
  
  constructor() { }

  ngOnInit() {
  }

  onSave(userForm: NgForm) {
    console.log(userForm.valid);
    //let newUser = new User(this.name, this.user.phone);
    //this.users.push(newUser);    
 }

}
