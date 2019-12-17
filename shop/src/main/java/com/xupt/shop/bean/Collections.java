package com.xupt.shop.bean;

public class Collections {
    private int id;
    private int user_id;
    private int commodity_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    @Override
    public String toString() {
        return "collection{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", commodity_id=" + commodity_id +
                '}';
    }
}
