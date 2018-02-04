export class Ulert {
  id: number;
  isAmbulance: boolean;
  isFirefighter: boolean;
  isPolice: boolean;
  emergencyType: string;
  name?: string;
  age?: number;
  sex?: boolean;
  victimCount?: number;
  description?: string;
  phone: number;
  location?: { [key: number]: number; } = {};
  callTime: number;
  photo?: HTMLImageElement; // may be of 'File' type
  active: boolean;
}
