package com.example.product;

public class CateModel {
    String CID;
    String cname;

    public CateModel(String CID, String cname) {
        this.CID = CID;
        this.cname = cname;

    }
    public CateModel() {

    }
    public String getCID() {
        return CID;
    }

    public String getCname() {
        return cname;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
