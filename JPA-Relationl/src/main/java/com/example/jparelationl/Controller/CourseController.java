package com.example.jparelationl.Controller;

import com.example.jparelationl.Api.ApiResponse;
import com.example.jparelationl.Model.Course;
import com.example.jparelationl.Repository.CourseRepository;
import com.example.jparelationl.Service.CourseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getAllCourses(){
           return ResponseEntity.status(200).body( courseService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course Added"));
    }

    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity<ApiResponse> assign(@PathVariable Integer courseId,@PathVariable Integer teacherId){
        courseService.assignCourseWithTeacher(courseId, teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Assigned to course"));
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<ApiResponse> updateCourse(@PathVariable Integer courseId, @RequestBody @Valid Course course ) {
        courseService.updateCourse(course,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }

    @GetMapping("teacher-By-Course/{courseId}")
    public ResponseEntity<String> teacherNameByCourseId(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(courseService.teacherNameByCourse(courseId));
    }



}
