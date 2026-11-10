package com.project.salmonDemo.interfaces;

public interface PriceParser {
    boolean supports(String Url);
    int parse(String url);
}

