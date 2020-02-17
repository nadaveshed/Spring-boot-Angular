package project.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.application.entities.User;
import project.application.repositories.UserRepository;
import project.application.service.InventoryService;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private UserRepository inventoryRepository;

    public void InventoryServiceImpl(UserRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<User> retrieveInventory() {
        List<User> items = (List<User>) inventoryRepository.findAll();
        return items;
    }

    public User getItem(Long itemId) {
        Optional<User> optItem = inventoryRepository.findById(itemId);
        return optItem.get();
    }

    public void saveItem(User item){
        inventoryRepository.save(item);
    }

    public void deleteItem(Long itemId){
        inventoryRepository.deleteById(itemId);
    }

    public void updateItem(User item) {
        inventoryRepository.save(item);
    }
}
