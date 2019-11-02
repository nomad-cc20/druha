package cz.upce.fei.inpda.druha.controller;

import cz.upce.fei.inpda.druha.dto.HomeDto;
import cz.upce.fei.inpda.druha.dto.OwnershipDto;
import cz.upce.fei.inpda.druha.entity.Home;
import cz.upce.fei.inpda.druha.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "home api", description = "Home controller")
@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @ApiOperation("Reads user's homes.")
    @GetMapping("home")
    public List<HomeDto> get(@RequestHeader(value="Authorization") String token) {
        return homeService.readByToken(token);
    }

    @ApiOperation("Creates a new home.")
    @PostMapping("{roomsCount}")
    public void add() {
        homeService.create(new Home());
    }

    @ApiOperation("Sets ownership of the home to the specified user.")
    @PostMapping("home")
    public void setUserToHome(@RequestBody OwnershipDto ownership) {
        homeService.setOwner(ownership);
    }
}
