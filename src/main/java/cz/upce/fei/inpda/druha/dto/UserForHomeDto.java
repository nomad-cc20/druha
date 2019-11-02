package cz.upce.fei.inpda.druha.dto;

import cz.upce.fei.inpda.druha.entity.User;

public class UserForHomeDto extends CredentialsDto {

    private long id;

    public UserForHomeDto(long id, String username, String password) {
        super(username, password);
        this.id = id;
    }

    public UserForHomeDto(User user) {
        this(user.getId(), user.getUsername(), user.getPassword());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
