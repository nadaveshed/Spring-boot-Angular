import { Component, OnInit } from '@angular/core';
import {Item} from '../model/item';
import {ActivatedRoute, Router} from '@angular/router';
import {InventoryService} from '../service/inventory-service.service';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {

  id: number;
  item: Item;

  constructor(private route: ActivatedRoute, private router: Router,
              private inventoryService: InventoryService) { }

  ngOnInit() {
    this.item = new Item();
    this.id = this.route.snapshot.params['id'];
    this.inventoryService.getItem(this.id, this.item)
      .subscribe(data => {
        console.log(data)
        this.item = data;
      }, error => console.log(error));
  }

  updateItem() {
    this.inventoryService.updateItem(this.id, this.item)
      .subscribe(data => console.log(data), error => console.log(error));
    this.item = new Item();
    this.gotoList();
  }

  onSubmit() {
    this.updateItem();
  }

  gotoList() {
    this.router.navigate(['/inventory']);
  }

}
