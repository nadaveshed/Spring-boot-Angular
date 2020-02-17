package project.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.application.entities.User;
import project.application.repositories.UserRepository;
import project.application.service.InventoryService;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private InventoryService inventoryService;

    public UserController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory")
    public List<User> getUsers() {
        List<User> items = inventoryService.retrieveInventory();
        return items;
    }

    @PostMapping("/inventory")
    public void saveItem(@Valid @RequestBody User user) {
        inventoryService.saveItem(user);
        System.out.println("Item Added to the Inventory Successfully");
    }

    @GetMapping("/inventory/{itemId}")
    public User getItem(@PathVariable(name="itemId")Long itemId) {
        return inventoryService.getItem(itemId);
    }

    @DeleteMapping("/inventory/{itemId}")
    public void deleteItem(@PathVariable(name="itemId")Long itemId){
        inventoryService.deleteItem(itemId);
        System.out.println("Item Deleted from the Inventory Successfully");
    }

    @PutMapping("/inventory/{itemId}")
    public void updateItem(@RequestBody User item,
                           @PathVariable(name="itemId")Long itemId){
        User it = inventoryService.getItem(itemId);
        if(it != null){
            inventoryService.updateItem(item);
        }

    }
}
