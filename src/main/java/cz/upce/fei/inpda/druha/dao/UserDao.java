package cz.upce.fei.inpda.druha.dao;

import cz.upce.fei.inpda.druha.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

}
