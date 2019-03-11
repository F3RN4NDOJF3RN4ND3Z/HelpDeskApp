import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from '../domain/ticket';

@Injectable({
  providedIn: 'root'
})
export class TicketServiceService {

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Array<Ticket>> {
    return this.http.get<Array<Ticket>>('/assets/tickets.json');
  }

  public get(id: number): Observable<any> {
    return this.http.get('/assets/issue.json');
 }
}
