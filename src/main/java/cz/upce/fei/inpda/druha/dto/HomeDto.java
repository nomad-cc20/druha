package cz.upce.fei.inpda.druha.dto;

import cz.upce.fei.inpda.druha.entity.User;

import java.util.LinkedList;
import java.util.List;

public class HomeDto extends HomeForUserDto {

    private List<UserForHomeDto> users;

    public HomeDto(long id, int roomsCount, UserForHomeDto user) {
        super(id, roomsCount);
        this.users = users;
    }

    public HomeDto(long id, int roomsCount, List<User> users) {
        super(id, roomsCount);
        this.users = new LinkedList<>();
        users.forEach(user -> this.users.add(new UserForHomeDto(user)));
    }

    public List<UserForHomeDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserForHomeDto> users) {
        this.users = users;
    }
}
