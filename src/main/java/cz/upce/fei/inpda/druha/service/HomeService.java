package cz.upce.fei.inpda.druha.service;

import cz.upce.fei.inpda.druha.dao.HomeDao;
import cz.upce.fei.inpda.druha.dao.UserDao;
import cz.upce.fei.inpda.druha.dto.HomeDto;
import cz.upce.fei.inpda.druha.dto.OwnershipDto;
import cz.upce.fei.inpda.druha.entity.Home;
import cz.upce.fei.inpda.druha.entity.User;
import cz.upce.fei.inpda.druha.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HomeService {

    @Autowired
    private HomeDao homeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    private JwtUtil jwtUtil = new JwtUtil();

    public void create(Home home) {
        homeDao.save(home);
    }

    public HomeDto readById(long id) {
        if (homeDao.existsById(id))
            return map(homeDao.findById(id).get());
        else
            throw new NoSuchElementException("No such home.");
    }

    public List<HomeDto> readByToken(String token) {
        List<HomeDto> homes = new LinkedList<>();
        userDao.findById(jwtUtil.extractUserId(token)).get().getHomes().forEach((Home home) -> homes.add(map(home)));
        return homes;
    }

    public List<HomeDto> readByUserId(long userId) {
        List<HomeDto> homes = new LinkedList<>();
        userDao.findById(userId).get().getHomes().forEach((Home home) -> homes.add(map(home)));
        return homes;
    }

    public List<HomeDto> readAll() {
        List<HomeDto> homes = new LinkedList<>();
        homeDao.findAll().forEach((Home home) -> homes.add(map(home)));
        return homes;
    }

    public void setOwner(OwnershipDto ownership) {
        if (homeDao.existsById(ownership.getHomeId())) {
            Home home = homeDao.findById(ownership.getHomeId()).get();
            List<User> users = home.getUsers();
            users.add(userDao.getOne(ownership.getUserId()));
            home.setUsers(home.getUsers());
            homeDao.save(home);
        } else {
            throw new NoSuchElementException("No such home.");
        }
    }

    public void update(Home home) {
        homeDao.save(home);
    }

    public void deleteById(long id) {
        homeDao.deleteById(id);
    }

    private HomeDto map(Home home) {
        return new HomeDto(home.getId(), home.getRoomsCount(), homeDao.getOne(home.getId()).getUsers());
    }

}