package com.project.salmonDemo.classes;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppInfo {
    @Value("${app.fake-price}")
    int fakePrice;
    public void printInfo() {
        System.out.println(fakePrice);
    }

}
