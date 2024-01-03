import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { StudentService } from './student.service';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { HttpClientModule} from '@angular/common/http';
import { AddStudentComponent } from './add-student/add-student.component';
import { FormsModule } from '@angular/forms';
import { UpdateComponent } from './update/update.component';
import { StudentDetailsComponent } from './student-details/student-details.component';

//import { provideHttpClient, withFetch } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    AddStudentComponent,
    UpdateComponent,
    StudentDetailsComponent
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    provideClientHydration(),StudentService
   
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
