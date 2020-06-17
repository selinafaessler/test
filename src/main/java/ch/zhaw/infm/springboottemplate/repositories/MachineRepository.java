package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {

}
