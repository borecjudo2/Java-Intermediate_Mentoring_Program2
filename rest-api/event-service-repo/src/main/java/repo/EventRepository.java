package repo;

import model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface EventRepository extends CrudRepository<Event, Integer> {

  Optional<Event> findEventByTitle(String title);

}
