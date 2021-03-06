package br.com.alura.forum.controllers.dtos;

import br.com.alura.forum.models.Topic;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateCreated;

    public TopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateCreated = topic.getDateCreated();
    }

    public static Page<TopicDTO> convert(Page<Topic> topics) {
        return topics.map(TopicDTO::new);
    }
}
