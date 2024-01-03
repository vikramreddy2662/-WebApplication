import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
//import { HttpClient } from '@angular/common/http';
import { StudentService } from '../student.service';
import { Router } from '@angular/router'
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'student-list',
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent implements OnInit {

  students: any;


  constructor(private studentService: StudentService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
   
    this.getStudents();
  }

  getStudents() {

    return this.studentService.getStudentsList().subscribe((data) => {
      this.students = data;
    });

  }
  OnUpdateStudentDetails(id: number) {

    console.log(id);

    this.router.navigate(['/updatestudents', id]);

  }

  DeleteStudentDetails(event: any, id: number) {

    if (confirm('Are you sure do you want to delete this data ?'))

      event.target.innerText = 'Deleting...';

    this.studentService.deleteStudentById(id).subscribe((data: any) => {
     this.getStudents();

    })
  }

  showDetails(id:number){

  this.router.navigate(['/student-details',id])

  }

  }

