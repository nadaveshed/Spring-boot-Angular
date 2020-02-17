package project.application.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private final String name;

    @Column(name = "item_number")
    private final String itemNo;

    @Column(name = "amount")
    private final String amount;

    @Column(name = "inventory_code")
    private final String inventoryCode;

    @Column(name = "item_details")
    private final String itemDetails;
    
    public User() {
        this.name = "";
        this.itemNo = "";
        this.amount = "";
        this.inventoryCode = "";
        this.itemDetails = "";
    }
    
    public User(String name, String itemNo, String amount, String inventoryCode, String itemDetails) {
        this.name = name;
        this.itemNo = itemNo;
        this.amount = amount;
        this.inventoryCode = inventoryCode;
        this.itemDetails = itemDetails;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + itemNo + '}';
    }
}
