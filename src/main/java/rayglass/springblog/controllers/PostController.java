package rayglass.springblog.controllers;
import org.springframework.security.core.context.SecurityContextHolder;
import rayglass.springblog.services.EmailService;
import rayglass.springblog.models.Post;
import rayglass.springblog.models.User;
import rayglass.springblog.repositories.PostRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rayglass.springblog.repositories.UserRepository;

import java.util.Optional;


@Controller
public class PostController {

    private final EmailService emailService;
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

//    @GetMapping("/posts")
//    public String viewPosts(Model model) {
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("posts", postDao.findAll());
//
//        System.out.println(loggedInUser.getEmail());
//        System.out.println(loggedInUser.getPassword());
//        System.out.println(loggedInUser.getUsername());
//
//        return "/posts/index";
//    }
//
//    @GetMapping("/posts/{id}")
//    public String onePost(@PathVariable Long id, Model model) {
//        Optional<Post> optionalPost = postDao.findById(id);
//        if (optionalPost.isEmpty()){
//            System.out.println("Can't find it!");
//        }
//        model.addAttribute("onePost", optionalPost.get());
//        User onePostUser = optionalPost.get().getUser();
//        model.addAttribute("onePostUserEmail", onePostUser.getEmail());
//
//        return "/posts/show";
//    }
//
//    @GetMapping("/posts/{id}/edit")
//    public String editPost(@PathVariable Long id, Model model) {
//        Post editingPost = postDao.findById(id).get();
//        model.addAttribute("editingPost", editingPost);
//        return "posts/edit";
//    }
//
//    @PostMapping("/posts/{id}/edit")
//    public String updatePost(@PathVariable Long id, @RequestParam(name = "postTitle") String postTitle, @RequestParam(name = "postBody") String postBody){
//        Post updatedPost = postDao.findById(id).get();
//        updatedPost.setTitle(postTitle);
//        updatedPost.setBody(postBody);
//        postDao.save(updatedPost);
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/posts/create")
//    public String showPostForm(Model model) {
//        model.addAttribute("newPost", new Post());
//        return "/posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String createPost(@ModelAttribute Post newPost) {
//        User user = userDao.findById(1L).get();
////      post is created from pulled params and user id set to post
//        newPost.setUser(user);
////      email sent to post creator
//        emailService.prepareAndSend(newPost, newPost.getTitle(), newPost.getBody());
////      post is saved to db
//        postDao.save(newPost);
////      redirected to all posts page
//        return "redirect:/posts";
//    }
//}

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("posts", postDao.findAll());
        //
        System.out.println(loggedInUser.getEmail());
        System.out.println(loggedInUser.getPassword());
        System.out.println(loggedInUser.getUsername());

        return "/posts/index";

    }


    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id).get());
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        emailService.prepareAndSend(post, "New Post Created!", post.getBody());
        postDao.save(post);



        return "redirect:/posts";

    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
        return "/posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post, @PathVariable long id) {
        post.setId(id);
        postDao.save(post);
        return "redirect:/posts";
    }
}