import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketBookingDTO } from 'src/app/models/ticket-booking-dto';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

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

  clear()
  {
    this.router.navigate(['./bookticket/show']);
  }

  backToUser()
  {
    this.router.navigate(['./bookticket/show']);
  }

  delete() {
    const url = `${this.baseUrl}/delete/${this.customerName}/${this.customerPhone}`;
  
    this.http.delete(url).subscribe(
      (response: any) => {
        if (response.message === "UnSucessfull") {
          console.error('Delete Unsuccessful:', response);
          // Handle the unsuccessful response as needed, e.g., display an error message.
        } else {
          console.log('Delete Successful:', response);
          // Handle the successful response as needed.
          if (response && response.message) {
            this.successMessage = response.message;
            this.errorMessage = ''; // Clear any previous error message
          }
        }
      },
      (error) => {
        console.error('Delete Error:', error);
        // Handle the error as needed
        if (error.error && error.error.message) {
          this.errorMessage = error.error.message;
          this.successMessage = ''; // Clear any previous success message
        }
      }
    );
  }
  


}
