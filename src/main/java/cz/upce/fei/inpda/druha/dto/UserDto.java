package cz.upce.fei.inpda.druha.dto;

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

    public List<HomeForUserDto> getHomes() {
        return homes;
    }

    public void setHomes(List<HomeForUserDto> homes) {
        this.homes = homes;
    }
}
