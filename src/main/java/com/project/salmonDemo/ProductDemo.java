package com.project.salmonDemo;

import com.project.salmonDemo.classes.FakeParser;
import com.project.salmonDemo.classes.OtherParser;
import com.project.salmonDemo.classes.Product;
import com.project.salmonDemo.classes.ProductStorage;
import com.project.salmonDemo.interfaces.PriceParser;

import java.util.ArrayList;
import java.util.List;

public class ProductDemo {
    public static void main(String... args){
        String productName = "goida";
        int price = 102;
        printProduct(productName, price);
        printProduct("kurwa", 1000000000);
        int priceforcursor = 2000;
        int newPrice = calculateDiscount(priceforcursor,10);
        printProduct("ja pierdole", newPrice);

        if (newPrice < priceforcursor) {
            print("прайс упал");
        } else {
            print("точно не упал, хз такой же или нет ты же не встроил в меня определитель больше или также, смотри на логику программы");
        }

        Product p = new Product("dms",11,0, "https://fake-shop.com/1");
        Product p2 = new Product("dmws",111,1, "https://other-shop.com/2");

        List<Product> products = new ArrayList<>();

        products.add(p);
        products.add(p2);

        for (Product product : products) {
            System.out.println(product.name + " " + product.price);
        }

        Product first = products.getFirst();
        first.price = 0;

        products.remove(1);

        for (Product product : products) {
            System.out.println(product.name + " " + product.price);
        }

        ProductStorage storage = new ProductStorage();

        storage.addProSto(p);
        storage.addProSto(p2);

        storage.printProSto();
        storage.updatePriceProSto(0, 999);
        storage.printProSto();
//        storage.removeProSto(1);
        storage.printProSto();

        Product found = storage.findById(0);
        if (found != null) {
            found.price = 1212;
            print(found.name);
            printInt(found.price);
        }

        storage.printProSto();

        storage.printProSto();

        PriceParser parser = new FakeParser();
        if(parser.supports("https://fake-shop.com/item/1")) {
            printInt(parser.parse("https://fake-shop.com/item/1"));
        } else {print("idi nahui");}

        List<PriceParser> parsers = new ArrayList<>();
        parsers.add(new FakeParser());
        parsers.add(new OtherParser());

        storage.checkprices(parsers);
        storage.printProSto();
    }

    public static void print(String txt) {
        System.out.println(txt);
    }

    static void printInt(int txt) {
        System.out.println(txt);
    }


    static void printProduct(String name, int price) {
        System.out.println("Товар: " + name + " Цена " + price);
    }

    static int calculateDiscount(int price, int dis){
        return price - (price * dis / 100);
    }


}
