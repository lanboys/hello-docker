package com.bing.lan.docker.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloDockerController {

    public boolean runningFlag = true;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Docker";
    }

    @RequestMapping("/start")
    public String start() {
        runningFlag = true;
        new Thread(() -> {
            while (runningFlag) {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + " Hello Docker");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " end...");
        }).start();
        return "start success";
    }

    @RequestMapping("/end")
    public String end() {
        runningFlag = false;
        return "ending";
    }

    @RequestMapping("/status")
    public String status() {
        return String.valueOf(runningFlag);
    }

}