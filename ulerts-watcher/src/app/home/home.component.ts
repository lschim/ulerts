import { Component, onInit } from '@angular/core';
import { Ulert } from '../ulert';
import { UlertService } from '../ulert.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: [ './home.component.css' ]
})
export class HomeComponent implements OnInit {
  ulerts: Ulert[] = [];

  constructor(private ulertService: UlertService) { }

  ngOnInit() {
    this.getUlerts();
  }

  getUlerts(): void {
    // blabla
  }
}

