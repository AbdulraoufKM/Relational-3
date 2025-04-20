package com.example.jparelationl.Service;

import com.example.jparelationl.Api.ApiException;
import com.example.jparelationl.Model.Course;
import com.example.jparelationl.Model.Student;
import com.example.jparelationl.Repository.CourseRepository;
import com.example.jparelationl.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer studentId, Student student){
        Student oldStudent = studentRepository.findStudentById(studentId);
        if (oldStudent==null) {
            throw new ApiException("student Not found");
        }
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());
        oldStudent.setName(student.getName());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer studentId){
        Student student = studentRepository.findStudentById(studentId);
        if (student==null) {
            throw new ApiException("student not found");
        }

        studentRepository.delete(student);
    }

    public void assignCourse(Integer studentId, Integer course_id){
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(course_id);
        if (student==null) {
            throw new ApiException("student not found");
        }
        if (course==null) {
            throw new ApiException("course not found");
        }
        student.getCourses().add(course);
        course.getStudent().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeMajor(Integer studentId, String major){
        Student student = studentRepository.findStudentById(studentId);
        if (student==null) {
            throw new ApiException("student not found");
        }
        student.setMajor(major);
        student.setCourses(null);
        studentRepository.save(student);
    }
}

