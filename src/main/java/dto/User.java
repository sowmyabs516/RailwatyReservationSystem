package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	@Id
	
	@GeneratedValue(generator = "x")
	@SequenceGenerator(name = "x", sequenceName = "x", initialValue = 1214561, allocationSize = 1)
	int id;
	String firstName;
	String lastName;
	String email;
	long mobile;
	String gender;
	String createpassword;
	String confirmpassword;
	Date dob;
	int age;
	double wallet;
	
	
	@OneToMany
	List<TrainTicket> tickets;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getCreatepassword() {
		return createpassword;
	}
	public void setCreatepassword(String createpassword) {
		this.createpassword = createpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public List<TrainTicket> getTickets() {
		return tickets;
	}
	public void setTickets(List<TrainTicket> tickets) {
		this.tickets = tickets;
	}
	
	
}
