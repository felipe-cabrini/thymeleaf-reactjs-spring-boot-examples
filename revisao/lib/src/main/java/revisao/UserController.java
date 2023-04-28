package revisao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UserController {
	 
	  private final UserService userService;

	    @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }
	    
	    @GetMapping("/index")
	    public String showUserList(Model model) {
	        model.addAttribute("users", userService.findAll());
	        return "index";
	    }
	    @GetMapping("/users")
	    public ResponseEntity<Iterable<User>> allUsers() {
	        return ResponseEntity.ok(userService.findAll());
	    }
	    
	    @GetMapping("/signup")
	    public String showSignUpForm(User user) {
	        return "add-user";
	    }
	    
	    @PostMapping("/adduser")
	    public String addUser(@Valid User user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-user";
	        }
	        
	        userService.save(user);
	        return "redirect:/index";
	    }
	    
	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        User user = userService.findUserById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        model.addAttribute("user", user);
	        
	        return "update-user";
	    }
	    
	    @PostMapping("/update/{id}")
	    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            user.setId(id);
	            return "update-user";
	        }
	        
	        userService.save(user);

	        return "redirect:/index";
	    }
	    
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") long id, Model model) {
	        User user = userService.findUserById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        userService.delete(user);
	        
	        return "redirect:/index";
	    }
}
