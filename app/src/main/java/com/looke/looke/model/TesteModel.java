package com.looke.looke.model;

import java.io.Serializable;
import java.util.List;

public class TesteModel implements Serializable {

    private String id;
    private String type;
    private String name;
    private List<TesteModelTopping> topping;

    public TesteModel()
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TesteModelTopping> getTopping() {
        return topping;
    }

    public void setTopping(List<TesteModelTopping> topping) {
        this.topping = topping;
    }
}
