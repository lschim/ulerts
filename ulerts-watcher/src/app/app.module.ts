import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { GenericDetailComponent } from './generic-detail/generic-detail.component';
import { HomeComponent } from './home/home.component';

// import { AmbulanceDetailComponent } from './ambulance-detail/ambulance-detail.component';



@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent, 
    GenericDetailComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
