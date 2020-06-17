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
import ch.zhaw.infm.springboottemplate.repositories.MachineRepository;

@RestController
public class MachineRestController {
	@Autowired
	private MachineRepository repository;

	@RequestMapping(value = "/machine", method = RequestMethod.GET)
	public ResponseEntity<List<Machine>> getmachine() {
		List<Machine> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Machine>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Machine>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/machine/{id}", method = RequestMethod.GET)
	public ResponseEntity<Machine> getmachinebyID(@PathVariable("id") long id) {
		Optional<Machine> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Machine>(HttpStatus.NOT_FOUND);
		}
	}

}
