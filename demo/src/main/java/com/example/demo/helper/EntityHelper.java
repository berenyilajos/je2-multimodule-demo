package com.example.demo.helper;


import com.example.demo.bd.BDProduct;
import com.example.demo.bd.BDUser;
import com.example.jpademo.entity.Product;
import com.example.jpademo.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityHelper {

    public static BDUser entityToBd(User user) {
        if (user == null) {
            return null;
        }
        BDUser bdUser = new BDUser();
        bdUser.setName(user.getName());
        bdUser.setEmail(user.getEmail());

        return bdUser;
    }

    public static BDProduct entityToBd(Product product) {
        if (product == null) {
            return null;
        }
        BDProduct bdProduct = new BDProduct();
        bdProduct.setName(product.getName());
        bdProduct.setPrice(product.getPrice());

        return bdProduct;
    }

    public static Optional<BDUser> entityToBd(Optional<User> userOptional) {
        User user = userOptional.orElse(null);
        if (user == null) {
            return Optional.empty();
        }
        BDUser bdUser = new BDUser();
        bdUser.setName(user.getName());
        bdUser.setEmail(user.getEmail());

        return Optional.of(bdUser);
    }

    public static List<BDUser> entityToBd(Iterable<User> users) {
        List<BDUser> bdUsers = new ArrayList<>();
        users.forEach(user -> bdUsers.add(entityToBd(user)));

        return bdUsers;
    }

    public static List<BDProduct> entityToBdProducts(Iterable<Product> products) {
        List<BDProduct> bdProducts = new ArrayList<>();
        products.forEach(product -> bdProducts.add(entityToBd(product)));

        return bdProducts;
    }

    public static User bdToEntity(BDUser bdUser) {
        if (bdUser == null) {
            return null;
        }
        User user = new User();
        user.setName(bdUser.getName());
        user.setEmail(bdUser.getEmail());

        return user;
    }

    public static Product bdToEntity(BDProduct bdProduct) {
        if (bdProduct == null) {
            return null;
        }
        Product product = new Product();
        product.setName(bdProduct.getName());
        product.setPrice(bdProduct.getPrice());

        return product;
    }

    public static List<User> bdToEntity(List<BDUser> bdUsers) {
        return bdUsers.stream().map(EntityHelper::bdToEntity).collect(Collectors.toList());
    }

    public static List<Product> bdToEntityProducts(List<BDProduct> bdProducts) {
        return bdProducts.stream().map(EntityHelper::bdToEntity).collect(Collectors.toList());
    }

}
