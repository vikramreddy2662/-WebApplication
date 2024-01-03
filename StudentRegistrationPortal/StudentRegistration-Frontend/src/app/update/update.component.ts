import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'update',
  templateUrl: './update.component.html',
  styleUrl: './update.component.css'
})
export class UpdateComponent {

  id: number;
  student: Student = new Student();

  constructor(private studentService: StudentService, private router: Router, private route: ActivatedRoute) { }


  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    this.studentService.getStudentById(this.id).subscribe((data: any) => {
      this.student = data;
      console.log(data);
    });
  }

  OnSubmitBtnClicked() {

    this.studentService.updateStudentById(this.id,this.student).subscribe((data:any)=>{
       this.getStudentsList();
    });}
           
    
    getStudentsList() {
      alert('Data updated Succesfully');
      this.router.navigate(['/students']);
    }

 }
