export class Incident {

  constructor(
    public id: number,
    public emergencyType: string,
    public date: Date,
    public name?: string,
    public age?: number,
    public sexe?: string,
    public description?: string,
    public victimeNbr?: number
  ) {  }

}
