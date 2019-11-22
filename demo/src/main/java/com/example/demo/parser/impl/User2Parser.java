package com.example.demo.parser.impl;

import com.example.demo.bd.BDUser;
import com.example.demo.parser.JsonParser;
import com.example.demo.parser.XmlParser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

//@ApplicationScoped
//public class User2Parser extends JsonParser<BDUser> /*implements Parser<BDUser>*/ {
//    public User2Parser() {
//        super(BDUser.class);
//    }
//}

@ApplicationScoped
@Named(value = "user2Parser")
public class User2Parser extends XmlParser<BDUser> /*implements Parser<BDUser>*/ {

}
