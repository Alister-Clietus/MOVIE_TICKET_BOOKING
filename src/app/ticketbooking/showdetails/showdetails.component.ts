import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

declare var $: any;
declare var jQuery: any;

@Component({
  selector: 'app-showdetails',
  templateUrl: './showdetails.component.html',
  styleUrls: ['./showdetails.component.css']
})
export class ShowdetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $('#myTable').DataTable({
      ajax: {
        url: 'http://localhost:8099/booking/get',
        dataSrc: 'bookings'
      },
      columns: [
        { data: 'totalAmount' },
        { data: 'customerPhone' },
        { data: 'numberOfTickets' },
        { data: 'customerEmail' },
        { data: 'paymentMethod' },
        { data: 'movieId' },
        { data: 'showtimeId' },
        { data: 'bookingDate' },
        { data: 'customerName' },
        { data: 'status' }
      ]
    });
  }
}
