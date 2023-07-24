package com.example.ExpanseTracker.controller;


import com.example.ExpanseTracker.model.User;
import com.example.ExpanseTracker.model.dto.SignInInput;
import com.example.ExpanseTracker.model.dto.SignUpOutput;
import com.example.ExpanseTracker.service.AuthenticationService;
import com.example.ExpanseTracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    //add patient
    @PostMapping("user/signUp")
    public SignUpOutput signUpUser(@RequestBody User user){
        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String signInUser(@RequestBody @Valid SignInInput signInInput){
        return userService.signInUser(signInInput);
    }


    //get total expenditure according to months
    @GetMapping("expenditure/year/{year}/month/{month}")
    public String getExpenditureByMonth(@PathVariable Integer year, @PathVariable Integer month, @RequestParam String email, @RequestParam String token){
        if(authenticationService.authenticate(email,token)) {
            return userService.getExpenditureByMonth(year,month,email);
        }
        else {
            return "not a authenticate user activity";
        }
    }

}
