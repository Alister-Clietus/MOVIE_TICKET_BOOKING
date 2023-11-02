package com.movie.moviebooing.services;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.moviebooing.DTO.BookingResponse;
import com.movie.moviebooing.DTO.MovieDetailsDTO;
import com.movie.moviebooing.entity.MovieDetailsEntity;
import com.movie.moviebooing.repository.MovieDetails;
import com.movie.moviebooing.serviceimp.MovieDetailsService;


@Service
public class MovieDetailsServiceImp implements MovieDetailsService
{
	
	@Autowired
	MovieDetails repo;
	
	public JSONObject getService()
	{
		JSONObject result = new JSONObject();
	    JSONArray bookingsArray = new JSONArray();
	    
	    try {
	        List<MovieDetailsEntity> bookingEntities = repo.findAll();
	    
	        for (MovieDetailsEntity entity : bookingEntities) {
	            JSONObject bookingObject = new JSONObject();
	            bookingObject.put("movieId", entity.getMovieId());
	            bookingObject.put("showtimeId", entity.getShowId());
	            bookingObject.put("showTime", entity.getShowTime());
	            bookingObject.put("theater", entity.getTheater());
	            bookingObject.put("movieName", entity.getMovieName());
	            bookingObject.put("date", entity.getDate());
	            bookingObject.put("imageUrl", entity.getImageUrl());
	    
	            bookingsArray.add(bookingObject);
	        }
	    
	        result.put("details", bookingsArray);
	    } 
	    catch (Exception e) 
	    {
	       
	        e.printStackTrace(); 
	        result.put("error", "Exception error");
	    }
	    
	    return result;

		
	}
	public BookingResponse postService(MovieDetailsDTO bdto)
	{
		MovieDetailsEntity bookingEntity = new MovieDetailsEntity();

		try {
			
			bookingEntity.setMovieId(bdto.getMovieId());
			bookingEntity.setShowId(bdto.getShowId());
			bookingEntity.setShowTime(bdto.getShowTime());
			bookingEntity.setTheater(bdto.getTheater());
			bookingEntity.setMovieName(bdto.getMovieName());
			bookingEntity.setDate(bdto.getDate());
			bookingEntity.setImageUrl(bdto.getImageUrl());
	        repo.save(bookingEntity);
	        return new BookingResponse("Post Successful", "Successful", null);
	    } 
	    catch (Exception e) 
	    {
	       
	        e.printStackTrace(); 
	        return new BookingResponse("Exception error", "Unsuccessful", null);
	    }

		
	}


}
