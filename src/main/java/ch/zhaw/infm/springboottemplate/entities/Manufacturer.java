package ch.zhaw.infm.springboottemplate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manufacturer extends Company {
	private long licenceNumber;
	
	@OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();

	public Manufacturer(String name, String city, long licenceNumber) {
		super(name, city);
		this.licenceNumber = licenceNumber;
	}

	public Manufacturer() {
	}

	public long getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(long licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
}
