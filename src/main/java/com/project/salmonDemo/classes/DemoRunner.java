package com.project.salmonDemo.classes;

import com.project.salmonDemo.interfaces.DbProductRepository;
import com.project.salmonDemo.interfaces.PriceParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoRunner implements CommandLineRunner {
    private final AppInfo appInfo;
    private final DbProductRepository repo;

    public DemoRunner(AppInfo appInfo, DbProductRepository repo) {
        this.appInfo = appInfo;
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        appInfo.printInfo();

        repo.save(new DbProduct("dms", 1212, "https://fake-shop.com/1"));
        for (DbProduct p : repo.findAll()) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        List<PriceParser> parsers = new ArrayList<>();
        parsers.add(new FakeParser());
        parsers.add(new OtherParser());

        for (DbProduct p : repo.findAll()) {

            PriceParser chosen = null;

            for (PriceParser parser : parsers) {
                if (parser.supports(p.getUrl())) {
                    chosen = parser;
                    break;
                }
            }

            if (chosen == null) {
                continue;
            }

            int newPrice = chosen.parse(p.getUrl());

            if (newPrice < p.getPrice()) {
                System.out.println("price decreased " + p.getPrice() + " to " + newPrice);
            }

            p.setPrice(newPrice);
            repo.save(p);
        }

        for (DbProduct p : repo.findAll()) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

    }
}
