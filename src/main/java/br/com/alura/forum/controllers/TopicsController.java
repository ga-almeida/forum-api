package br.com.alura.forum.controllers;

import br.com.alura.forum.controllers.dtos.DetailsTopicDTO;
import br.com.alura.forum.controllers.dtos.TopicDTO;
import br.com.alura.forum.controllers.forms.TopicForm;
import br.com.alura.forum.controllers.forms.UpdatedTopicForm;
import br.com.alura.forum.models.Topic;
import br.com.alura.forum.repositories.CoursesRepository;
import br.com.alura.forum.repositories.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    private TopicsRepository topicsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping
    public Page<TopicDTO> list(@RequestParam(required = false) String nameCourse,
                               @PageableDefault(
                                       sort = "id",
                                       direction = Sort.Direction.ASC,
                                       page = 0,
                                       size = 10) Pageable page) {

        if ("".equals(nameCourse) || nameCourse == null) {
            Page<Topic> topics = this.topicsRepository.findAll(page);
            return TopicDTO.convert(topics);
        } else {
            Page<Topic> topics = this.topicsRepository.findByCourseName(nameCourse, page);
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

    @GetMapping("/{id}")
    public ResponseEntity<DetailsTopicDTO> details(@PathVariable Long id) {
        Optional<Topic> optional = this.topicsRepository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok(new DetailsTopicDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody @Valid UpdatedTopicForm form) {
        Optional<Topic> optional = this.topicsRepository.findById(id);

        if (optional.isPresent()) {
            Topic topic = form.update(id, this.topicsRepository);
            return ResponseEntity.ok(new TopicDTO(topic));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Topic> optional = this.topicsRepository.findById(id);

        if (optional.isPresent()) {
            this.topicsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
