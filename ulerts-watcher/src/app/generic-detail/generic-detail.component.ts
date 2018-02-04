import { Component, OnInit } from '@angular/core';
import { Ulert } from '../ulert';

@Component({
  selector: 'app-generic-detail',
  templateUrl: './generic-detail.component.html',
  styleUrls: ['./generic-detail.component.css']
})

// export class
export class GenericDetailComponent {

  emergencyType = ['Fire', 'Road Accident', 'Aggression'];

  sex = ['F', 'M', 'I'];
  model = new Ulert(1, true, true, false, 'Fire', 8883334444, new Date());

  submitted = false;

  onSubmit() { this.submitted = true; }

  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

}
