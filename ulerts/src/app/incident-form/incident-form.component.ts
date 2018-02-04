import { Component, OnInit } from '@angular/core';
import { Incident} from "../incident";

@Component({
  selector: 'app-incident-form',
  templateUrl: './incident-form.component.html',
  styleUrls: ['./incident-form.component.css']
})
export class IncidentFormComponent {

  emergencyType = ['Fire', 'Road Accident', 'Aggression'];

  sexe = ['F', 'M', 'I'];

  model = new Incident(1, 'Fire', new Date(), 'Just Name');

  submitted = false;

  onSubmit() { this.submitted = true; }

  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

}
