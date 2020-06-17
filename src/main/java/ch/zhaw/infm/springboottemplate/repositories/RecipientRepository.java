package ch.zhaw.infm.springboottemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.infm.springboottemplate.entities.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {

}
