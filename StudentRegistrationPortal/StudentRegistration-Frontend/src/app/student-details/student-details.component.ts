import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../student';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrl: './student-details.component.css'
})
export class StudentDetailsComponent {

id:number;
student:Student;

constructor(private studentService:StudentService,private router:Router,private route:ActivatedRoute){}

ngOnInit():void{

  this.id=this.route.snapshot.params['id'];
  this.student=new Student();

  this.studentService.getStudentById(this.id).subscribe((data:any)=>{
    this.student=data;
  })





}




}
