import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { BookticketComponent } from './bookticket/bookticket.component';
import { FormsModule } from '@angular/forms';
import { ShowticketsComponent } from './showtickets/showtickets.component';
import { ShowdetailsComponent } from './showdetails/showdetails.component';
import { LandingComponent } from './landing/landing.component';
import { VerifyComponent } from './verify/verify.component';
import { UpdateComponent } from './update/update.component';
import { DeleteComponent } from './delete/delete.component';
import { MovielistComponent } from './movielist/movielist.component';
import { SerachComponent } from './serach/serach.component';
import { AddmovieComponent } from './addmovie/addmovie.component';
import { AdminlandingComponent } from './adminlanding/adminlanding.component';


@NgModule({
  declarations: [BookticketComponent, ShowticketsComponent, ShowdetailsComponent, LandingComponent, VerifyComponent, UpdateComponent, DeleteComponent, MovielistComponent, SerachComponent, AddmovieComponent, AdminlandingComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule,
  ]
})
export class UserModule { }
