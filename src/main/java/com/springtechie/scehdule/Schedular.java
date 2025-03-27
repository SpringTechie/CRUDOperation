package com.springtechie.scehdule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {


    // we have to run this method for every 5 seconds.
    // fixedRate : run every 5 seconds irrespective of job completed or not.
    // fixedDelay : waits for 5 seconds, when job is completed.

     @Scheduled(fixedDelayString= "5000000",initialDelay = 10000)

    public void run() {
        System.out.println("Hello Spring Techie");
    }
}
