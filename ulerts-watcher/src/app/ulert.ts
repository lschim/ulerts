export class Ulert {
  id: number;
  name: string;
  age: number;
  sex: boolean;
  phone: number;
  location: { [key: number]: number; } = {};
  callTime: number;
  photo: HTMLImageElement; // may be of 'File' type
}
