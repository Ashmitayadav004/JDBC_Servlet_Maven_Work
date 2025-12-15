package com.telusko.DemoHibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int rollno;
	private String name;
	
//	@OneToOne
//	private Laptop laptop;

	@OneToMany(mappedBy="student",fetch = FetchType.EAGER)
	private Collection<Laptop> laptop = new ArrayList<Laptop>();
	
	

	public Collection<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(Collection<Laptop> laptop) {
		this.laptop = laptop;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", laptop=" + laptop + "]";
	}

	

	
	

}
