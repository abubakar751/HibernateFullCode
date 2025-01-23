package com.enties;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Note {
	@Id
	private int id;
	@Column(length = 500)
	private String title;
	@Column(length = 1500)
	private String contant;
	private Date addedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContant() {
		return contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", contant=" + contant + ", addedDate=" + addedDate + "]";
	}

	public Note( String title, String contant, Date addedDate) {
		super();
		this.id =new Random().nextInt(100000);
		this.title = title;
		this.contant = contant;
		this.addedDate = addedDate;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
