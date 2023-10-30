import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TicketbookingRoutingModule } from './ticketbooking-routing.module';
import { TicketbookingComponent } from './ticketbooking.component';


@NgModule({
  declarations: [TicketbookingComponent],
  imports: [
    CommonModule,
    TicketbookingRoutingModule
  ]
})
export class TicketbookingModule { }
