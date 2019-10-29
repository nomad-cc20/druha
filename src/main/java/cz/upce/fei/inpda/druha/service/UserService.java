package cz.upce.fei.inpda.druha.service;

import cz.upce.fei.inpda.druha.dao.UserDao;
import cz.upce.fei.inpda.druha.dto.CredentialsDto;
import cz.upce.fei.inpda.druha.dto.HomeForUserDto;
import cz.upce.fei.inpda.druha.dto.UserDto;
import cz.upce.fei.inpda.druha.dto.UserForHomeDto;
import cz.upce.fei.inpda.druha.entity.User;
import cz.upce.fei.inpda.druha.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HomeService homeService;

    private JwtUtil jwtUtil = new JwtUtil();

    public void create(CredentialsDto user) {
        userDao.save(user);
    }

    public UserDto readById(long id) {
        if (userDao.existsById(id))
            return map(userDao.findById(id).get());
        else
            throw new NoSuchElementException("No such user.");
    }

    public List<UserDto> readAll() {
        List<UserDto> users = new LinkedList<>();
        userDao.findAll().forEach((User user) -> users.add(map(user)));
        return users;
    }

    public void update(User user) {
        userDao.save(user);
    }

    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    private UserDto map(User user) {
        UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getPassword());
        this.homeService.readByUserId(user.getId()).forEach(homeDto -> userDto.getHomes().add(new HomeForUserDto(homeDto.getId(), homeDto.getRoomsCount())));
        return userDto;
    }

    UserForHomeDto readUserForHome(long id) {
        return (userDao.existsById(id) ? new UserForHomeDto(userDao.findById(id)) : null);
    }

    public String authorize(CredentialsDto credentialsDto) {
        User user = userDao.findByCredentials(credentialsDto);
        return (user == null ? "" : jwtUtil.generateToken(user));
    }
}
