package br.com.alura.forum.models;

import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
