package com.projectapi9.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="registration")
public class Registration {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
@NotEmpty
@Size(min=3,max=50,message="Name should be atleast 3 Characters")
@Column(name="first_Name",length=45)
private String firstName;
@Column(name="last_Name",length=45)
private String lastName;
@Email
@Column(name="email",unique=true,length=128)
private String email;
@Column(name="mobile")
@Size(min=10,max=10,message="Mobile no. should be exactly 10 digits")
private String mobile;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
}
