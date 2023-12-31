package org.service;


public class User {
    private int id;
    private String username;
    private String password;
    private double balance;

    // Constructor
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = 1000;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

}
