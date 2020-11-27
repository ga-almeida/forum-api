package br.com.alura.forum.controllers;

import br.com.alura.forum.controllers.dtos.TopicDTO;
import br.com.alura.forum.controllers.forms.TopicForm;
import br.com.alura.forum.models.Topic;
import br.com.alura.forum.repositories.CoursesRepository;
import br.com.alura.forum.repositories.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicsRepository topicsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping
    public List<TopicDTO> list(String nameCourse) {
        if ("".equals(nameCourse) || nameCourse == null) {
            List<Topic> topics = this.topicsRepository.findAll();
            return TopicDTO.convert(topics);
        } else {
            List<Topic> topics = this.topicsRepository.findByCourseName(nameCourse);
            return TopicDTO.convert(topics);
        }

    }

    @PostMapping
    public ResponseEntity<TopicDTO> insert(@RequestBody @Valid TopicForm form) {
        Topic topic = form.convert(coursesRepository);
        this.topicsRepository.save(topic);

        return ResponseEntity
                .created(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/")
                    .path(topic.getId().toString()).build().toUri())
                .body(new TopicDTO(topic));
    }
}
