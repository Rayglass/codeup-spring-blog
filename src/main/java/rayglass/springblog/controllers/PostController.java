package rayglass.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import rayglass.springblog.models.Post;
import rayglass.springblog.repositories.PostRepository;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
//        List<Post> allPosts = new ArrayList<>();
//        allPosts.add(new Post("Post 1", "This is a test."));
//        allPosts.add(new Post("Post 2", "Second post to test."));
//        model.addAttribute("allPosts", allPosts);
        return "/posts/index";
    }


    @GetMapping("/posts/show")
    public String onePost(Model model) {
        Post freshPost = new Post("Look", "This is a post");
        model.addAttribute("freshPost", freshPost);
        return "/posts/show";
    }


    @GetMapping("/posts/create")
    public String showPostForm() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "postTitle") String postTitle, @RequestParam(name = "postBody") String postBody, Model model) {
        Post newPost = new Post();
        newPost.setTitle(postTitle);
        newPost.setBody(postBody);
        model.addAttribute("newPost", newPost);
        model.addAttribute("adding", postDao.save(newPost));
        return "redirect:/posts";
    }
}