package com.example.common.parser.impl;

import com.example.common.bd.BDUser;
import com.example.common.parser.XmlParser;

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
