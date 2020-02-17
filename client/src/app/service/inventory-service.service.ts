import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Item } from '../model/item';
import {Observable} from 'rxjs';

@Injectable()
export class InventoryService {

  private inventUrl: string;

  constructor(private http: HttpClient) {
    this.inventUrl = 'http://localhost:8080/inventory';
  }

  public findAll(): Observable<Item[]> {
    return this.http.get<Item[]>(this.inventUrl);
  }

  public save(it: Item) {
    return this.http.post<Item>(this.inventUrl, it);
  }

  public getItem(id: number, value: any): Observable<any> {
    return this.http.get<Item>(`${this.inventUrl}/${id}`, value);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<Item>(`${this.inventUrl}/${id}`);
  }

  public updateItem(id: number, value: any): Observable<any> {
    return this.http.put<Item>(`${this.inventUrl}/${id}`, value);
  }
}
