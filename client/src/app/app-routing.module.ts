import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InvListComponent } from './inv-list/inv-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import {EditItemComponent} from './edit-item/edit-item.component';

const routes: Routes = [
  { path: '', redirectTo: 'inventory', pathMatch: 'full'},
  { path: 'inventory', component: InvListComponent },
  { path: 'additem', component: ItemFormComponent },
  { path: 'edititem/:id', component: EditItemComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
