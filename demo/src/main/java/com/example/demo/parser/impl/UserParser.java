package com.example.demo.parser.impl;

import com.example.demo.bd.BDUser;
import com.example.demo.parser.JsonParser;
import com.example.demo.parser.XmlParser;
import com.example.demo.parser.interfaces.Parser;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserParser extends JsonParser<BDUser> /*implements Parser<BDUser>*/ {
    public UserParser() {
        super(BDUser.class);
    }
}

//@Component
//public class UserParser extends XmlParser<BDUser> /*implements Parser<BDUser>*/ {
//
//}