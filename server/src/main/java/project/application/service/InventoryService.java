package project.application.service;

import project.application.entities.Item;

import java.util.List;

public interface InventoryService {
    public List<Item> retrieveInventory();

    public Item getItem(Long ItemId);

    public void saveItem(Item item);

    public void deleteItem(Long itemId);

    public void updateItem(Item item);
}
