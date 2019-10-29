package cz.upce.fei.inpda.druha.dto;

public class OwnershipDto {

    private long homeId;
    private long userId;

    public OwnershipDto(long homeId, long userId) {
        this.homeId = homeId;
        this.userId = userId;
    }

    public long getHomeId() {
        return homeId;
    }

    public void setHomeId(long homeId) {
        this.homeId = homeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
