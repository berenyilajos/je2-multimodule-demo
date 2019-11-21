package com.example.demo.parser.manager;

import com.example.demo.bd.BDProduct;
import com.example.demo.bd.BDUser;
import com.example.demo.parser.interfaces.Parser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

@ApplicationScoped
public class ParsManager {

    @Inject
    private Parser<BDUser> userParser;

    @Inject
    private Parser<BDProduct> productParser;

    public BDUser parseUser(String path) throws Exception {
        InputStream input = new FileInputStream(Paths.get(path + userParser.getExtension()).toFile());
        return userParser.parse(input);
    }

    public void write(BDUser user, String path) throws Exception {
        OutputStream output = new FileOutputStream(Paths.get(path + userParser.getExtension()).toFile());
        userParser.write(user, output);
    }

    public BDProduct parseProduct(String path) throws Exception {
        InputStream input = new FileInputStream(Paths.get(path + productParser.getExtension()).toFile());
        return productParser.parse(input);
    }

    public void write(BDProduct product, String path) throws Exception {
        OutputStream output = new FileOutputStream(Paths.get(path + productParser.getExtension()).toFile());
        productParser.write(product, output);
    }


}
