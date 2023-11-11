package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Train {
	@Id
	int tnumber;
	String name;
	int seat;
	String[] stations;
	String[] price;
	String[] time;
	String[] days;
	
	public int getTnumber() {
		return tnumber;
	}
	public void setTnumber(int tnumber) {
		this.tnumber = tnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String[] getStations() {
		return stations;
	}
	public void setStations(String[] stations) {
		this.stations = stations;
	}
	public String[] getPrice() {
		return price;
	}
	public void setPrice(String[] price) {
		this.price = price;
	}
	public String[] getTime() {
		return time;
	}
	public void setTime(String[] time) {
		this.time = time;
	}
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	
	
}
