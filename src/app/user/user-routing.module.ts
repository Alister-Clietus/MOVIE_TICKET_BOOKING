import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookticketComponent } from './bookticket/bookticket.component';
import { ShowdetailsComponent } from './showdetails/showdetails.component';
import { LandingComponent } from './landing/landing.component';
import { VerifyComponent } from './verify/verify.component';
import { UpdateComponent } from './update/update.component';
import { DeleteComponent } from './delete/delete.component';
import { MovielistComponent } from './movielist/movielist.component';
import { SerachComponent } from './serach/serach.component';
import { AddmovieComponent } from './addmovie/addmovie.component';
import { AdminlandingComponent } from './adminlanding/adminlanding.component';


const routes: Routes = [
  {
    path:'landing',component:LandingComponent
  },
  {
    path:'book/:movieid/:showid',component:BookticketComponent
  },
  {
    path:'add',component:AddmovieComponent
  },
  {
    path:'show',component:ShowdetailsComponent
  },
  {
    path:'search',component:SerachComponent
  },
  {
    path:'verify/:customerName/:customerPhone',component:VerifyComponent
  },
  {
    path:'update/:customerName/:customerPhone',component:UpdateComponent
  },
  {
    path:'delete/:customerName/:customerPhone',component:DeleteComponent
  },
  {
    path:'movielist',component:MovielistComponent
  },
  {
    path:'landingadmin',component:AdminlandingComponent
  },
  
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
