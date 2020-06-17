package ch.zhaw.infm.springboottemplate.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ch.zhaw.infm.springboottemplate.entities.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
//	@Query("SELECT name FROM company p JOIN order b ON p.id = b.manufacturer_id WHERE b.date = ?1")
//	List<company> getcompanyByDate(long date);

}
