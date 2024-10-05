package com.example.clubify.user;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:59687")
@RequestMapping("/log")
@RestController
public class authentController {
  @Autowired
  private userService userService;
  @Autowired
  private userRepository userRepository;
  @PostMapping("/signin")
  public ResponseEntity<?> login(@RequestBody user loginUser) {
    user user = userService.signIn(loginUser);

    if (user != null) {
      // Login successful
      // Return the user object as JSON
      return ResponseEntity.ok().body(user);
    } else {
      // Login failed
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }
  }

}
