import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlanding',
  templateUrl: './adminlanding.component.html',
  styleUrls: ['./adminlanding.component.css']
})
export class AdminlandingComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void 
  {

  }
  datatable()
  {
    this.router.navigate(['./bookticket/show']);
  }
  addmovie()
  {
    this.router.navigate(['./bookticket/add']);
  }

}
