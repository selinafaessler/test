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
public class Recipient extends Company {
	private String creditcardNumber;


	@OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();

	
	public Recipient(String name, String city, String creditcardNumber) {
		super(name, city);
		this.creditcardNumber = creditcardNumber;
	}

	public Recipient() {
	}

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
