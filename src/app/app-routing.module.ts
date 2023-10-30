import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TicketbookingRoutingModule } from './ticketbooking/ticketbooking-routing.module';



const routes: Routes = 
[
  { path: '', redirectTo: 'landing', pathMatch: 'full' },
  { path: 'landing', loadChildren: () => TicketbookingRoutingModule },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
