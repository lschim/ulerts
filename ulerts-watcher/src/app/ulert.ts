export class Ulert {
  constructor (
    public id: number,
    public isAmbulance: boolean,
    public isFirefighter: boolean,
    public isPolice: boolean,
    public emergencyType: string,
    public phone: number,
    public callTime: Date = new Date(),
    public location: { [key: number]: number; } = {},
    public active: boolean = true,
    public name?: string,
    public age?: number,
    public sex?: boolean,
    public victimCount?: number,
    public description?: string,
    public photo?: HTMLImageElement // may be of 'File' type
  ) { }
}
