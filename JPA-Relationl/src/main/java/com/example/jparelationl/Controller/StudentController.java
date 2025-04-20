package com.example.jparelationl.Controller;

import com.example.jparelationl.Api.ApiException;
import com.example.jparelationl.Api.ApiResponse;
import com.example.jparelationl.Model.Course;
import com.example.jparelationl.Model.Student;
import com.example.jparelationl.Repository.CourseRepository;
import com.example.jparelationl.Repository.StudentRepository;
import com.example.jparelationl.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody@Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("is deleted"));
    }

    @PostMapping("/add-course/{studentId}/{courseId}")
    public ResponseEntity assignCourse(@PathVariable Integer studentId, @PathVariable Integer courseId){
        studentService.assignCourse(studentId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("course is assigned"));
    }

    @PutMapping("/change-major/{studentId}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer studentId, @PathVariable String major){
        studentService.changeMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("major is changed"));
    }
}
