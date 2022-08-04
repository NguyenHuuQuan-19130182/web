package vn.edu.hcmuaf.fit.demo.beans;

import java.io.Serializable;

public class Catelogy implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    public Catelogy(){

    }
    public Catelogy(String id,String name){
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Catelogy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
