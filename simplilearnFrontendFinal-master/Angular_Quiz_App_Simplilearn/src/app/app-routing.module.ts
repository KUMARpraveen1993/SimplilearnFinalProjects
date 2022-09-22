import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionComponent } from './question/question.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
// provide routing for both the component welcome and question...

  {path:'',redirectTo: 'welcome',pathMatch:"full"},
  {path:"welcome", component:WelcomeComponent},
  {path:"question",component:QuestionComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
