export class InventoryItem {

  id: number;
  name: string;
  quantity: number;
  value: Float64Array;

  constructor(id?:number, name?:string, quantity?:number,
    value?: Float64Array){

      this.id = id;
      this.name = name;
      this.quantity = quantity;
      this.value = value;

    }
}
