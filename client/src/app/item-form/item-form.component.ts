import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../model/item';
import {InventoryService} from '../service/inventory-service.service';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent {

  item: Item;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private inventoryService: InventoryService) {
    this.item = new Item();
  }

  onSubmit() {
    this.inventoryService.save(this.item).subscribe(result => this.gotoInvList());
  }

  gotoInvList() {
    this.router.navigate(['/inventory']);
  }
}
