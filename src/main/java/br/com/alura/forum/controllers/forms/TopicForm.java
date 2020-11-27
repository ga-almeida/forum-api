package br.com.alura.forum.controllers.forms;

import br.com.alura.forum.models.Course;
import br.com.alura.forum.models.Topic;
import br.com.alura.forum.repositories.CoursesRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TopicForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;

    @NotNull @NotEmpty @Length(min = 5)
    private String message;

    @NotNull @NotEmpty
    private String course;

    public Topic convert(CoursesRepository coursesRepository) {
        Course course = coursesRepository.findByName(this.course);
        return new Topic(title, message, course);
    }
}
