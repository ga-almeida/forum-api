package br.com.alura.forum.controllers.forms;

import br.com.alura.forum.models.Course;
import br.com.alura.forum.models.Topic;
import br.com.alura.forum.repositories.CoursesRepository;
import br.com.alura.forum.repositories.TopicsRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdatedTopicForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;

    @NotNull @NotEmpty @Length(min = 5)
    private String message;


    public Topic update(Long id, TopicsRepository topicsRepository) {
        Topic topic = topicsRepository.getOne(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);
        return topic;
    }
}
