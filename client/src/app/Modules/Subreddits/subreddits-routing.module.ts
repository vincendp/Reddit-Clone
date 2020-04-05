import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SubredditsComponent } from "./subreddits.component";

const routes: Routes = [
  {
    path: "",
    component: SubredditsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubredditsRoutingModule { }
