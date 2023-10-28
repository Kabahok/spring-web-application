package org.egoravdeev.controller;


import org.egoravdeev.model.Post;
import org.egoravdeev.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> all() throws IOException {
        return service.all();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable long id) throws IOException {
        return service.getById(id);
    }


    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) throws IOException {
        service.removeById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) throws IOException {
        return service.save(post);
    }
}
