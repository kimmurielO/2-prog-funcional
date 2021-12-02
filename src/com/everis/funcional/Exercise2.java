package com.everis.funcional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) {
        List<Product> shopping = List.of(
                new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
                new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
                new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
                new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
                new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
                new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));
        
        BigDecimal price;
        price = shopping.stream().map(x -> x.price.multiply(new BigDecimal(100+x.tax.percent)).divide(new BigDecimal(100))).reduce(new BigDecimal(0.0), BigDecimal::add);
        System.out.println(price);
        
        shopping.stream().map(p->p.name).sorted().filter(p->p.startsWith("C")).collect(Collectors.toList()).forEach(p->System.out.println(p));
        
    }
}