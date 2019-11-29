package com.example.app;

import com.example.demo.Demo;
import com.example.common.bd.BDProduct;
import com.example.common.bd.BDUser;
import com.example.demo.parser.manager.ParsManager;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.valami.Valami;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.math.BigDecimal;

@ApplicationScoped
public class App {

    @Inject
    private UserService userService;

    @Inject
    private ProductService productService;

    @Inject
    private Demo demo;

    @Inject
    private Valami valami;

    @Inject
    private ParsManager parsManager;

    public void startup(@Observes ContainerInitialized event) throws Exception {
        System.out.println(demo.sayHello());
        System.out.println(valami.hello());

        String name = "valaki";
        BDUser bdUser = new BDUser();
        bdUser.setName(name);

        int i = 0;
        for (; i < 10; i++) {
            bdUser.setEmail(name + i + "@example.com");
            userService.addUser(bdUser);
        }

        System.out.println("Users: " + userService.getAllUsers());

        name = bdUser.getName() + --i;
        System.out.println("Users with name: " + name + " : " + userService.getUsersByName(name));
        String path = "valami";
        parsManager.write(bdUser, path);
        BDUser u = parsManager.parseUser(path);

        System.out.println("================*************=================");
        System.out.println(u);

        parsManager.write2(bdUser, path);
        u = parsManager.parseUser2(path);

        System.out.println("================*************=================");
        System.out.println("================*************=================");
        System.out.println(u);

        BDProduct product = new BDProduct();
        product.setName("Valami22");
        product.setPrice(BigDecimal.valueOf(1000));
        String path2 = "valami2";
        parsManager.write(product, path2);
        BDProduct p = parsManager.parseProduct(path2);

        System.out.println("================*************=================");
        System.out.println(p);

        System.out.println("================*************=================");
        System.out.println("================*************=================");
        System.out.println("================*************=================");

        for (int j = 1; j < 7; j++) {
            product.setPrice(product.getPrice().add(BigDecimal.valueOf(j)));
            productService.addProduct(product);
        }
        System.out.println(productService.getAllProducts());
    }

}
