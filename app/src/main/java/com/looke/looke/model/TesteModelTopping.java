package com.looke.looke.model;

import java.io.Serializable;
import java.util.List;

public class TesteModelTopping implements Serializable {

    private String id;
    private String type;

    public TesteModelTopping()
    {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
