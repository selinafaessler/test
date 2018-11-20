package ch.zhaw.infm.springboottemplate.repositories;

import ch.zhaw.infm.springboottemplate.entities.World;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Zur World-Entity passendes Repository-Interface
 */
public interface WorldRepository extends JpaRepository<World, Long> {
    List<World> findAllByOrderByName();
    
    Optional<World> findByName(String name);
}
