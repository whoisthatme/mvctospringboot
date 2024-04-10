package web.mvctospringboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.mvctospringboot.service.UserService;
import web.mvctospringboot.model.User;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());
        return "users";
    }


    @PostMapping("/add")
    public String addUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(User user) {
        userService.removeUserById((long) user.getId());
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById((long) id));
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
