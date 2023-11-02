import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketBookingDTO } from 'src/app/models/ticket-booking-dto';

declare var $: any;
declare var jQuery: any;

@Component({
  selector: 'app-bookticket',
  templateUrl: './bookticket.component.html',
  styleUrls: ['./bookticket.component.css']
})
export class BookticketComponent
{
  
  bookingData: TicketBookingDTO = new TicketBookingDTO();
  successMessage: any;
  errorMessage: string;
  validationErrors: any;
  movieid: any;
  showid: any;

  constructor(private http: HttpClient,private route: ActivatedRoute,private router: Router) {
    this.route.params.subscribe(params => {
      this.movieid = params['movieid'];
      this.showid = params['showid']; 
  });
}



  ngOnInit() {
    this.bookingData.movieId=this.movieid;
    this.bookingData.showtimeId=this.showid;
    this.validationErrors = {};
  }

  submitForm() {
    const url = 'http://localhost:8099/booking/post';
  
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
  
    this.http.post(url, this.bookingData, { headers }).subscribe(

      (response: any) => {
        // console.log(item);
        this.successMessage = response.message;
        this.errorMessage = ''; 
      //this.toastr.success(item.message, 'User', { positionClass: 'toast-bottom-right' });
      //this.router.navigate(['./home/user']);
      if (response.code.toLowerCase() == "success") {
        this.clear();
        // this.commonServiceProvider.ShowToasts('User', 'Create', item.message, 'Success');
       // this.savePageDataWithencryption();
      } else {
        if (response.details) {
          response.details.forEach(element => {
            var key = Object.keys(element)[0];
            this.validationErrors[key] = element[key];
          });
        // console.log(this.validationMessage);
        }
        // this.commonServiceProvider.ShowToasts('User', 'Create', item.message, 'Danger');
      }
    },
      (error) => {
        console.error('Error:', error);
        if (error.error && error.error.message) {
          this.errorMessage = error.error.message;
          this.successMessage = ''; // Clear any previous success message
          this.validationErrors = error.error.details; // Store validation errors
        }
      }
    );
  }
  


  addUser()
  {
    this.submitForm();
  }

  clear()
  {
    $("#movieId").val('');
    $("#showid").val('');
    $("#no").val('');
    $("#name").val('');
    $('#email').val('');
    $('#payment').val('');
    $("#amount").val('');
    $("#date").val('');
  }

  backToUser()
  {
    this.router.navigate(['./bookticket/show']);
  }
}
