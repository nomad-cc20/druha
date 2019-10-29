package cz.upce.fei.inpda.druha.dto;

public class HomeForUserDto {

    private long id;
    private int roomsCount;

    public HomeForUserDto(long id, int roomsCount) {
        this.id = id;
        this.roomsCount = roomsCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }
}
