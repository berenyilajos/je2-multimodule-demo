package com.example.demo.parser.impl;

import com.example.demo.bd.BDProduct;
import com.example.demo.parser.JsonParser;
import com.example.demo.parser.XmlParser;
import com.example.demo.parser.interfaces.Parser;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductParser extends JsonParser<BDProduct> /*implements Parser<BDProduct>*/ {
    public ProductParser() {
        super(BDProduct.class);
    }
}

//@Component
//public class ProductParser extends XmlParser<BDProduct> /*implements Parser<BDProduct>*/ {
//
//}
