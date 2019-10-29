package cz.upce.fei.inpda.druha.dto;

public class HomeDto extends HomeForUserDto {

    private UserForHomeDto user;

    public HomeDto(long id, int roomsCount, UserForHomeDto user) {
        super(id, roomsCount);
        this.user = user;
    }

    public UserForHomeDto getUser() {
        return user;
    }

    public void setUser(UserForHomeDto user) {
        this.user = user;
    }
}
