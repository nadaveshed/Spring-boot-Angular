package project.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.application.entities.Item;

@Repository
public interface InventoryRepository extends CrudRepository<Item, Long>{}
