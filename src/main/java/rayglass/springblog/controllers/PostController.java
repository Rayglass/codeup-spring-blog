package rayglass.springblog.controllers;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import rayglass.springblog.models.EmailService;
import rayglass.springblog.models.Post;
import rayglass.springblog.models.User;
import rayglass.springblog.repositories.PostRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rayglass.springblog.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@Controller
public class PostController {
    private final PostRepository postsDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository userDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")

    public String viewPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.findById(id).get());
        return "posts/show";

    }


    @GetMapping("/posts/create")
    public String showPostForm(Model model) {
        //// Send a new Post object to the form, so we can find the inputs to the fields
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String submitNewPost(@ModelAttribute Post post) {
        emailService.prepareAndSend(post, "New Post Created!", post.getBody());
        postsDao.save(post);

        return "redirect:/posts";

    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model) {
        // show categories in form
        Post post = postsDao.findById(id).get();
        model.addAttribute("post", post);
        return "/posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post, @PathVariable long id) {
        post.setId(id);
        postsDao.save(post);
        return "redirect:/posts";
    }
}