package cz.upce.fei.inpda.druha.util;

import cz.upce.fei.inpda.druha.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaCtl {

    @Autowired
    private HomeDao homeDao;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedRateTaskAsync() {
        homeDao.findAll().forEach(home -> {
            home.step();
            homeDao.save(home);
        });
    }

}