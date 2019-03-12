import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../domain/user';

@Injectable({
  providedIn: 'root'
})
export class UserServiciceService {

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Array<User>> {

    return this.http.get<Array<User>>('/assets/users.json');
    
  }

  public get(id: number): Observable<User> {
    return this.http.get<User>('/assets/user.json');
  }
  
}
