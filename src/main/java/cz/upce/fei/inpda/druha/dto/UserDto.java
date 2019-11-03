package cz.upce.fei.inpda.druha.dto;

import cz.upce.fei.inpda.druha.entity.User;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class UserDto extends UserForHomeDto {

    private List<HomeForUserDto> homes;

    public UserDto(long id, String username, String password) {
        super(id, username, password);
        this.homes = new LinkedList<>();
    }

    public UserDto(User user) {
        super(user.getId(), user.getUsername(), user.getPassword());
        this.homes = new LinkedList<>();
        user.getHomes().forEach(home -> this.homes.add(new HomeForUserDto(home.getId())));
    }

    public List<HomeForUserDto> getHomes() {
        return homes;
    }

    public void setHomes(List<HomeForUserDto> homes) {
        this.homes = homes;
    }
}
