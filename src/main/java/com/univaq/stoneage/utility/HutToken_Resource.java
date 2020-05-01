package com.univaq.stoneage.utility;

import java.io.Serializable;

//@Entity
//@Table(name = "huttoken_resource")
public class HutToken_Resource implements Serializable {

    private int id_token;
    private String resource_type;
    private int quantity;


    public HutToken_Resource() {
    }

    public int getId_token() {
        return id_token;
    }

    public void setId_token(int id_token) {
        this.id_token = id_token;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
