package com.example.app;

import com.example.demo.Demo;
import com.example.demo.bd.BDProduct;
import com.example.demo.bd.BDUser;
import com.example.demo.parser.manager.ParsManager;
import com.example.valami.Valami;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class App {
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
        bdUser.setEmail(name + "@example.com");
        String path = "valami";
        parsManager.write(bdUser, path);
        BDUser u = parsManager.parseUser(path);

        System.out.println("================*************=================");
        System.out.println(u);

        BDProduct product = new BDProduct();
        product.setName("Valaki22");
        product.setEmail("valaki22@example.com");
        String path2 = "valami2";
        parsManager.write(product, path2);
        BDProduct p = parsManager.parseProduct(path2);

        System.out.println("================*************=================");
        System.out.println(p);
    }

}
