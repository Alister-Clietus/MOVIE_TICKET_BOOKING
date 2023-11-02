package com.movie.moviebooing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.moviebooing.entity.MovieDetailsEntity;

@Repository
public interface MovieDetails extends JpaRepository<MovieDetailsEntity,Integer>{

}
