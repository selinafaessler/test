package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* import ch.zhaw.infm.springboottemplate.entities.order;*/
import ch.zhaw.infm.springboottemplate.entities.*;
import ch.zhaw.infm.springboottemplate.repositories.OrderRepository;

@RestController
public class OrderRestController {
	@Autowired
	private OrderRepository repository;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getorder() {
		List<Order> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> getorderbyID(@PathVariable("id") long id) {
		Optional<Order> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
	}
/*
	//Mapping for Query
	@RequestMapping(value = "/orderDate", method = RequestMethod.GET)
	public ResponseEntity<order> getorderbyID(@PathVariable("id") long id) {
		Optional<order> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<order>(HttpStatus.NOT_FOUND);
		}
	}
*/
	
}
