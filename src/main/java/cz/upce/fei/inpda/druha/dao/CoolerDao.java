package cz.upce.fei.inpda.druha.dao;

import cz.upce.fei.inpda.druha.entity.Cooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolerDao extends JpaRepository<Cooler, Long> {

}
