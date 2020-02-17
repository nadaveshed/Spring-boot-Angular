package project.application.service;

import project.application.entities.User;
import java.util.List;

public interface InventoryService {
    public List<User> retrieveInventory();

    public User getItem(Long ItemId);

    public void saveItem(User item);

    public void deleteItem(Long itemId);

    public void updateItem(User item);
}
