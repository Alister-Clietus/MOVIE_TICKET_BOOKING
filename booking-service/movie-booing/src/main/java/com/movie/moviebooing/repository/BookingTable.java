package com.movie.moviebooing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.movie.moviebooing.entity.BookingEntity;
import com.movie.moviebooing.entity.BookingID;

@Repository
public interface BookingTable extends JpaRepository<BookingEntity,BookingID>,JpaSpecificationExecutor<BookingEntity>
{

}
