import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TicketbookingRoutingModule } from './ticketbooking-routing.module';
import { TicketbookingComponent } from './ticketbooking.component';
import { ShowdetailsComponent } from './showdetails/showdetails.component';


@NgModule({
  declarations: [TicketbookingComponent, ShowdetailsComponent],
  imports: [
    CommonModule,
    TicketbookingRoutingModule
  ]
})
export class TicketbookingModule { }
