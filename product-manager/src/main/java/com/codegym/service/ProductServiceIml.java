package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIml implements ProductService {
    private static Map<Integer,Product>productMap;
    static {
        productMap=new HashMap<>();
        productMap.put(1,new Product(1,"iphone5",10000,"apple"));
        productMap.put(2,new Product(2,"iphoneX",100000,"apple"));
        productMap.put(3,new Product(3,"oppo A5",40000,"oppo"));
        productMap.put(4,new Product(4,"huawel hono 5",34000,"huaweil"));
        productMap.put(5,new Product(5,"huweil hono 2",12455,"huaweil"));
        productMap.put(6,new Product(6,"xiaomi m3",40000,"xiaomi"));
        productMap.put(7,new Product(7,"xiaomi m9",90000,"xiaomi"));
    }
    @Override
    public List<Product> listAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
