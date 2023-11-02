package com.movie.moviebooing.serviceimp;

import org.json.simple.JSONObject;

import com.movie.moviebooing.DTO.BookingResponse;
import com.movie.moviebooing.DTO.MovieDetailsDTO;



public interface MovieDetailsService 
{
	JSONObject getService();
	BookingResponse postService(MovieDetailsDTO bdto);


}
