import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { InventoryService } from '../service/inventory-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inv-list',
  templateUrl: './inv-list.component.html',
  styleUrls: ['./inv-list.component.css']
})
export class InvListComponent implements OnInit {

  items: Item[];
  deleteMessage = false;

  constructor(private inventoryService: InventoryService, private router: Router) {
  }

  ngOnInit() {
    this.inventoryService.findAll().subscribe(data => {
      this.items = data;
    });
  }

  deleteItem(id: number) {
    this.inventoryService.delete(id)
      .subscribe(
        data => {
          this.deleteMessage = true;
          this.inventoryService.findAll().subscribe(data => {
            this.items = data;
          });
        },
        error => console.log(error));
  }

  updateItem(id: number) {
    return this.router.navigate(['edititem/' + `${id}`]);
  }
}
