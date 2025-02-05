package com.hibernate;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id ;
	
	@Column(name="name")
private String name;
	@Transient
private String secName;
	@Temporal(TemporalType.DATE)
private Date date;
	@Lob
private byte[] image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecName() {
		return secName;
	}
	public void setSecName(String secName) {
		this.secName = secName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte []image) {
		this.image = image;
	}
	public Address(int id, String name, String secName, Date date, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.secName = secName;
		this.date = date;
		this.image = image;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", secName=" + secName + ", date=" + date + ", image=" + image
				+ "]";
	}
	
}
