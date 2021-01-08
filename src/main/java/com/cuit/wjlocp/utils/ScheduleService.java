package com.cuit.wjlocp.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduleService {

    @Scheduled(cron = "0 0 6 * * ?")
    public void clearCacheMap(){
        CacheMapUtil.getInstance().clear();
        if(CacheMapUtil.getInstance().size() == 0){
            System.out.println("服务器缓存已清空……");
        }
    }
}
