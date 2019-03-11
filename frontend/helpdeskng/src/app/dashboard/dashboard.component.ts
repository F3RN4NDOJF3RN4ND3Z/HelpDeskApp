import { Component, OnInit } from '@angular/core';
import {Ticket} from '../domain/ticket';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { TicketServiceService } from '../services/ticket-service.service';
import { UserServiciceService } from '../services/user-servicice.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  //tickets$: Observable <Array<Ticket>>;
  tickets : any[];
  openedTickets: number;
  closedTicket: number;
  isAdmin: boolean;
  
  constructor(private router: Router,
    private ticketService: TicketServiceService,
    ) { 

      //this.tickets$ = this.ticketService.getAll();
      this.tickets=[
        {
          id:1,
          description:"Esto es un ticket de prueba",
          createdby_id: 1,
          closed_date: null,
          created_date: new Date(2019,3,11),
          organization_id: 1,
          status:Ticket.status.OPEN
        },
        {
          id:2,
          description:"Esto es un ticket de prueba 2",
          createdby_id: 1,
          closed_date: null,
          created_date: new Date(2019,3,11),
          organization_id: 1,
          status:Ticket.status.OPEN
        },
        {
          id:3,
          description:"Esto es un ticket de prueba 3",
          createdby_id: 1,
          closed_date: new Date(2019,3,11),
          created_date: new Date(2019,2,11),
          organization_id: 1,
          status:Ticket.status.CLOSED
        }
      ];
    
    this.openedTickets=this.getOpenedTicket();
    this.closedTicket=this.getClosedTickets();
  }

  openTicket(ticket:Ticket){
    this.router.navigate(['ticket',ticket.id]);
  }


  getOpenedTicket(){
    return this.tickets.filter(ticket=>ticket.status==Ticket.status.OPEN).length;
  }

  getClosedTickets(){
    return this.tickets.filter(ticket=>ticket.status==Ticket.status.CLOSED).length;
  }

  ngOnInit() {
  }

}
