import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
// all other components to add

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'dispatcher', component: DispatcherListComponent },
  {path: 'dispatcher:/create', component: DispatcherCreateComponent },
  {path: 'dispatcher:/id', component: DispatcherDetailComponent },
  {path: 'ambulance', component: AmbulanceListComponent },
  {path: 'ambulance/:id', component: AmbulanceDetailComponent },
  {path: 'firefighter', component: FireFighterListComponent },
  {path: 'firefighter/:id', component: FireFighterDetailComponent },
  {path: 'police', component: PoliceListComponent },
  {path: 'police/:id', component: PoliceDetailComponent }

];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
