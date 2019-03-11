import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrganizationServiceService {

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Array<Organization>> {
    return this.http.get<Array<Organization>>('/assets/issues.json');
  }

  public get(id: number): Observable<any> {
    return this.http.get('/assets/issue.json');
 }
}
