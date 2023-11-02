import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieShowtime } from 'src/app/models/ticket-booking-dto';

@Component({
  selector: 'app-movielist',
  templateUrl: './movielist.component.html',
  styleUrls: ['./movielist.component.css']
})
export class MovielistComponent implements OnInit {
  isClicked = false;
  constructor(private router: Router,private http: HttpClient) { }
  bookingData: MovieShowtime = new MovieShowtime();

  ngOnInit(): void 
  {
    this.getmoviedetails();
  }


  bookticket(movieId: number, showtimeId: number) {
  console.log("Book ticket for Movie ID:", movieId);
  console.log("Showtime ID:", showtimeId);
  this.router.navigate(['./bookticket/book',movieId,showtimeId]);
}


  getmoviedetails()
  {
    this.http.get('http://localhost:8098/get')
      .subscribe((response: any) => {
        this.bookingData = response.details; 
      });
  }
}
