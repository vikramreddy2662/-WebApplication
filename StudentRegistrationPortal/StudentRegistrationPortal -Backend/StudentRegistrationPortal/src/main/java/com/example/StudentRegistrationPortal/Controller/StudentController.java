package com.example.StudentDataStorage.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentDataStorage.Entity.Student;
import com.example.StudentDataStorage.Repository.StudentRepo;

@RestController
@RequestMapping("/api")

public class StudentController {

	@Autowired
	StudentRepo studentrepo;

	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/post/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		// System.out.println(student);

		return new ResponseEntity<>(studentrepo.save(student), HttpStatus.CREATED);
	}

	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/get/students")
	public ResponseEntity<List<Student>> getStudentSDetails() {
		return new ResponseEntity<>(studentrepo.findAll(), HttpStatus.OK);
	}

	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/get/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {

		Optional<Student> student = studentrepo.findById(id);

		if (student.isPresent()) {
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@CrossOrigin("http://localhost:4200/")
	@PutMapping("/update/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student stud) {

		Optional<Student> student = studentrepo.findById(id);

		if (student.isPresent()) {
			student.get().setFirstname(stud.getFirstname());
			student.get().setLastname(stud.getLastname());
			student.get().setMobilenumber(stud.getMobilenumber());
			student.get().setCollege(stud.getCollege());
			student.get().setEmail(stud.getEmail());
			student.get().setCoursename(stud.getCoursename());
			student.get().setCourseFee(stud.getCourseFee());
			

			return new ResponseEntity<Student>(studentrepo.save(student.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

	}

	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("delete/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id) {
		Optional<Student> student = studentrepo.findById(id);

		if (student.isPresent()) {
			studentrepo.deleteById(id);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);

		} else {
			return new ResponseEntity<Map<String, Boolean>>(HttpStatus.NOT_FOUND);
		}

	}

}
