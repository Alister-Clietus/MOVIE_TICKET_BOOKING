package com.movie.moviebooing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.moviebooing.DTO.MovieDetailsDTO;

import com.movie.moviebooing.services.MovieDetailsServiceImp;


@RestController
@RequestMapping
public class MovieDetailsController 
{
	@Autowired
	MovieDetailsServiceImp service;
	
	@GetMapping("/get")
	ResponseEntity<?> getDetails()
	{
		return new ResponseEntity<>(service.getService(),HttpStatus.OK);
	}
	
	@PostMapping("/post")
	ResponseEntity<?> postDetails( @RequestBody MovieDetailsDTO bdto)
	{
		return new ResponseEntity<>(service.postService(bdto),HttpStatus.OK);
	}
	

}

