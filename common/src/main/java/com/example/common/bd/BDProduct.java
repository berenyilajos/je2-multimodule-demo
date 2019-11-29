package com.example.common.bd;

import java.io.Serializable;
import java.math.BigDecimal;

public class BDProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BDProduct{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
