package project.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.application.entities.Item;
import project.application.service.InventoryService;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory")
    public List<Item> getItems() {
        List<Item> items = inventoryService.retrieveInventory();
        return items;
    }

    @PostMapping("/inventory")
    public void saveItem(@Valid @RequestBody Item item) {
        inventoryService.saveItem(item);
        System.out.println("Item Added to the Inventory Successfully");
    }

    @GetMapping("/inventory/{itemId}")
    public Item getItem(@PathVariable(name="itemId")Long itemId) {
        return inventoryService.getItem(itemId);
    }

    @DeleteMapping("/inventory/{itemId}")
    public void deleteItem(@PathVariable(name="itemId")Long itemId){
        inventoryService.deleteItem(itemId);
        System.out.println("Item Deleted from the Inventory Successfully");
    }

    @PutMapping("/inventory/{itemId}")
    public void updateItem(@RequestBody Item item,
                           @PathVariable(name="itemId")Long itemId){
        Item it = inventoryService.getItem(itemId);
        if(it != null){
            inventoryService.updateItem(item);
        }

    }
}
