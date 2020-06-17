package ch.zhaw.infm.springboottemplate.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.infm.springboottemplate.entities.Recipient;
import ch.zhaw.infm.springboottemplate.entities.Machine;
import ch.zhaw.infm.springboottemplate.repositories.RecipientRepository;

@RestController
public class RecipientRestController {

	@Autowired
	private RecipientRepository repository;

	@RequestMapping(value = "/recipients", method = RequestMethod.GET)
	public ResponseEntity<List<Recipient>> getrecipients() {
		List<Recipient> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Recipient>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Recipient>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "/recipients/{id}", method = RequestMethod.GET)
	public ResponseEntity<Recipient> getrecipientsbyID(@PathVariable("id") long id) {
		Optional<Recipient> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Recipient>(HttpStatus.NOT_FOUND);
		}
	}
	
}
