package com.example.StudentDataStorage.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentData")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column(name="college_name")
	private String College;
	@Column(name = "mobile_number")
	private String mobilenumber;
	@Column(name="Email_Id")
	private String email;
	@Column(name="Course_name")
	private String  coursename;
	@Column(name="Course_Fee")
	private int CourseFee;
	
	
	
	
	public Student() {
		super();
	}
	
	public Student(int id, String firstname, String lastname, String college, String mobilenumber, String email,
			String coursename, int courseFee,String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		College = college;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.coursename = coursename;
		CourseFee = courseFee;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getCourseFee() {
		return CourseFee;
	}
	public void setCourseFee(int courseFee) {
		CourseFee = courseFee;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", College=" + College
				+ ", mobilenumber=" + mobilenumber + ", email=" + email + ", coursename=" + coursename + ", CourseFee="
				+ CourseFee +  "]";
	}



	
	
}
