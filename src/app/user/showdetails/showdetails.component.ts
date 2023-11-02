import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import { TicketBookingDTO } from 'src/app/models/ticket-booking-dto';

declare var $: any;
declare var jQuery: any;


@Component({
  selector: 'app-showdetails',
  templateUrl: './showdetails.component.html',
  styleUrls: ['./showdetails.component.css']
})

export class ShowdetailsComponent implements OnInit {
  dataTable: any; 
  bookingData: TicketBookingDTO = new TicketBookingDTO();

  constructor(private router: Router,private http: HttpClient) { }


  ngOnInit(): void {
    this.dataTable = $('#myTable').DataTable({
      "bProcessing": true,
      "bDeferRender": true,
      "ordering": false,
      
      ajax: {
        url: 'http://localhost:8099/booking/get',
        dataSrc: 'bookings'
      },
      columns: [
        { data: 'totalAmount',  "bSortable": false},
        { data: 'customerPhone', "bSortable": false },
        { data: 'numberOfTickets', "bSortable": false },
        { data: 'customerEmail', "bSortable": false },
        { data: 'paymentMethod', "bSortable": false },
        { data: 'movieId', "bSortable": false },
        { data: 'showtimeId', "bSortable": false },
        { data: 'bookingDate', "bSortable": false },
        { data: 'customerName', "bSortable": false },
        { 
          data: 'status', "bSortable": false,
          "mRender": function (data) {
            if (data == 'PENDING') {
              return '<span class="btn btn-primary">Pending</span>';
            } else if (data == 'DELETE') {
              return '<span class="badge badge-warning">Approval</span>';
            } else if (data == 'VERIFIED') {
              return '<span class="btn btn-success">Approved</span>';
            } else if (data == 'REJECT') {
              return '<span class="btn btn-danger">Rejected</span>';
            } else if (data == 'DELETED') {
              return '<span class="badge badge-danger">Deleted</span>';
            } else if (data == 'RECEIVED') {
              return '<span class="badge badge-success">Processed</span>';
            }
            return data;
            
          }
        }]
    });

    $('#myTable tbody').on('click', 'tr', function () 
    {
      $(this).toggleClass('selected');
    });

  }

  navigateToverifyPage() 
  {
    const selectedRows = $('#myTable.selected');
    // if (selectedRows.length > 0) {
      const customerName = this.dataTable.row('.selected').data().customerName;
      const customerPhone = this.dataTable.row('.selected').data().customerPhone;
      console.log(customerName,customerPhone);
      this.router.navigate(['./bookticket/verify',customerName,customerPhone]);
    // }
  }
  navigateToUpdatePage()
  {
    const selectedRows = $('#myTable.selected');
    // if (selectedRows.length > 0) {
      const customerName = this.dataTable.row('.selected').data().customerName;
      const customerPhone = this.dataTable.row('.selected').data().customerPhone;
      console.log(customerName,customerPhone);
      this.router.navigate(['./bookticket/update',customerName,customerPhone]);
    // }
  }

  navigateTodeletePage()
  {
    const selectedRows = $('#myTable.selected');
    // if (selectedRows.length > 0) {
      const customerName = this.dataTable.row('.selected').data().customerName;
      const customerPhone = this.dataTable.row('.selected').data().customerPhone;
      console.log(customerName,customerPhone);
      this.router.navigate(['./bookticket/delete',customerName,customerPhone]);
    // }
  }
  navigateTosearchPage()
  {
    this.router.navigate(['./bookticket/search']);
  }

clear()
{

}




}
