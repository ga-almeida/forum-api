package br.com.alura.forum.controllers.dtos;

import br.com.alura.forum.models.Response;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ResponseDTO {

    private Long id;
    private String message;
    private LocalDateTime dateCreated;
    private String nameAuthor;

    public ResponseDTO(Response response) {
        this.id = response.getId();
        this.message = response.getMessage();
        this.dateCreated = response.getDateCreated();
        this.nameAuthor = response.getAuthor().getName();
    }
}
