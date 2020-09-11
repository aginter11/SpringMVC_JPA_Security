package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String listUsers(ModelMap model) {
        model.addAttribute("listUsers", userService.listUsers());
        return "users";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);

        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "addPage";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getUserbyId(id);
        model.addAttribute("user", user);
        return "editPage";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserbyId(id));

        return "userdata";
    }
}
