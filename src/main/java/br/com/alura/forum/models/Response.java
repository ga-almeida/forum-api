package br.com.alura.forum.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    private Topic topic;
    private LocalDateTime dateCreated;

    @ManyToOne
    private User author;
    private Boolean solution = false;

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
