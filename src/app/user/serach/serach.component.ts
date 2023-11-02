import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketBookingDTO } from 'src/app/models/ticket-booking-dto';

@Component({
  selector: 'app-serach',
  templateUrl: './serach.component.html',
  styleUrls: ['./serach.component.css']
})
export class SerachComponent implements OnInit {

  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit(): void 
  {

  }

  bookingData: TicketBookingDTO = new TicketBookingDTO();

  datasend = {
    movieId: null,
    showtimeId: null,
    numberOfTickets: null,
    status: null,
    customerPhone: null,
    customerName: null,
    customerEmail: null,
    paymentMethod: null,
    bookingDate: null,
    totalAmount: null,

  };

  serach() {
    const url = 'http://localhost:8099/booking/search/dto';
  
    const body = {
      movieId: this.datasend.movieId,
      showtimeId: this.datasend.showtimeId,
      numberOfTickets: this.datasend.numberOfTickets,
      status: this.datasend.status,
      customerPhone: this.datasend.customerPhone,
      customerName: this.datasend.customerName,
      customerEmail: this.datasend.customerEmail,
      paymentMethod: this.datasend.paymentMethod,
      bookingDate: this.datasend.bookingDate,
      totalAmount: this.datasend.totalAmount
    };
  
    this.http.post(url, body).subscribe(
      (response: any) => {
        this.bookingData = response.bookings;
        console.log('Search Results:', response);
        // Handle the response as needed
      },
      (error) => {
        console.error('Search Error:', error);
        // Handle the error as needed
      }
    );
  }
  navigateToUpdatePage()
  {

  }
  navigateToDataPage()
  {
    this.router.navigate(['./bookticket/show',]);
  }

}
