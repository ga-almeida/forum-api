package br.com.alura.forum.models;

import java.util.Objects;

public class Course {

    private Long id;
    private String name;
    private String category;

    public Course(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
