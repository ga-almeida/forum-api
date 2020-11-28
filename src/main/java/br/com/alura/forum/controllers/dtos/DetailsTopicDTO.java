package br.com.alura.forum.controllers.dtos;

import br.com.alura.forum.models.Response;
import br.com.alura.forum.models.StatusTopic;
import br.com.alura.forum.models.Topic;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DetailsTopicDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateCreated;
    private String nameAuthor;
    private StatusTopic status;
    private List<ResponseDTO> responses;

    public DetailsTopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateCreated = topic.getDateCreated();
        this.nameAuthor = topic.getAuthor().getName();
        this.status = topic.getStatus();
        this.responses = new ArrayList<>();
        this.responses.addAll(topic
                .getResponses()
                .stream()
                .map(ResponseDTO::new)
                .collect(Collectors.toList()));
    }
}
