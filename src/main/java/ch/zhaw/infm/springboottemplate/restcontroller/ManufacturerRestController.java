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

import ch.zhaw.infm.springboottemplate.entities.Machine;
import ch.zhaw.infm.springboottemplate.entities.Company;
import ch.zhaw.infm.springboottemplate.entities.Manufacturer;
/*import ch.zhaw.infm.springboottemplate.entities.Person;*/
import ch.zhaw.infm.springboottemplate.repositories.ManufacturerRepository;

@RestController
public class ManufacturerRestController { 
	@Autowired
	private ManufacturerRepository repository;

	@RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
	public ResponseEntity<List<Manufacturer>> getmanufacturers() {
		List<Manufacturer> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Manufacturer>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Manufacturer>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "/manufacturers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Manufacturer> getmachinebyID(@PathVariable("id") long id) {
		Optional<Manufacturer> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Manufacturer>(HttpStatus.NOT_FOUND);
		}
	}

	
}
