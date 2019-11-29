package com.example.common.parser.impl;

import com.example.common.bd.BDProduct;
import com.example.common.parser.JsonParser;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductParser extends JsonParser<BDProduct> /*implements Parser<BDProduct>*/ {
    public ProductParser() {
        super(BDProduct.class);
    }
}

//@ApplicationScoped
//public class ProductParser extends XmlParser<BDProduct> /*implements Parser<BDProduct>*/ {
//
//}
