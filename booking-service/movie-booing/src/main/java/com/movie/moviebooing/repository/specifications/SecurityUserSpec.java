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

import com.movie.moviebooing.entity.BookingEntity;



public class SecurityUserSpec {
	public static Specification<BookingEntity> getUserSpec(String searchParam) {
		return new Specification<BookingEntity>() {
			public Predicate toPredicate(Root<BookingEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate finalPredicate = null;
				JSONParser parser = new JSONParser();
				JSONObject searchObject;
				try {
					System.out.println(searchParam);
					searchObject = (JSONObject) parser.parse(searchParam);
					System.out.println("***********************************************");
					System.out.println(searchParam);
					String movieid = (String) searchObject.get("movieId");
					String showtimeId = (String) searchObject.get("showtimeId");
					String numberOfTickets = (String) searchObject.get("numberOfTickets");
					String status = (String) searchObject.get("status");
		            if(!StringUtils.isEmpty(movieid)) {
		            	Predicate statusPredicate = criteriaBuilder.equal(root.get("status"), movieid);
		            	finalPredicate = criteriaBuilder.and(statusPredicate);
		            }
		            
		            if(!StringUtils.isEmpty(showtimeId)) {
		            	Predicate statusPredicate = criteriaBuilder.equal(root.get("status"), showtimeId);
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate, statusPredicate);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(statusPredicate);
		            	}
		            	
		            }
		            
		            if(!StringUtils.isEmpty(numberOfTickets)) {
		            	Predicate statusPredicate = criteriaBuilder.equal(root.get("status"), numberOfTickets);
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate, statusPredicate);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(statusPredicate);
		            	}
		            }
		            
		            if(!StringUtils.isEmpty(status)) {
		            	Predicate userIdPredicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("status")), "%"+status.toUpperCase()+"%");
		            	if(finalPredicate!=null) {
		            		finalPredicate = criteriaBuilder.and(finalPredicate, userIdPredicate);
		            	}else {
		            		finalPredicate = criteriaBuilder.and(userIdPredicate);
		            	}
		            }
		            
		            Order proTimeOrder = criteriaBuilder.desc(root.get("modifiedby"));
		            query.orderBy(proTimeOrder);
		            
				} catch (ParseException e) {
					e.printStackTrace();
				}
	            
				return finalPredicate;
			}
		};
	}
}
