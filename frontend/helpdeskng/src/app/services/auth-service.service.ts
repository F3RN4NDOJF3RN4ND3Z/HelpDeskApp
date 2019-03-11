import { Injectable } from '@angular/core';
import { User } from '../domain/user';
import { HttpClient } from '@angular/common/http';
import { CanActivate, Router, ActivatedRouteSnapshot } from '@angular/router';

const DUMMY: User = {
  id: 1,
  name: 'bob',
  organization_id: 1,
  privileges:User.roles.ADMIN
}


@Injectable({
  providedIn: 'root'
})
export class AuthServiceService implements CanActivate {


  constructor(private http: HttpClient,private router: Router) { }

  public get currentUser() {
    return DUMMY;
  }

  authenticated:boolean;

  canActivate(route: ActivatedRouteSnapshot): boolean {
    //logic to check if user is logged In
    if (this.authenticated) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }

}
