package com.movie.moviebooing.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class BookingID 
{
	@Column(name="Name")
	private String customerName;
	@Column(name="Phone")
    private String customerPhone;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	

}
