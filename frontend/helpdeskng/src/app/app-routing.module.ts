import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoguinComponent } from './loguin/loguin.component';
import { TicketsComponent } from './tickets/tickets.component';
import { AuthServiceService } from './services/auth-service.service';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/dashboard' },
  { path: 'dashboard', component: DashboardComponent,canActivate: [ AuthServiceService ]  },
  { path: 'login', component: LoguinComponent },
  { path: 'tickets', component: TicketsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
