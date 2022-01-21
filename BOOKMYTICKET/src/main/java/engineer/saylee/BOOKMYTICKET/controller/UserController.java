package engineer.saylee.BOOKMYTICKET.controller;

import engineer.saylee.BOOKMYTICKET.entity.Movie;
import engineer.saylee.BOOKMYTICKET.entity.User;
import engineer.saylee.BOOKMYTICKET.service.MovieService;
import engineer.saylee.BOOKMYTICKET.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    //Home Page
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String loginForm(){
        return "login";
    }

    @RequestMapping("/register")
    public String registerForm(){
        return "register";
    }
    @RequestMapping("profile")
    public String user(){
        return "profile";
    }

    @PostMapping("/login")
    public String registration(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");;

        User user = new User(username,password,name,email);
        userService.save(user);
        return "login";
    }


    @GetMapping("/movies")
    public String movies(){
        return "movies";
    }

    @PostMapping("/movies")
    public String login(Model model, HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
        if (userService.existsById(username) == true) {
            user = userService.findByUsername(username);
            if (password.equals(user.getPassword())) {
                model.addAttribute("userName", username);
                model.addAttribute("movies", movieService.movieList() );
               // User user1 = userService.findByUsername(username);

            } else {
                model.addAttribute("errorMessage", "Incorrect Password.");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Please enter valid Username");
            return "login";
        }
        return "movies";
    }

//    @RequestMapping("profile/{userId}")
//    public String displayUserById(@PathVariable String userId, Model model) {
//        model.addAttribute("name", userService.findByUsername(userId).getName());
//        model.addAttribute("username", userService.findByUsername(userId).getUsername());
//        model.addAttribute("email", userService.findByUsername(userId).getEmail());
//        return "profile";
//    }
    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model){
     //   model.addAttribute("shows", userService.findByUsername(username));
        User user= userService.findByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }
}
