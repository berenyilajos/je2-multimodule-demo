package com.example.common.parser.impl;

import com.example.common.bd.BDUser;
import com.example.common.parser.JsonParser;

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
