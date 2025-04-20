package com.example.jparelationl.Service;

import com.example.jparelationl.Api.ApiException;
import com.example.jparelationl.Model.Teacher;
import com.example.jparelationl.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }


    public void update(Integer id, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher== null){
            throw new ApiException("Customer not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());

        teacherRepository.save(oldTeacher);
    }




    public void delete(Integer id){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher == null){
            throw new ApiException("teacher not found");
        }
        teacherRepository.delete(oldTeacher);
    }

    public Teacher getTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("teacher not found");
        }
        return teacher;
    }



}
