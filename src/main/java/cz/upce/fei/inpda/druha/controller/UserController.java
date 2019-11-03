package cz.upce.fei.inpda.druha.controller;

import cz.upce.fei.inpda.druha.dto.CredentialsDto;
import cz.upce.fei.inpda.druha.dto.UserDto;
import cz.upce.fei.inpda.druha.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "user api", description = "User controller")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("Creates a new user.")
    @PostMapping("register")
    public void add(@RequestBody CredentialsDto user) {
        this.userService.create(user);
    }

    @ApiOperation("Logs the user in.")
    @PostMapping("login")
    public String login(@RequestBody CredentialsDto credentialsDto) {
        return this.userService.authorize(credentialsDto);
    }

    @ApiOperation("Creates a new home for the user.")
    @GetMapping("inhabit")
    public void inhabit(@RequestHeader(value="Authorization") String token) {
        userService.addHome(userService.readByToken(token).getId());
    }
}
