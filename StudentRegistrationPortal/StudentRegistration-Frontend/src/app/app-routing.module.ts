import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { AddStudentComponent } from './add-student/add-student.component';
import { UpdateComponent } from './update/update.component';
import { StudentDetailsComponent } from './student-details/student-details.component';



const routes: Routes = [
  {path:'students', component:StudentListComponent},
  {path:'addstudents',component:AddStudentComponent},
  {path:'updatestudents/:id', component:UpdateComponent},
  {path:'student-details/:id', component:StudentDetailsComponent},
  {path:' ',redirectTo:'students',pathMatch:'full'}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
