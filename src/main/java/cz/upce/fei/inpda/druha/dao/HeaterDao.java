package cz.upce.fei.inpda.druha.dao;

import cz.upce.fei.inpda.druha.entity.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaterDao extends JpaRepository<Heater, Long> {
}
