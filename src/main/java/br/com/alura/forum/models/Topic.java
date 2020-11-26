package br.com.alura.forum.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
public class Topic {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateCreated;
    private StatusTopic status = StatusTopic.NOT_RESPONSE;
    private User author;
    private Course course;
    private List<Response> responses = new ArrayList<>();

    public Topic(String title, String message, Course course) {
        this.title = title;
        this.message = message;
        this.course = course;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
