    import { HttpClient } from "@angular/common/http";
    import { Injectable } from "@angular/core";
    import { Student } from "./student";
  

    @Injectable({
        providedIn:'root'
    })
    export class StudentService {


        API="http://localhost:5000/api";

        constructor(private httpClient:HttpClient){}

    
        getStudentsList(){

            return this.httpClient.get(this.API + '/get/students');
        }

        createStudent(student:Student){
            
            return this.httpClient.post(this.API + "/post/students",student);

        }

        getStudentById(id:number)
        {
            return this.httpClient.get(`http://localhost:5000/api/get/students/${id}`);

        }

        updateStudentById(id:number,student:Student){

        return this.httpClient.put(this.API + `/update/students/${id}`,student);

        }

        deleteStudentById(id:number){
            return this.httpClient.delete(this.API + `/delete/students/${id}`);
        }

        
          
  

    }
