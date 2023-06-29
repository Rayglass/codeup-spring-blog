package rayglass.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "Posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable long id) {
        return "Viewing post with the id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "view the form for creating a post!";
    }

    @PostMapping("/post/create")
    @ResponseBody
    public String submitPost() {
        return "submit new post";
    }
}
