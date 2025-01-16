package com.hibernate.Embeddable;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserClassForEmbadableAnnotation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	@Embedded
	private UserAddress userAddress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	
	public UserClassForEmbadableAnnotation(int id, String userName, UserAddress userAddress, UserAddress address) {
		super();
		this.id = id;
		this.userName = userName;
		this.userAddress = userAddress;
		
	}
	public UserClassForEmbadableAnnotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserClassForEmbadableAnnotation [id=" + id + ", userName=" + userName + ", userAddress=" + userAddress
				+ ", address=" + "]";
	}
	
	

}
