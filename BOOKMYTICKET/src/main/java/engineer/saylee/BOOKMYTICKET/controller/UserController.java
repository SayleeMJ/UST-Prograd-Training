package engineer.saylee.BOOKMYTICKET.controller;

import engineer.saylee.BOOKMYTICKET.entity.User;
import engineer.saylee.BOOKMYTICKET.service.MovieService;
import engineer.saylee.BOOKMYTICKET.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    //Home Page
    @RequestMapping("/")
    public String home(Model model, HttpSession session){
        if(session.getAttribute("userName") != null){
            model.addAttribute("username", session.getAttribute("userName"));
        }
        return "home";
    }

    @RequestMapping("/login")
    public String loginForm(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/register")
    public String registerForm(){
        return "register";
    }

    @RequestMapping("/profile")
    public String user(){
        return "profile";
    }

    @PostMapping("/login")
    public String registration(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User(username,password,name,email);
        userService.save(user);
        return "login";
    }


    @RequestMapping("/movies")
    public String movies(Model model, HttpSession session){
        model.addAttribute("movies", movieService.movieList() );
        return "movies";
    }

    @PostMapping("/validateLogin")
    public String login(Model model, HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
        if (userService.existsById(username) == true) {
            user = userService.findByUsername(username);
            if (password.equals(user.getPassword())) {
                model.addAttribute("username", username);
                model.addAttribute("movies", movieService.movieList() );
                HttpSession session = request.getSession();
                session.setAttribute("userName", username);
                return "movies";
            } else {
                model.addAttribute("errorMessage", "Incorrect Password.");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Please enter valid Username");
            return "login";
        }
    }

    @RequestMapping("/userProfile")
    public String displayUserById(Model model, HttpSession session) {
        if(session.getAttribute("userName") != null) {
            String username = (String) session.getAttribute("userName");
            model.addAttribute("username", username);
            model.addAttribute("User", userService.findByUsername(username));
            return "userProfile";
        }else {
            return "login";
        }
    }

}
