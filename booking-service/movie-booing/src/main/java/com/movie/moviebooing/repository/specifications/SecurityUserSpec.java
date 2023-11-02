package com.movie.moviebooing.repository.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.movie.moviebooing.dto.TicketBookingDTO;
import com.movie.moviebooing.dto.searchDTO;
import com.movie.moviebooing.entity.BookingEntity;



public class SecurityUserSpec 
{
	public static Specification<BookingEntity> getUserSpec(searchDTO searchParam) 
	{
		return new Specification<BookingEntity>() 
		{
			public Predicate toPredicate(Root<BookingEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) 
			{
				Predicate finalPredicate = null;	
		        try {
		            if (searchParam.getMovieId() != 0) {
		            	Predicate movieidPredicate= criteriaBuilder.equal(root.get("movieId"), searchParam.getMovieId());
		            	finalPredicate = criteriaBuilder.and(movieidPredicate);
		            }
		            if (searchParam.getBookingDate() != null) {
		            	Predicate bookingdatePredicate= criteriaBuilder.like(root.get("bookingDate"), "%"+searchParam.getBookingDate()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,bookingdatePredicate);
		            		System.out.println();
		            	}else {
		            		finalPredicate = criteriaBuilder.and(bookingdatePredicate);
		            	}
		            }
		            if (searchParam.getShowtimeId() != 0) {
		            	Predicate showtimepredicates=criteriaBuilder.equal(root.get("showtimeId"), searchParam.getShowtimeId());
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,showtimepredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(showtimepredicates);
		            	}
		            }
		            if (searchParam.getCustomerName() != null) {
		            	Predicate namepredicates=criteriaBuilder.like(root.get("id").get("customerName"),"%"+searchParam.getCustomerName()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,namepredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(namepredicates);
		            	}
		            }
		            if (searchParam.getCustomerPhone() != null) {
		            	Predicate phonepredicates=criteriaBuilder.like(root.get("id").get("customerPhone"), "%"+searchParam.getCustomerPhone()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,phonepredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(phonepredicates);
		            	}
		            }
		            if (searchParam.getCustomerEmail() != null) {

		            	Predicate emailpredicates=criteriaBuilder.like(root.get("email"), "%"+searchParam.getCustomerEmail()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,emailpredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(emailpredicates);
		            	}
		            }
		            if (searchParam.getPaymentMethod() != null) {
		            	System.out.println(searchParam.getPaymentMethod());

		            	Predicate methodpredicates=criteriaBuilder.like(root.get("paymentMethod"),"%"+searchParam.getPaymentMethod()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,methodpredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(methodpredicates);
		            	}
		            }
		            if (searchParam.getNumberOfTickets() != 0) {
		            	System.out.println(searchParam.getNumberOfTickets());

		            	Predicate numberpredicates=criteriaBuilder.equal(root.get("numberOfTickets"), searchParam.getNumberOfTickets());
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,numberpredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(numberpredicates);
		            	}
		            }
		            if (searchParam.getTotalAmount() != 0) {
		            	System.out.println(searchParam.getTotalAmount());

		            	Predicate amountpredicates=criteriaBuilder.equal(root.get("totalAmount"), searchParam.getTotalAmount());
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,amountpredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(amountpredicates);
		            	}
		            }
		            if (searchParam.getStatus() != null) {
		            	System.out.println(searchParam.getStatus());

		            	Predicate statuspredicates=criteriaBuilder.like(root.get("status"), "%"+searchParam.getStatus()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate,statuspredicates);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(statuspredicates);
		            	}
		            }

//		            System.out.println("***********************************");
		            Order proTimeOrder = criteriaBuilder.desc(root.get("modifiedby"));
//		            System.out.println(proTimeOrder);
		            query.orderBy(proTimeOrder);
		            
		            
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		        System.out.println(finalPredicate);
		        System.out.println("***********************************");
				return finalPredicate;

		} 
		}; 
	}
} 


