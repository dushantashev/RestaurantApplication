//package mk.ukim.finki.wp.labs.web;
//
//import mk.ukim.finki.wp.labs.model.User;
//import mk.ukim.finki.wp.labs.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String getUsersPage(Model model){
//        model.addAttribute("users", userService.findAll());
//        return "users"; // users.html view
//    }
//
//    @GetMapping("/add")
//    public String addUserPage() {
//        return "add-user"; // add-user.html form
//    }
//
//    @PostMapping("/add")
//    public String saveUser(@RequestParam String username,
//                           @RequestParam String password,
//                           @RequestParam String name,
//                           @RequestParam String surname,
//                           @RequestParam String role){
//
//        userService.save(username, password, name, surname, role);
//        return "redirect:/users";
//    }
//
//    @PostMapping("/delete/{username}")
//    public String deleteUser(@PathVariable String username){
//        userService.deleteByUsername(username);
//        return "redirect:/users";
//    }
//}
