package ch.zhaw.infm.springboottemplate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.infm.springboottemplate.entities.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {


}
