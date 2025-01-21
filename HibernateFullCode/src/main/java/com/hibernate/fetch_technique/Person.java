	package com.hibernate.fetch_technique;

import java.util.List;

import com.hibernate.one_to_many.ManyAnswer;

import jakarta.persistence.*;

	@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "name", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> list;

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

	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", list=" + list + "]";
	}

	
    
}
