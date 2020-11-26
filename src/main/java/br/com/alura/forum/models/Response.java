package br.com.alura.forum.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Response {

    private Long id;
    private String message;
    private Topic topic;
    private LocalDateTime dateCreated;
    private User author;
    private Boolean solution = false;

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
