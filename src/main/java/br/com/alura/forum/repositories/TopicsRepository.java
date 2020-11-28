package br.com.alura.forum.repositories;

import br.com.alura.forum.models.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByCourseName(String nameCourse, Pageable pageable);
}
