package org.been;

public class Car {

    private int id;
    private String name;
    private String color;
    private int userId; // User ID si
    private int price;
    private boolean isInStore;


    public Car(int id, String name, String color, int userId, int price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.userId = userId;
        this.price = price;
        this.isInStore = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isInStore() {
        return isInStore;
    }

    public void setInStore(boolean inStore) {
        isInStore = inStore;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}

