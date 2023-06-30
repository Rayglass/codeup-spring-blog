package rayglass.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import rayglass.springblog.models.Post;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/post")
    public String post(Model model){
        model.addAttribute("post", new Post("Hello", "Hello World"));
        return "/posts/index";
    }

    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Hello", "Hello World"));
        posts.add(new Post("Hello Part 2", "Hello World Again :)"));
        model.addAttribute("posts",posts);
        return "/posts/show";
    }



    @GetMapping("/posts/{id}")
    public String showPost(Model model) {
        Post post = new Post("Sample Post", "This is a sample post.");

        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String insert() {
        return "view the form for creating a post!";
    }

    @PostMapping("/create")
    @ResponseBody
    public String saveNewPost() {
        return "submit new post";
    }
}
