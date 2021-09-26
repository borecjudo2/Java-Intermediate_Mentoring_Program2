package com.epam.restapi.repo;

import com.epam.restapi.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

  Optional<Event> findEventByTitle(String title);

}
