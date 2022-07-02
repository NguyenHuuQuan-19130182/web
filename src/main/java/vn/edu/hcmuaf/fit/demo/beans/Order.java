package vn.edu.hcmuaf.fit.demo.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private  int id;
    private  User user;
    private List<Detail> details;
    private Date createAt;
    private Date updateAt;

    public Order(){

    }
    public  Order(int id,User user,List<Detail> details,Date createAt,Date updateAt){
        this.id = id;
        this.user = user;
        this.details = details;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
