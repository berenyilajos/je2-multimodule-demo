package com.example.demo.parser.impl;

import com.example.demo.bd.BDUser;
import com.example.demo.parser.JsonParser;
import com.example.demo.parser.XmlParser;
import com.example.demo.parser.interfaces.Parser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "userParser")
public class UserParser extends JsonParser<BDUser> /*implements Parser<BDUser>*/ {
    public UserParser() {
        super(BDUser.class);
    }
}

//@ApplicationScoped
//public class UserParser extends XmlParser<BDUser> /*implements Parser<BDUser>*/ {
//
//}
