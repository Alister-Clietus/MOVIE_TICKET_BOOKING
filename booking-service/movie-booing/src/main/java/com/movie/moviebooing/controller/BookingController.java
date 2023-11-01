package com.movie.moviebooing.controller;


import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.moviebooing.dto.BookingIdDTO;
import com.movie.moviebooing.dto.TicketBookingDTO;
import com.movie.moviebooing.entity.BookingEntity;
import com.movie.moviebooing.service.BookingCrudServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/booking")
public class BookingController 
{
	@Autowired
	BookingCrudServices service;
	
	
	@GetMapping("/get")
	ResponseEntity<?> getDetails()
	{
		return new ResponseEntity<>(service.getService(),HttpStatus.OK);
	}
	
	@PostMapping("/post")
	ResponseEntity<@Valid ?> postDetails(@Valid @RequestBody TicketBookingDTO bdto)
	{
		return new ResponseEntity<>(service.postService(bdto),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{customerName}/{customerPhone}")
	ResponseEntity<?> deleteDetails(@PathVariable String customerName, @PathVariable String customerPhone)
	{
		return new ResponseEntity<>(service.deleteService(customerName,customerPhone),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	ResponseEntity<?> putDetails(@Valid @RequestBody TicketBookingDTO bdto)
	{
		return new ResponseEntity<>(service.updateService(bdto),HttpStatus.OK);
	}
	
	@PutMapping("/verify")
	ResponseEntity<?> verifydetails(@Valid @RequestBody BookingIdDTO iddto)
	{
		return new ResponseEntity<>(service.verifyService(iddto),HttpStatus.OK);
	}
	
	@GetMapping("/getdetails/{customerName}/{customerPhone}")
	public ResponseEntity<?> getBookingDetails(@PathVariable String customerName, @PathVariable String customerPhone)
	{
		
		return new ResponseEntity<>(service.getbyidService(customerName,customerPhone),HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<?> searchByPage(@RequestParam("searchParam") @Valid String searchParam)
	{
//		JSONObject list = service.searchByLimits(searchParam);	
		System.out.println("sdfsdfsdfsdfsdfsdfsdfsfsdfsdfsdfsdf");
		System.out.println(searchParam);
//		service.searchByLimits(searchParam)
		return new ResponseEntity<>("hello", new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/search/dto")
	public ResponseEntity<?> searchByPagedto(TicketBookingDTO searchParam)
	{

		return new ResponseEntity<>(service.searchByParameterstrial(searchParam), new HttpHeaders(), HttpStatus.OK);
	}


	

}
