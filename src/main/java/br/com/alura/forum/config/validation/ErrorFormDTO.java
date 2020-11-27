package br.com.alura.forum.config.validation;

import lombok.Getter;

@Getter
public class ErrorFormDTO {

    private String field;
    private String error;

    public ErrorFormDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }
}
