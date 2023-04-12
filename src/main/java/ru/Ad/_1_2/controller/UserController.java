package ru.Ad._1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.Ad._1_2.Service.UserService;
import ru.Ad._1_2.models.User;

@Controller
@RequestMapping("/User")
public class UserController {
private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("users", userService.showALL());
        return "/showAll";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showOne(id));
        return "/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/User";

    }
@GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showOne(id));
        return "/edit";
}

@PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id ){
        userService.update(id,user);
        return "redirect:/User";
}
@DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id ){
        userService.delete(id);
        return "redirect:/User";
}

}
