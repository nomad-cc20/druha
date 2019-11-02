package cz.upce.fei.inpda.druha.controller;

import cz.upce.fei.inpda.druha.dto.CredentialsDto;
import cz.upce.fei.inpda.druha.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
