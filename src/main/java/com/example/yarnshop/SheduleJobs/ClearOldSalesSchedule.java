package com.example.yarnshop.SheduleJobs;

import com.example.yarnshop.service.SaleService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClearOldSalesSchedule {
    private final SaleService saleService;

    public ClearOldSalesSchedule(SaleService saleService) {
        this.saleService = saleService;
    }

    @Scheduled(cron = "0 0 * * * ?")
    public void doInBackground(){
        this.saleService.deleteOldOrders ();
    }
}
