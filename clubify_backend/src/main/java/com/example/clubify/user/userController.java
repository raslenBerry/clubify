package com.example.clubify.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping("/users")
    public class userController {

        @Autowired
        private userService userService;
    @Autowired
    private userRepository userRepository;

        @GetMapping("/all")
        public ResponseEntity<List<user>> getAllUsers() {
            List<user> users = userService.findAllUser();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<user> getUserById(@PathVariable Long id) {
            return userRepository.findById(id)
                    .map(user -> ResponseEntity.ok(user))
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping("/add")
        public ResponseEntity<user> addUser(@RequestBody user user) {
            user newUser = userService.addUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<user> updateUser(@RequestBody user user) {
            user updateUser = userService.updateUser(user);
            return new ResponseEntity<>(updateUser, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteUser(@PathVariable("phone") Long phone) {
            userService.deleteUser(phone);
            return new ResponseEntity<>(HttpStatus.OK);
        }



    }
