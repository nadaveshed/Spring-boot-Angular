package project.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.application.entities.Item;
import project.application.repositories.InventoryRepository;
import project.application.service.InventoryService;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public void InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Item> retrieveInventory() {
        List<Item> items = (List<Item>) inventoryRepository.findAll();
        return items;
    }

    public Item getItem(Long itemId) {
        Optional<Item> optItem = inventoryRepository.findById(itemId);
        return optItem.get();
    }

    public void saveItem(Item item){
        inventoryRepository.save(item);
    }

    public void deleteItem(Long itemId){
        inventoryRepository.deleteById(itemId);
    }

    public void updateItem(Item item) {
        inventoryRepository.save(item);
    }
}
