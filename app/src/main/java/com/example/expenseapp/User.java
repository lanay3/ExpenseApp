package com.example.expenseapp;

public class User {
    private String username;
    private int id;
    private String password;

    private String email;

    public User(String name, String pass, int id, String email) {
        this.username = name;
        this.password = pass;
        this.id = id;
        this.email = email;

        this.id++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
