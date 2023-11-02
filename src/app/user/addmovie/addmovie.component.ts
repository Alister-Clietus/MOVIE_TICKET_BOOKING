import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieShowtime } from 'src/app/models/ticket-booking-dto';

@Component({
  selector: 'app-addmovie',
  templateUrl: './addmovie.component.html',
  styleUrls: ['./addmovie.component.css']
})
export class AddmovieComponent implements OnInit {
  errorMessage: any;
  successMessage: string;
  validationErrors: any;
  bookingData: MovieShowtime = new MovieShowtime();

  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit(): void 
  {

  }

  submitForm() {
    const url = 'http://localhost:8098/post';
  
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

      } else {
        if (response.details) {
          response.details.forEach(element => {
            var key = Object.keys(element)[0];
            this.validationErrors[key] = element[key];
          });
        }
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
  clear()
  {
    
  }

  movieList()
  {
    this.router.navigate(['./bookticket/movielist']);
  }

}
