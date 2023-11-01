package com.movie.moviebooing.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.movie.moviebooing.dto.BookingIdDTO;
import com.movie.moviebooing.dto.BookingResponse;
import com.movie.moviebooing.dto.TicketBookingDTO;
import com.movie.moviebooing.entity.BookingEntity;

public interface BookingCrudServices 
{
	BookingResponse postService(TicketBookingDTO bdto);
	JSONObject getService();
	BookingResponse deleteService(String customerName, String customerPhone);
	BookingResponse verifyService(BookingIdDTO iddto);
	BookingResponse updateService(TicketBookingDTO bdto);
	JSONObject getbyidService(String customerName, String customerPhone);
	public JSONObject searchByLimits(String searchParam);
	public JSONObject searchByLimit(String searchParam, int start, int pageSize);
	public List<BookingEntity> searchByParameterstrial(TicketBookingDTO searchParam);
}
