package com.example.jparelationl.Controller;
import com.example.jparelationl.Api.ApiResponse;
import com.example.jparelationl.Model.Teacher;
import com.example.jparelationl.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.add(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody@Valid Teacher teacher){
        teacherService.update(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher is updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher is deleted"));
    }

    @GetMapping("/get-teacher-by/{id}")
    public ResponseEntity teacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacher(id));
    }

}
