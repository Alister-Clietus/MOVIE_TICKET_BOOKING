import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TicketbookingComponent } from './ticketbooking.component';
import { ShowdetailsComponent } from './showdetails/showdetails.component';


const routes: Routes = [
  { path: '', component: TicketbookingComponent },
  { path: 'details', component: ShowdetailsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TicketbookingRoutingModule { }
