package com.xupt.shop.bean;

public class commodity {
    private int id;
    private String name;
    private int shop_id;
    private int price;
    private String img;
    private String introduct;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntroduct() {
        return introduct;
    }

    public void setIntroduct(String introduct) {
        this.introduct = introduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shop_id=" + shop_id +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", introduct='" + introduct + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
