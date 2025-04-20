package com.example.jparelationl.Service;

import com.example.jparelationl.Api.ApiException;
import com.example.jparelationl.Model.Course;
import com.example.jparelationl.Model.Student;
import com.example.jparelationl.Model.Teacher;
import com.example.jparelationl.Repository.CourseRepository;
import com.example.jparelationl.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void assignCourseWithTeacher(Integer courseId, Integer teacherId){
        Course course = courseRepository.findCourseById(courseId);
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (course == null){
            throw new ApiException("Course not found");
        }
        if (teacher == null){
            throw new ApiException("Teacher not found");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void updateCourse(Course course, Integer courseId){
        Course oldCourse = courseRepository.findCourseById(courseId);
        if (oldCourse == null){
            throw new ApiException("Course not found");
        }

        oldCourse.setName(course.getName());
        oldCourse.setTeacher(course.getTeacher());

        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null){
            throw new ApiException("course not found");
        }

        courseRepository.delete(course);
    }

    public String teacherNameByCourse(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null){
            throw new ApiException("course not found");
        }

        return course.getTeacher().getName();
    }

    public void assignCourse(Integer courseId, Integer teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);
        if (teacher==null||course==null) {
            throw new ApiException("course or teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String getTeacherName(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course==null) {
            throw new ApiException("course not found");
        }
        return course.getTeacher().getName();
    }

    public Set<Student> getAllStudents(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course==null) {
            throw new ApiException("course not found ");
        }

        return course.getStudent();
    }
}
