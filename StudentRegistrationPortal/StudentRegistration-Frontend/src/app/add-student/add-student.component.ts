import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
//import { error } from 'console';

@Component({
  selector: 'add-student',
  templateUrl: './add-student.component.html',
  styleUrl: './add-student.component.css'
})
export class AddStudentComponent {

  student: Student = new Student();

  constructor(private studentService: StudentService, private router: Router) { }

   
   OnSubmit() {
     this.saveStudent();
    console.log(this.student);
  }

  saveStudent() {
    this.studentService.createStudent(this.student).subscribe((data) => {
      console.log(data);
       })
      alert('details saved successfully');
      this.getStudentsList();
   
  }

  getStudentsList() {
    this.router.navigate(['/students']);
  }

}
