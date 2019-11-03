package cz.upce.fei.inpda.druha.util;

import cz.upce.fei.inpda.druha.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
public class ClimaCtl {

    @Autowired
    private HomeDao homeDao;

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        homeDao.findAll().forEach(home -> home.step());
    }

}