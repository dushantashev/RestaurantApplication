//package mk.ukim.finki.wp.labs.web;
//
//
//
//
//import mk.ukim.finki.wp.labs.service.AuthService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/register")
//public class RegisterController {
//    private final AuthService authService;
//
//    public RegisterController(AuthService authService) {
//        this.authService = authService;
//    }
//
//
//
//    @PostMapping
//    public String register(@RequestParam String name,
//                           @RequestParam String surname,
//                           @RequestParam String username,
//                           @RequestParam String password,
//                           @RequestParam String repeatPassword,
//                           @RequestParam String role,
//                           Model model) {
//
//
//            this.authService.register(username, password, repeatPassword, name, surname,role);
//            return "redirect:/login";
//
//
//
//    }
//
//}
