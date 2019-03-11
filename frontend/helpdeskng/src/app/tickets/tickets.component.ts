import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Ticket } from '../domain/ticket';

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrls: ['./tickets.component.css']
})
export class TicketsComponent implements OnInit {

  ticket:Ticket;
  constructor() { }

  ngOnInit() {
  }

  onSave(ticketFrom:NgForm){
    
  }
}
