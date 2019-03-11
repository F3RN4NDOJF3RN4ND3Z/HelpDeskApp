import { Component, OnInit, Input } from '@angular/core';
import {Comment} from '../domain/comments';
import { Ticket } from '../domain/ticket';
@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.css']
  
})
export class TicketDetailsComponent implements OnInit {

  @Input() ticket_id: Number;
  comentText: String;
  comments: Comment[];
  constructor() { 
    this.comments=[
      {
        comment: "Esto es una comentario",
        added_date: new Date(),
        user_id: 1
      },
      {
        comment: "Esto es una comentario 2",
        added_date: new Date(),
        user_id: 1
      }
    ]
  }

  ngOnInit() {
    
  }

}
