package br.com.alura.forum.repositories;

import br.com.alura.forum.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    Course findByName(String nameCourse);
}
