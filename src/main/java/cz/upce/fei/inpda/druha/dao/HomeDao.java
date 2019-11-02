package cz.upce.fei.inpda.druha.dao;

import cz.upce.fei.inpda.druha.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeDao extends JpaRepository<Home, Long> {

}
