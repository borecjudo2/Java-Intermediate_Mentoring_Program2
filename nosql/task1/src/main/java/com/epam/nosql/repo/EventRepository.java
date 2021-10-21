package com.epam.nosql.repo;

import com.epam.nosql.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Repository
public interface EventRepository extends MongoRepository<Event, String> {

  Optional<Event> findEventByTitle(String title);

}
