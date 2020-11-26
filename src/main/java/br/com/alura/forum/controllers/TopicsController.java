package br.com.alura.forum.controllers;

import br.com.alura.forum.controllers.dtos.TopicDTO;
import br.com.alura.forum.models.Course;
import br.com.alura.forum.models.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    @RequestMapping("/topics")
    @ResponseBody
    public List<TopicDTO> list() {
        Topic topic =
                new Topic("Duvida", "Duvida com Spring",
                        new Course("Spring", "Programação"));

        return TopicDTO.convete(Arrays.asList(topic, topic, topic));
    }
}
