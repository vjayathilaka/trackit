package com.myproject.trackit.controller;

public class Test {

    public static void mainkkkkkk(String[] args) {

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(1);
        loginResponse.setName("vijitha");
        loginResponse.setUserRole("PM");

        System.out.println(loginResponse.getName());

    }
}

class LoginResponse {
    int userId;
    String name;
    String userRole;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
