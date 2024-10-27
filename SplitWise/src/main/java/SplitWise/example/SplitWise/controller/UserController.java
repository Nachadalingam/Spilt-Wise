package SplitWise.example.SplitWise.controller;

import SplitWise.example.SplitWise.Exception.*;
import SplitWise.example.SplitWise.dto.LoginAllowRequest;
import SplitWise.example.SplitWise.dto.LoginRequestDto;
import SplitWise.example.SplitWise.dto.LoginResponseDto;
import SplitWise.example.SplitWise.dto.SuccessFullyLogged;
import SplitWise.example.SplitWise.models.User;
import SplitWise.example.SplitWise.serviceInterface.UserService;
import jakarta.persistence.Cache;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/Signup")
    public ResponseEntity createUser(LoginRequestDto requestDto)
    {
        try {
            userService.adduser(requestDto);
            return ResponseEntity.ok(new LoginResponseDto("SuccessFully Created User Account"));
        } catch (EmailNotFoundException e) {
            return ResponseEntity.ok(new LoginResponseDto("Email Not found"));
        }catch (NameNotFoundException e)
        {
            return ResponseEntity.ok(new LoginResponseDto("Name Not found"));
        }
        catch (PasswordNotFoundException e)
        {
            return ResponseEntity.ok(new LoginResponseDto("Password Not found"));
        }

    }
    @GetMapping("/Login")
    public ResponseEntity loginTOUser(LoginAllowRequest loginAllowRequest) throws UserNotFoundException {
        try {
            userService.verifyUser(loginAllowRequest);
            return ResponseEntity.ok(new SuccessFullyLogged("User Login Successful!"));
        }
        catch(UserNotFoundException | PasswordMisMatchException e) {
            return ResponseEntity.ok(new SuccessFullyLogged("User Details Not found  OR Password MisMatch"));
        }
    }

}
