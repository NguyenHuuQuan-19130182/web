package vn.edu.hcmuaf.fit.demo.beans;

public class Product {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private int price;
    private int sellPrice;
    private String description;
    private int quantity;
    private int quantitySold;
    private String img;
    private String color;
    private double weight;
    private double computer;
    public Product() {

    }

    public Product(String id, String name, int price, int sellPrice, String description, int quantity, int quantitySold,String img,String color,double weight,double computer) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.sellPrice = sellPrice;
        this.description = description;
        this.quantitySold = quantitySold;
        this.quantity = quantity;
        this.color = color;
        this.computer = computer;
        this.weight = weight;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getComputer() {
        return computer;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setComputer(double computer) {
        this.computer = computer;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // get total money
    public int getTotalMoney() {
        return quantitySold * price;
    }


}
