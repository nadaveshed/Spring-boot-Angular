import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InvListComponent } from './inv-list/inv-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import {HttpClientModule} from '@angular/common/http';
import {InventoryService} from './service/inventory-service.service';
import {FormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {EditItemComponent} from './edit-item/edit-item.component';

@NgModule({
  declarations: [
    AppComponent,
    InvListComponent,
    ItemFormComponent,
    EditItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [InventoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
