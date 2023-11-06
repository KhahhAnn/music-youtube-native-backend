package vn.khahhann.musicyoutubebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.khahhann.musicyoutubebackend.entity.User;
import vn.khahhann.musicyoutubebackend.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody User user) {
        ResponseEntity<?> responseEntity = this.accountService.register(user);
        return responseEntity;
    }
    @GetMapping("/active/{email}/{activationCode}")
    public ResponseEntity<?> active(@PathVariable String email, @PathVariable String activationCode) {
        ResponseEntity<?> response = this.accountService.activeAccount(email, activationCode);
        return response;
    }
    @PostMapping("/sign-in")
    public ResponseEntity<?> loginUser(@Validated @RequestBody User user)  {
        ResponseEntity<?> response = this.accountService.signIn(user);
        return response;
    }
}
