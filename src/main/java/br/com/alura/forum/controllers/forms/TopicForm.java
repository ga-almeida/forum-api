package br.com.alura.forum.controllers.forms;

import br.com.alura.forum.models.Course;
import br.com.alura.forum.models.Topic;
import br.com.alura.forum.repositories.CoursesRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicForm {

    private String title;
    private String message;
    private String nameCourse;

    public Topic convert(CoursesRepository coursesRepository) {
        Course course = coursesRepository.findByName(nameCourse);
        return new Topic(title, message, course);
    }
}
