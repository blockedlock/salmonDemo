package com.project.salmonDemo.classes;

import com.project.salmonDemo.interfaces.PriceParser;

public class FakeParser implements PriceParser {
    @Override
    public boolean supports(String url) {
        return url.contains("fake");
    }

    @Override
    public int parse(String url) {
        return 500;
    }


}
