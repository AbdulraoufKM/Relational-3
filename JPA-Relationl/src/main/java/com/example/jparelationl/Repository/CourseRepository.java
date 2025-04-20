package com.example.jparelationl.Repository;

import com.example.jparelationl.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);

    @Query("select c from Course c where c.id=?1")
    Course teacherNameByCourseId(Integer courseId);
}
