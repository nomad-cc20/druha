package cz.upce.fei.inpda.druha.dto;

import cz.upce.fei.inpda.druha.entity.Cooler;
import cz.upce.fei.inpda.druha.entity.Heater;
import cz.upce.fei.inpda.druha.entity.Home;
import cz.upce.fei.inpda.druha.entity.User;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class HomeDto extends HomeForUserDto {

    private List<UserForHomeDto> users;
    private Cooler cooler;
    private Heater heater;
    private List<RoomDto> rooms;

    public HomeDto(long id, List<User> users) {
        super(id);
        this.users = new LinkedList<>();
        users.forEach(user -> this.users.add(new UserForHomeDto(user)));
    }

    public HomeDto(Home home) {
        super(home.getId());
        this.users = new LinkedList<>();
        home.getUsers().forEach(user -> this.users.add(new UserForHomeDto(user)));
        this.rooms = new LinkedList<>();
        home.getRooms().forEach(room -> this.rooms.add(new RoomDto(room)));
        this.cooler = home.getCooler();
        this.heater = home.getHeater();
    }

    public List<UserForHomeDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserForHomeDto> users) {
        this.users = users;
    }
}
