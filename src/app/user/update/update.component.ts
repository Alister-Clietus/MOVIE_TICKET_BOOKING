import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketBookingDTO } from 'src/app/models/ticket-booking-dto';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  bookingData: TicketBookingDTO = new TicketBookingDTO();

  private baseUrl = 'http://localhost:8099/booking';
  customerName: string;
  customerPhone: string;
  successMessage: any;
  errorMessage: string;
  constructor(private route: ActivatedRoute,private http: HttpClient,private router: Router) {
    this.route.params.subscribe(params => {
    this.customerName = params['customerName'];
    this.customerPhone = params['customerPhone']; 
      
    });


   }

  ngOnInit(): void 
  {
    this.getBookingDetails();
  }

  clear()
  {
    this.router.navigate(['./bookticket/show']);
  }

  backToUser()
  {
    this.router.navigate(['./bookticket/show']);
  }

  update() {
    const url = 'http://localhost:8099/booking/update';
  
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
  
    this.http.put(url, this.bookingData, { headers }).subscribe(
      (response: any) => {
        console.log('Success:', response);
        if (response && response.message) {
          this.successMessage = response.message;
          this.errorMessage = ''; // Clear any previous error message
        }
      },
      (error) => {
        console.error('Error:', error);
        if (error.error && error.error.message) {
          this.errorMessage = error.error.message;
          this.successMessage = ''; // Clear any previous success message
        }
      }
    );
  }


  getBookingDetails() {
    const url = `${this.baseUrl}/getdetails/${this.customerName}/${this.customerPhone}`;

    this.http.get(url).subscribe(
      (response: any) => {
        console.log('Booking Details:', response);
        this.bookingData = response;
        // Handle the booking details response as needed
      },
      (error) => {
        console.error('Booking Details Error:', error);
        // Handle the error as needed
      }
    );
  }

}
