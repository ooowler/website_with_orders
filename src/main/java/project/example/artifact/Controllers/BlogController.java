package project.example.artifact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.example.artifact.models.Post;
import project.example.artifact.repo.PostRepository;

@Controller
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }


    @PostMapping("/")
    public String blogPostAdd(@RequestParam String FullName,
                              @RequestParam String group_number,
                              @RequestParam String message,
                              Model model) {
        Post post = new Post(FullName, group_number, message);
        postRepository.save(post);
        return "home";
    }

    @GetMapping("/edit")
    public String BlogEdit(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "edit";
    }

    @PostMapping("/edit")
    public String BlogUpdate(@PathVariable(value = "id") long id,
                             @RequestParam String FullName,
                             @RequestParam String group_number,
                             @RequestParam String message,
                             Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setFullName(FullName);
        post.setGroup_number(group_number);
        post.setMessage(message);
        postRepository.save(post);
        return "blog-main";
    }


}