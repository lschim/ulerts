import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { AmbulanceDetailComponent } from './ambulance-detail/ambulance-detail.component';
import { DispatcherCreateComponent } from './dispatcher-create/dispatcher-create.component';
import { DispatcherDetailComponent } from './dispatcher-detail/dispatcher-detail.component';
import { FirefighterDetailComponent } from './firefighter-detail/firefighter-detail.component';
import { GenericListComponent } from './generic-list/generic-list.component';
import { PoliceDetailComponent } from './police-detail/police-detail.component';
  

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'dispatcher:/create', component: DispatcherCreateComponent },
  {path: 'dispatcher:/id', component: DispatcherDetailComponent },
  {path: 'ambulance/:id', component: AmbulanceDetailComponent },
  {path: 'firefighter/:id', component: FirefighterDetailComponent },
  {path: 'police/:id', component: PoliceDetailComponent },
  {path: 'ulert/list', component: GenericListComponent } // TODO: remove and include in other

];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
