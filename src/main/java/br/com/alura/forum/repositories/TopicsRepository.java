package br.com.alura.forum.repositories;

import br.com.alura.forum.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByCourseName(String nameCourse);
}
