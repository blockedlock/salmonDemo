package com.project.salmonDemo.classes;

import com.project.salmonDemo.interfaces.PriceParser;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;

import static com.project.salmonDemo.ProductDemo.print;

public class ProductStorage {
    private List<Product> products = new ArrayList<>();

    public int allId = 0;

    public void addProSto(Product product) {
        product.id = allId;
        products.add(product);
        allId++;
    }

    public void printProSto() {
        for (Product product : products) {
            System.out.println(product.name + product.price);
        }
    }

    public void updatePriceProSto(int index, int newprice) {
        Product p = products.get(index);
        p.price = newprice;
    }

    public void removeProSto(int index){
        products.remove(index);
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    public void checkprices(List<PriceParser> parsers) {
        for (Product product : products) {

            PriceParser choosen = null;

            for (PriceParser p : parsers) {
                if (p.supports(product.url)) {
                    choosen = p;
                    break;
                }
            }

            if (choosen == null) {
                continue;
            }

            int newPrice = choosen.parse(product.url);
            if (newPrice < product.price) {
                print("price decreased " + product.price + " to " + newPrice);
            }
            product.price = newPrice;
        }
    }
}
